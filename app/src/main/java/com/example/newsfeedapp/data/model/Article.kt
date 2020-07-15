package  com.example.newsfeedapp.data.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Article(
    @SerializedName("author")
    val author: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("title")
    val title: String?,
    @NonNull
    @PrimaryKey
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String? ) : Serializable