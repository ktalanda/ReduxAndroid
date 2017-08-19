package pl.k2net.ktalanda.maroubrascanner

import pl.k2net.ktalanda.maroubrascanner.main.chart.UpdateChartDataAction
import pl.k2net.ktalanda.maroubrascanner.main.details.UpdateDetailsListAction
import pl.k2net.ktalanda.maroubrascanner.main.chart.ChartViewModel
import pl.k2net.ktalanda.maroubrascanner.main.details.DetailsViewModel
import pl.k2net.ktalanda.redux.Action
import pl.k2net.ktalanda.redux.Reducer
import pl.k2net.ktalanda.redux.ViewModel

object MaroubraReducer : Reducer {
    override fun reduce(viewModel: ViewModel, action: Action) : ViewModel {
        return when (action) {
            is UpdateChartDataAction -> {
                ChartViewModel(action.updatedSwellData)
            }
            is UpdateDetailsListAction -> {
                DetailsViewModel(action.updatedData)
            }
            else -> {
                viewModel
            }
        }
    }
}
