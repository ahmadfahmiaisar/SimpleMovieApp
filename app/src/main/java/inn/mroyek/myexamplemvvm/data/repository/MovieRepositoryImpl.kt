package inn.mroyek.myexamplemvvm.data.repository

import inn.mroyek.myexamplemvvm.data.MovieApiServices
import inn.mroyek.myexamplemvvm.model.PopularMovie
import io.reactivex.Flowable
import javax.inject.Inject
/*

class MovieRepositoryImpl @Inject constructor(private val services: MovieApiServices) : MovieRepository {
    override fun getMovie(): Flowable<List<PopularMovie>> {
        return services.getMoviePopular()
            .flatMap { Flowable.fromIterable(it.results) }
            .map { it.transfrom() }
            .toList()
            .toFlowable()
    }

}*/
