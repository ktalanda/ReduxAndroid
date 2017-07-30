package pl.k2net.ktalanda.maroubrascanner.main

import pl.k2net.ktalanda.maroubrascanner.redux.Action

class MainUpdateDataAction(val updatedSwellData: List<MainViewModel.SwellViewModel>): Action {
    override fun type(): String {
        return MainViewModel::class.toString()
    }
}
