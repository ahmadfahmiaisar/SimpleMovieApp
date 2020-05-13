package inn.mroyek.myexamplemvvm.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import inn.mroyek.myexamplemvvm.MyApp
import inn.mroyek.myexamplemvvm.data.MovieApiServices
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideAppContext(app: MyApp) : Context = app

    @JvmStatic
    @Singleton
    @Provides
    fun provideApplications(app: MyApp) : Application = app
/*
    @JvmStatic
    @Singleton
    @Provides
    fun provideMovieService(retrofit: Retrofit) = retrofit.create(MovieApiServices::class.java)*/
}