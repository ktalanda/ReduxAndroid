package pl.k2net.ktalanda.maroubrascanner.main

import pl.k2net.ktalanda.maroubrascanner.redux.Action

class MainChangeTitleAction(val newTitle: String): Action {
    override fun type(): String {
        return MainViewModel::class.toString()
    }
}
