package id.technicaltest.core.source.remote.local.room

import androidx.paging.DataSource
import androidx.room.*
import id.technicaltest.core.source.remote.local.entity.FavoriteGamesEntity
import id.technicaltest.core.source.remote.local.entity.GamesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GamesDao {
    @Query("SELECT * FROM gamesEntity order by id desc")
    fun getGames(): Flow<List<GamesEntity>>

    @Query("SELECT * FROM gamesEntity where name like :search order by id desc")
    fun getSearchGames(search: String): Flow<List<GamesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGames(games: List<GamesEntity>)

    @Query("SELECT * FROM gamesEntity where id = :id")
    fun getDetailGames(id: Int): Flow<GamesEntity>

    @Update
    suspend fun updateDetailGames(games: GamesEntity)

    @Query("SELECT * From gamesEntity a join favoriteGamesEntity b on a.id = b.id")
    fun getListGamesFavorites(): DataSource.Factory<Int, GamesEntity>

    @Query("SELECT * FROM favoriteGamesEntity where id = :id")
    fun getGamesFavorite(id: Int): Flow<FavoriteGamesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteGame(favoriteGames: FavoriteGamesEntity)

    @Delete
    suspend fun deleteFavoriteGame(favoriteGames: FavoriteGamesEntity)
}