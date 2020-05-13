package inn.mroyek.myexamplemvvm.ui

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import inn.mroyek.myexamplemvvm.data.repository.MovieRepository
import inn.mroyek.myexamplemvvm.model.PopularMovie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    private val disposable = CompositeDisposable()

    val movieState = MutableLiveData<MovieState>()

    fun loadMovie() {
//        this::onLoading
        disposable.add(
            repository.getMovie()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onLoadMovie, this::onError)
        )
    }

   /* private fun onLoading(status: Boolean){
        movieState.value = OnLoading(status)
    }*/

    private fun onLoadMovie(movie: List<PopularMovie>) {
        movieState.value = OnLoadMovieState(movie)

    }

    private fun onError(throwable: Throwable) {
        movieState.value = OnErrorState(throwable)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun dispose() {
        if (!disposable.isDisposed) disposable.dispose()
    }
}