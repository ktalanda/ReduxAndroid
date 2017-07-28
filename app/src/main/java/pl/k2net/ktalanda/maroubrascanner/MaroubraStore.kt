package pl.k2net.ktalanda.maroubrascanner

import pl.k2net.ktalanda.maroubrascanner.main.MainViewModel
import pl.k2net.ktalanda.maroubrascanner.redux.Store

object MaroubraStore : Store(reducer = MaroubraReducer) {
    init {
        map = hashMapOf(
                MainViewModel::class.toString() to MainViewModel("Hello")
        )
    }
}
