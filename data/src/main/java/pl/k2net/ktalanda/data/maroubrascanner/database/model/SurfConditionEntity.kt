package pl.k2net.ktalanda.data.maroubrascanner.database.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import pl.k2net.ktalanda.domain.SurfCondition
import java.util.Date

@Entity
data class SurfConditionEntity(
        @PrimaryKey val id: Int,
        val timestamp: Long,
        val swellHeight: Double,
        val period: Int,
        val direction: String,
        val windSpeed: Int,
        val windDirection: String
) {
    fun toDomain() =
            SurfCondition(
                    Date(timestamp * 1000),
                    swellHeight,
                    period,
                    direction,
                    windSpeed,
                    windDirection
            )
}
