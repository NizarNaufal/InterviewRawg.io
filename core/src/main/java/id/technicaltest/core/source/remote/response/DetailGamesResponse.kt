package id.technicaltest.core.source.remote.response

import com.google.gson.annotations.SerializedName

data class DetailGamesResponse(

    @field:SerializedName("reviews_text_count")
    val reviewsTextCount: Int,

    @field:SerializedName("rating")
    val rating: Double,

    @field:SerializedName("description_raw")
    val description: String,

    @field:SerializedName("playtime")
    val playtime: Int,

    @field:SerializedName("rating_top")
    val ratingTop: Int,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("released")
    val released: String,

    @field:SerializedName("website")
    val website: String,

    @field:SerializedName("suggestions_count")
    val suggestionsCount: Int,

    @field:SerializedName("background_image")
    val backgroundImage: String,

    @field:SerializedName("name")
    val name: String,
)