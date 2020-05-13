package inn.mroyek.myexamplemvvm.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import inn.mroyek.myexamplemvvm.ui.MovieActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun movieActivity() : MovieActivity
}