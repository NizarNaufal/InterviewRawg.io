package id.technicaltest.core.domain.usecase

import androidx.paging.PagedList
import id.technicaltest.core.domain.FavoriteGames
import id.technicaltest.core.domain.Games
import id.technicaltest.core.source.remote.local.Resource
import kotlinx.coroutines.flow.Flow

interface IGamesUseCase {
    fun getGames(): Flow<Resource<List<Games>>>
    fun getDetailGame(gamesId: Int): Flow<Resource<Games>>
    fun getSearchGames(search: String): Flow<Resource<List<Games>>>
    fun getListGamesFavorites(): Flow<PagedList<Games>>
    fun getGamesFavorite(favoriteGamesId: Int): Flow<FavoriteGames?>
    suspend fun insertFavoriteGame(favoriteGamesId: Int)
    suspend fun deleteFavoriteGame(favoriteGamesId: Int)
}