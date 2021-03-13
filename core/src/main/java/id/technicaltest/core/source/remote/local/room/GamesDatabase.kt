package id.technicaltest.core.source.remote.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import id.technicaltest.core.source.remote.local.entity.FavoriteGamesEntity
import id.technicaltest.core.source.remote.local.entity.GamesEntity
import id.technicaltest.core.utils.Converter

@Database(
    entities = [
        GamesEntity::class,
        FavoriteGamesEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class GamesDatabase : RoomDatabase() {
    abstract fun blownDao(): GamesDao
}