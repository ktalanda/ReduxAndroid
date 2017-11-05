package pl.k2net.ktalanda.data.maroubrascanner

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import pl.k2net.ktalanda.data.maroubrascanner.model.Condition

@Database(entities = arrayOf(Condition::class), version = 1, exportSchema = false)
abstract class Database : RoomDatabase()