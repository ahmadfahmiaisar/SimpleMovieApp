package inn.mroyek.myexamplemvvm.data.repository

import dagger.Reusable
import inn.mroyek.myexamplemvvm.data.MovieApiServices
import inn.mroyek.myexamplemvvm.model.PopularMovie
import io.reactivex.Flowable
import javax.inject.Inject

@Reusable
class MovieRepository @Inject constructor(private val services: MovieApiServices){
//    fun getMovie(): Flowable<List<PopularMovie>>
    fun getMovie(): Flowable<List<PopularMovie>> {
    return services.getMoviePopular()
        .flatMap { Flowable.fromIterable(it.results) }
        .map { it.transfrom() }
        .toList()
        .toFlowable()
}
}