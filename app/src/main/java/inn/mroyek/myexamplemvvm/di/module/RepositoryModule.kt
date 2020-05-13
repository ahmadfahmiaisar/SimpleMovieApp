package inn.mroyek.myexamplemvvm.di.module

import dagger.Module
import dagger.Provides
import inn.mroyek.myexamplemvvm.data.repository.MovieRepository
import inn.mroyek.myexamplemvvm.data.repository.MovieRepositoryImpl
import javax.inject.Singleton

@Module
object RepositoryModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideRepository(repository: MovieRepositoryImpl) : MovieRepository = repository
}