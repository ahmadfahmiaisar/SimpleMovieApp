package inn.mroyek.myexamplemvvm.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import inn.mroyek.myexamplemvvm.di.factory.ViewModelFactory
import inn.mroyek.myexamplemvvm.ui.MovieViewModel
import inn.mroyek.myexamplemvvm.di.ViewModelKey

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    internal abstract fun provideMovieViewModel(viewModel: MovieViewModel) : ViewModel

}
