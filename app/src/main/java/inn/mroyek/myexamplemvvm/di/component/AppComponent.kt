package inn.mroyek.myexamplemvvm.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjection
import dagger.android.AndroidInjectionModule
import inn.mroyek.myexamplemvvm.MyApp
import inn.mroyek.myexamplemvvm.di.factory.ViewModelFactory
import inn.mroyek.myexamplemvvm.di.module.*
import inn.mroyek.myexamplemvvm.ui.MovieViewModel
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ActivityModule::class,
//        FragmentModule::class,
        RepositoryModule::class
//        ViewModelModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApp): Builder
//        fun applicationContext(context: Context) : Builder

        fun build(): AppComponent
    }

    fun inject(app: MyApp)
    fun postViewModelFactory() : ViewModelFactory<MovieViewModel>
}
