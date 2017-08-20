package pl.k2net.ktalanda.maroubrascanner.main.chart

import pl.k2net.ktalanda.maroubrascanner.main.details.DetailsViewModel
import pl.k2net.ktalanda.redux.Action

class ShowDetailsAction(val updatedDetails: DetailsViewModel.Element) : Action {
    override fun type(): String {
        return DetailsViewModel.Element::class.toString()
    }
}
