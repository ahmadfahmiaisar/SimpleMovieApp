package inn.mroyek.myexamplemvvm.di.module

import android.app.Activity
import inn.mroyek.myexamplemvvm.di.component.AppComponent


interface DaggerComponentProvider {
    val appComponent: AppComponent
}
val Activity.injector: AppComponent get() = (application as DaggerComponentProvider).appComponent