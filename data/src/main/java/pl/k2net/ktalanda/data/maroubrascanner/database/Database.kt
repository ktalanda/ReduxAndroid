package pl.k2net.ktalanda.data.maroubrascanner.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import pl.k2net.ktalanda.data.maroubrascanner.database.model.SurfConditionEntity

@Database(entities = arrayOf(SurfConditionEntity::class), version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun dao(): Dao
}
