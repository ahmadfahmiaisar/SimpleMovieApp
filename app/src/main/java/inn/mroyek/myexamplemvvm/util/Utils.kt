package inn.mroyek.myexamplemvvm.util

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.loadImageStr(url: String?) {
    try {
        Glide.with(this.context)
            .load(url)
            .into(this)
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }
}
