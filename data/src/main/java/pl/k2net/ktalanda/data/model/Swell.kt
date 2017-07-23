package pl.k2net.ktalanda.data.model

data class Swell(
        val minBreakingHeight: Int,
        val absMinBreakingHeight: Double,
        val maxBreakingHeight: Int,
        val absMaxBreakingHeight: Double,
        val unit: String,
        val components: Map<String, SwellComponent>
)