package id.technicaltest.core.domain.usecase

import androidx.paging.PagedList
import id.technicaltest.core.domain.FavoriteGames
import id.technicaltest.core.domain.Games
import id.technicaltest.core.domain.repository.IGamesRepository
import id.technicaltest.core.source.remote.local.Resource
import kotlinx.coroutines.flow.Flow

class GamesUseCase(private val iGamesRepository: IGamesRepository) : IGamesUseCase {
    override fun getGames(): Flow<Resource<List<Games>>> = iGamesRepository.getGames()

    override fun getDetailGame(gamesId: Int): Flow<Resource<Games>> =
        iGamesRepository.getDetailGame(gamesId)

    override fun getSearchGames(search: String): Flow<Resource<List<Games>>> =
        iGamesRepository.getSearchGames(search)

    override fun getListGamesFavorites(): Flow<PagedList<Games>> =
        iGamesRepository.getListGamesFavorites()

    override fun getGamesFavorite(favoriteGamesId: Int): Flow<FavoriteGames?> =
        iGamesRepository.getGamesFavorite(favoriteGamesId)

    override suspend fun insertFavoriteGame(favoriteGamesId: Int) =
        iGamesRepository.insertFavoriteGame(favoriteGamesId)

    override suspend fun deleteFavoriteGame(favoriteGamesId: Int) =
        iGamesRepository.deleteFavoriteGame(favoriteGamesId)
}