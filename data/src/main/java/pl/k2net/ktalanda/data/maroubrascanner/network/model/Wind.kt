package pl.k2net.ktalanda.data.maroubrascanner.network.model

data class Wind(
        val speed: Int,
        val direction: Int,
        val compassDirection: String,
        val chill: Int,
        val gusts: Int,
        val unit: String
)
