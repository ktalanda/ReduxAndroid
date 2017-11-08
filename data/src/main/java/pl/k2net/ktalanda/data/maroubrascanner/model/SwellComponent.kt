package pl.k2net.ktalanda.data.maroubrascanner.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class SwellComponent(
        @PrimaryKey val id: Int,
        val height: Double,
        val period: Int,
        val direction: Double,
        val compassDirection: String
)