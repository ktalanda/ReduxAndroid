package pl.k2net.ktalanda.data.maroubrascanner.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Swell(
        @PrimaryKey val id: Int,
        val absMinBreakingHeight: Double,
        val absMaxBreakingHeight: Double,
        val unit: String,
        val minBreakingHeight: Double,
        val maxBreakingHeight: Double,
        val components: Map<String, SwellComponent>
)