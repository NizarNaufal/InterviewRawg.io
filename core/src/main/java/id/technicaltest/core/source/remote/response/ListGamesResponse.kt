package id.technicaltest.core.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListGamesResponse(

    @field:SerializedName("results")
    val results: List<GamesResponse>
)