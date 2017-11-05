package pl.k2net.ktalanda.data.maroubrascanner.model

data class Forecast(
        val timestamp: Long,
        val localTimestamp: Long,
        val issueTimestamp: Long,
        val fadedRating: Int,
        val solidRating: Int,
        val swell: Swell,
        val wind: Wind,
        val condition: Condition
)