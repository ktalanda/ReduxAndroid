package pl.k2net.ktalanda.maroubrascanner.main

import pl.k2net.ktalanda.maroubrascanner.MaroubraStore
import pl.k2net.ktalanda.maroubrascanner.redux.Presenter

class MainPresenter(val view: ViewInterface) : Presenter<MaroubraStore>(store = MaroubraStore()) {

    override fun update() {
        view.setTitle(store.mainViewModel.mainTitle)
    }

    fun changeTitle() {
        store.dispatch(MainChangeTitleAction("DISPATCHED"))
                .subscribe({update()})
    }

    interface ViewInterface {
        fun setTitle(title: String)
    }
}
