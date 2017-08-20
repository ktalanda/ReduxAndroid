package pl.k2net.ktalanda.maroubrascanner.main.details

import pl.k2net.ktalanda.redux.Action

class UpdateDetailsListAction(val updatedData: List<DetailsViewModel.Element>) : Action {
    override fun type(): String {
        return DetailsViewModel::class.toString()
    }
}
