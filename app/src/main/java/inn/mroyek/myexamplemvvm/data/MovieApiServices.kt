package inn.mroyek.myexamplemvvm.data

import inn.mroyek.myexamplemvvm.data.remote.MovieResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface MovieApiServices {

    @GET("popular?api_key=ef2b66099a63d242660e26a77cd29a6b&language=en-US&page=1")
    fun getMoviePopular() : Flowable<MovieResponse>

}