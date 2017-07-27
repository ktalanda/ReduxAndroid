package pl.k2net.ktalanda.maroubrascanner

import pl.k2net.ktalanda.maroubrascanner.main.MainViewModel
import pl.k2net.ktalanda.maroubrascanner.redux.Action
import pl.k2net.ktalanda.maroubrascanner.redux.Store

object MaroubraStore : Store(reducer = MaroubraReducer) {

    var mainViewModel: MainViewModel = MainViewModel("Hello")

    override fun reduce(action: Action) {
        when (action.type()) {
            MAIN -> {
                mainViewModel = reducer.reduce(mainViewModel, action) as MainViewModel
            }
        }
    }
}
