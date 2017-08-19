package pl.k2net.ktalanda.maroubrascanner

import pl.k2net.ktalanda.maroubrascanner.main.UpdateSurfDataAction
import pl.k2net.ktalanda.maroubrascanner.main.chart.ChartViewModel
import pl.k2net.ktalanda.redux.Action
import pl.k2net.ktalanda.redux.Reducer
import pl.k2net.ktalanda.redux.ViewModel

object MaroubraReducer : Reducer {
    override fun reduce(viewModel: ViewModel, action: Action) : ViewModel {
        return when (action) {
            is UpdateSurfDataAction -> {
                ChartViewModel(action.updatedSwellData)
            }
            else -> {
                viewModel
            }
        }
    }
}
