package pl.k2net.ktalanda.maroubrascanner.main.chart

import pl.k2net.ktalanda.redux.Presenter
import pl.k2net.ktalanda.redux.Store
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SurfChartPresenter @Inject constructor(
        store: Store
) : Presenter<SurfChartPresenter.ViewInterface>(store) {
    override fun update() {
    }

    interface ViewInterface
}
