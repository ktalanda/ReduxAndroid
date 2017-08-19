package pl.k2net.ktalanda.maroubrascanner.main.chart

import pl.k2net.ktalanda.redux.ViewModel
import java.util.Date

data class ChartViewModel(
        val surfConditionList: List<SurfOverviewViewModel>
) : ViewModel {
    data class SurfOverviewViewModel(
            val date: Date,
            val height: Double
    )
}
