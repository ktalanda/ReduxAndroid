package pl.k2net.ktalanda.data.maroubrascanner.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single
import pl.k2net.ktalanda.data.maroubrascanner.database.model.SurfConditionEntity

@Dao
interface Dao {
    @Query("SELECT * FROM SurfConditionEntity")
    fun getSurfCondition(): Single<List<SurfConditionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertForecast(entity: SurfConditionEntity)

    @Query("DELETE FROM SurfConditionEntity")
    fun clear()
}
