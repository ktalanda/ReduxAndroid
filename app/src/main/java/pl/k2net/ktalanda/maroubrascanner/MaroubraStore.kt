package pl.k2net.ktalanda.maroubrascanner

import pl.k2net.ktalanda.maroubrascanner.main.MainViewModel
import pl.k2net.ktalanda.maroubrascanner.redux.Action
import pl.k2net.ktalanda.maroubrascanner.redux.Store

const val MAIN: String = "MAIN"

class MaroubraStore: Store(reducer = MaroubraReducer()) {
    var mainViewModel: MainViewModel

    init {
        mainViewModel = MainViewModel("Hello")
    }

    fun dispatch(action: Action) {
        when(action.type()) {
            MAIN -> {
                mainViewModel = reducer.reduce(mainViewModel, action) as MainViewModel
            }
        }
    }
}
