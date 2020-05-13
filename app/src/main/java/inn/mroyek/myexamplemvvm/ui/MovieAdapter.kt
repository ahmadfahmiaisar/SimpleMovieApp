package inn.mroyek.myexamplemvvm.ui

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import inn.mroyek.myexamplemvvm.R
import inn.mroyek.myexamplemvvm.model.PopularMovie
import inn.mroyek.myexamplemvvm.util.loadImageStr
import kotlinx.android.synthetic.main.item.view.*

class MovieAdapter (private val movie: PopularMovie) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            tv_title.text = movie.title
            iv_poster.loadImageStr("http://image.tmdb.org/t/p/w185${movie.poster}")
        }
    }

    override fun getLayout(): Int = R.layout.item

}