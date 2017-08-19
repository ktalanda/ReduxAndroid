package pl.k2net.ktalanda.maroubrascanner.main.details

import pl.k2net.ktalanda.redux.ViewModel
import java.util.Date

data class DetailsViewModel(
        val details: List<Element>
) : ViewModel {
    data class Element(
            val time: Date,
            val swellHeight: Double,
            val period: Int,
            val direction: String,
            val windSpeed: Int,
            val windDirection: String
    ) : ViewModel
}
