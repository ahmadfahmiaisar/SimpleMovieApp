package inn.mroyek.myexamplemvvm.data.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import inn.mroyek.myexamplemvvm.model.PopularMovie
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieModel(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("genre_ids")
    val genreIds: List<Int>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("video")
    val video: Boolean?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("vote_count")
    val voteCount: Int?
) : Parcelable {
    fun transfrom(): PopularMovie {
        return PopularMovie(
            id = this.id,
            title = this.title,
            poster = this.posterPath
        )
    }
}