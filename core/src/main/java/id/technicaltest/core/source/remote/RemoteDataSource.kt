package id.technicaltest.core.source.remote

import id.technicaltest.core.source.remote.network.ApiService
import kotlinx.coroutines.CoroutineDispatcher

class RemoteDataSource(
    private val apiService: ApiService,
    private val dispatcher: CoroutineDispatcher,
    private val key: String
) : BaseDataSource() {

    suspend fun getGames() = getResult({ apiService.getGames(key) }, dispatcher)

    suspend fun getDetailGames(gamesId: Int) =
        getResult({ apiService.getDetailGames(gamesId, key) }, dispatcher)

    suspend fun getSearchGames(search: String) =
        getResult({ apiService.getSearchGames(key, search, true) }, dispatcher)
}