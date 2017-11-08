package pl.k2net.ktalanda.data.maroubrascanner.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Wind(
        @PrimaryKey val id: Int,
        val speed: Int,
        val direction: Int,
        val compassDirection: String,
        val chill: Int,
        val gusts: Int,
        val unit: String
)
