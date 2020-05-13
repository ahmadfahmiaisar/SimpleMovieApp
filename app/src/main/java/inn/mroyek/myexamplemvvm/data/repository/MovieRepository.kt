package inn.mroyek.myexamplemvvm.data.repository

import inn.mroyek.myexamplemvvm.model.PopularMovie
import io.reactivex.Flowable

interface MovieRepository {
    fun getMovie(): Flowable<List<PopularMovie>>
}