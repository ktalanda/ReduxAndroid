package pl.k2net.ktalanda.maroubrascanner.main.chart

import pl.k2net.ktalanda.redux.ViewModel
import java.util.Date

data class ChartViewModel(
        val surfConditionList: List<Element>
) : ViewModel {
    data class Element(
            val date: Date,
            val height: Double
    )
}
