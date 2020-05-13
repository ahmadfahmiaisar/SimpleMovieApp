package inn.mroyek.myexamplemvvm.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import inn.mroyek.myexamplemvvm.R
import inn.mroyek.myexamplemvvm.di.module.injector
import inn.mroyek.myexamplemvvm.model.PopularMovie
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    /*@Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory
    private lateinit var movieViewModel : MovieViewModel*/
    private val movieViewModel: MovieViewModel by lazy {
        ViewModelProviders.of(this, injector.postViewModelFactory())
            .get(MovieViewModel::class.java)
    }

    private val movieAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        movieViewModel = ViewModelProviders.of(this, viewmodelFactory).get(MovieViewModel::class.java)
        initView()
        movieViewModel.loadMovie()
        Log.d("ERR HASIL", Gson().toJson(movieViewModel.loadMovie()))

        setupAllObserver()
    }

    private fun setupAllObserver() {
        movieViewModel.movieState.observe(this, Observer {
            when(it) {
//                is OnLoading -> funLoading(it.showProgress)
                is OnLoadMovieState -> funLoadMovie(it.movieList)
                is OnErrorState -> funError(it.throwable)
            }
        })
    }

    private fun funError(throwable: Throwable) {
        Log.d("ERROR WOY", Gson().toJson("$throwable"))
    }

    private fun funLoadMovie(movieList: List<PopularMovie>) {
        movieAdapter.clear()
        movieList.forEach {
            movieAdapter.add(MovieAdapter(it))
        }
        movieAdapter.notifyDataSetChanged()
        Log.d("ERR HASILNYA", Gson().toJson(movieList))

    }

    private fun funLoading(showProgress: Boolean) {
        Toast.makeText(this, "$showProgress", Toast.LENGTH_LONG).show()
    }

    private fun initView() {
        rv_movie.apply {
            layoutManager = GridLayoutManager(this@MovieActivity, 3)
            adapter = movieAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        movieViewModel.dispose()
    }
}
