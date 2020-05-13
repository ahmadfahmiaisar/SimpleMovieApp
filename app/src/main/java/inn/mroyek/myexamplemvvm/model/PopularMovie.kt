package inn.mroyek.myexamplemvvm.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PopularMovie (
    val id : Int?,
    val title: String?,
    val poster : String?
) : Parcelable
