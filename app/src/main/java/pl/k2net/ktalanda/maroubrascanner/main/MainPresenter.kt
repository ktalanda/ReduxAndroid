package pl.k2net.ktalanda.maroubrascanner.main

import pl.k2net.ktalanda.maroubrascanner.MaroubraStore

class MainPresenter(val view: ViewInterface) {

    val store: MaroubraStore = MaroubraStore()

    fun changeTitle() {
        store.dispatch(MainChangeTitleAction("DISPATCHED"))
        update()
    }

    fun update() {
        view.setTitle(store.mainViewModel.mainTitle)
    }

    interface ViewInterface {
        fun setTitle(title: String)
    }
}