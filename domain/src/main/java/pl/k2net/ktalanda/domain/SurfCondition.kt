package pl.k2net.ktalanda.domain

import java.util.*

data class SurfCondition(
        val time: Date,
        val swellHeight: Double,
        val period: Int
)