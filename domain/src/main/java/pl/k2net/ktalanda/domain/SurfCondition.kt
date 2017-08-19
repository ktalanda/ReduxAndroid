package pl.k2net.ktalanda.domain

import java.util.Date

data class SurfCondition(
        val time: Date,
        val swellHeight: Double,
        val period: Int,
        val direction: String,
        val windSpeed: Int,
        val windDirection: String
)