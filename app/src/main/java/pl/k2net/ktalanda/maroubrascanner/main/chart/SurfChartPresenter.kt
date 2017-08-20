package pl.k2net.ktalanda.maroubrascanner.main.chart

import pl.k2net.ktalanda.maroubrascanner.main.details.DetailsViewModel
import pl.k2net.ktalanda.redux.Presenter
import pl.k2net.ktalanda.redux.Store
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SurfChartPresenter @Inject constructor(
        store: Store
) : Presenter<SurfChartPresenter.ViewInterface>(store) {
    override fun update() {
    }

    fun showDetails(date: Date) {
        val element = (store.state[DetailsViewModel::class.toString()] as DetailsViewModel).details.first { it.time == date }
        store.dispatch(ShowDetailsAction(element))
    }

    interface ViewInterface
}
