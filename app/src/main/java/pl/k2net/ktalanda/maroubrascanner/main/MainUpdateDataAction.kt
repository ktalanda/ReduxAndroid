package pl.k2net.ktalanda.maroubrascanner.main

import pl.k2net.ktalanda.redux.Action

class MainUpdateDataAction(val updatedSwellData: List<MainViewModel.SurfConditionViewModel>) : Action {
    override fun type(): String {
        return MainViewModel::class.toString()
    }
}
