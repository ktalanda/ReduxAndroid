package pl.k2net.ktalanda.data.maroubrascanner.model

data class Condition(
        val pressure: Int,
        val temperature: Int,
        val weather: Int,
        val unitPressure: String,
        val unit: String
)