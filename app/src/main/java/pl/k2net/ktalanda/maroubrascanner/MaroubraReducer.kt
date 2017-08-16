package pl.k2net.ktalanda.maroubrascanner

import pl.k2net.ktalanda.maroubrascanner.main.MainUpdateDataAction
import pl.k2net.ktalanda.maroubrascanner.main.MainViewModel
import pl.k2net.ktalanda.redux.Action
import pl.k2net.ktalanda.redux.Reducer
import pl.k2net.ktalanda.redux.ViewModel

object MaroubraReducer : Reducer {
    override fun reduce(viewModel: ViewModel, action: Action) : ViewModel {
        return when (action) {
            is MainUpdateDataAction -> {
                MainViewModel(action.updatedSwellData)
            }
            else -> {
                viewModel
            }
        }
    }
}
