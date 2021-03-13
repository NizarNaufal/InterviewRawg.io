package id.technicaltest.core.source.remote.local.entity

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gamesEntity")
data class GamesEntity(

    @Nullable
    val suggestionsCount: Int?,

    @Nullable
    val rating: Double?,

    @Nullable
    val reviewsTextCount: Int?,

    @Nullable
    val playtime: Int?,

    @Nullable
    val backgroundImage: String?,

    @Nullable
    val ratingTop: Int?,

    @NonNull
    val name: String,

    @PrimaryKey
    @NonNull
    val id: Int,

    @Nullable
    val released: String?,

    @Nullable
    val description: String?,

    @Nullable
    val website: String?
)