package pl.k2net.ktalanda.maroubrascanner

import pl.k2net.ktalanda.maroubrascanner.redux.Action
import pl.k2net.ktalanda.maroubrascanner.redux.Reducer
import pl.k2net.ktalanda.maroubrascanner.redux.ViewModel

object MaroubraReducer : Reducer {
    override fun reduce(viewModel: ViewModel, action: Action) : ViewModel {
        when (action) {
            else -> {
                return viewModel
            }
        }
    }
}
