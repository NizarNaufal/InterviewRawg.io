package id.technicaltest.core.source.remote.network

import id.technicaltest.core.source.remote.response.DetailGamesResponse
import id.technicaltest.core.source.remote.response.ListGamesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    suspend fun getGames(
        @Query("key") key: String
    ): Response<ListGamesResponse>

    @GET("games/{id}")
    suspend fun getDetailGames(
        @Path("id") id: Int,
        @Query("key") key: String
    ): Response<DetailGamesResponse>

    @GET("games")
    suspend fun getSearchGames(
        @Query("key") key: String,
        @Query("search") search: String,
        @Query("search_precise") searchPrecise: Boolean
    ): Response<ListGamesResponse>
}