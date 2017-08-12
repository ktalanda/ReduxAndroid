package pl.k2net.ktalanda.data.model

data class Swell(
        val absMinBreakingHeight: Double,
        val absMaxBreakingHeight: Double,
        val unit: String,
        val minBreakingHeight: Int,
        val maxBreakingHeight: Int,
        val components: Map<String, SwellComponent>
)