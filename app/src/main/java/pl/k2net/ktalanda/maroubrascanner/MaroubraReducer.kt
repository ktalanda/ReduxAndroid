package pl.k2net.ktalanda.maroubrascanner

import pl.k2net.ktalanda.maroubrascanner.main.MainChangeTitleAction
import pl.k2net.ktalanda.maroubrascanner.main.MainViewModel
import pl.k2net.ktalanda.maroubrascanner.redux.Action
import pl.k2net.ktalanda.maroubrascanner.redux.Reducer
import pl.k2net.ktalanda.maroubrascanner.redux.ViewModel

object MaroubraReducer : Reducer {
    override fun reduce(viewModel: ViewModel, action: Action) : ViewModel {
        when (action) {
            is MainChangeTitleAction -> {
                return MainViewModel(action.newTitle)
            }
            else -> {
                return viewModel
            }
        }
    }
}