package pl.k2net.ktalanda.data.maroubrascanner.model

data class Swell(
        val absMinBreakingHeight: Double,
        val absMaxBreakingHeight: Double,
        val unit: String,
        val minBreakingHeight: Double,
        val maxBreakingHeight: Double,
        val components: Map<String, SwellComponent>
)