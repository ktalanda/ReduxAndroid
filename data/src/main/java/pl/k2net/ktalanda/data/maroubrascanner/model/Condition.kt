package pl.k2net.ktalanda.data.maroubrascanner.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Condition(
        @PrimaryKey
        val pressure: Int,
        val temperature: Int,
        val weather: Int,
        val unitPressure: String,
        val unit: String
)