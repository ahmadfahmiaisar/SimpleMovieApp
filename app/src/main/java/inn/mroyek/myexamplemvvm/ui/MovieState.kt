package inn.mroyek.myexamplemvvm.ui

import inn.mroyek.myexamplemvvm.model.PopularMovie

sealed class MovieState
data class OnLoadMovieState(val movieList: List<PopularMovie>) : MovieState()
data class OnErrorState(val throwable: Throwable) : MovieState()
//data class OnLoading(val showProgress: Boolean) : MovieState()