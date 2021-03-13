package id.technicaltest.core.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Games(
    val suggestionsCount: Int? = null,
    val rating: Double? = null,
    val reviewsTextCount: Int? = null,
    val playtime: Int? = null,
    val backgroundImage: String? = null,
    val ratingTop: Int? = null,
    val name: String,
    val id: Int,
    val released: String? = null,
    val description: String? = null,
    val website: String? = null
) : Parcelable