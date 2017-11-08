package pl.k2net.ktalanda.data.maroubrascanner.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Forecast(
        @PrimaryKey val id: Int,
        val timestamp: Long,
        val localTimestamp: Long,
        val issueTimestamp: Long,
        val fadedRating: Int,
        val solidRating: Int,
        val swell: Swell,
        val wind: Wind,
        val condition: Condition
)