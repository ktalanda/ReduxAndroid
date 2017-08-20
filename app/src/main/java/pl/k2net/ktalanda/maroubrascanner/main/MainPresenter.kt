package pl.k2net.ktalanda.maroubrascanner.main

import com.github.mikephil.charting.data.BarData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import pl.k2net.ktalanda.domain.SurfForecast
import pl.k2net.ktalanda.maroubrascanner.main.chart.ChartMapper
import pl.k2net.ktalanda.maroubrascanner.main.chart.ChartViewModel
import pl.k2net.ktalanda.maroubrascanner.main.chart.UpdateChartDataAction
import pl.k2net.ktalanda.maroubrascanner.main.details.DetailsViewModel
import pl.k2net.ktalanda.maroubrascanner.main.details.SurfDetailsMapper
import pl.k2net.ktalanda.maroubrascanner.main.details.UpdateDetailsListAction
import pl.k2net.ktalanda.redux.Presenter
import pl.k2net.ktalanda.redux.Store

class MainPresenter(
        store: Store,
        private val surfForecast: SurfForecast,
        private val surfDetailsMapper: SurfDetailsMapper,
        private val chartMapper: ChartMapper
) : Presenter<MainPresenter.ViewInterface>(store) {
    override fun update() {
        view.updateDataSet(chartMapper.mapValuesToData(
                (store.state[ChartViewModel::class.toString()] as ChartViewModel).surfConditionList))
    }

    fun refreshData() {
        surfForecast.getForecast()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { surfDetailsMapper.mapSurfConditionToSurfDetailsViewModel(it) }
                .collect({ mutableListOf<DetailsViewModel.Element>() },
                        { list, element -> list.add(element) })
                .subscribe(Consumer {
                    store.dispatch(UpdateChartDataAction(it.map { chartMapper.mapSurfConditionToSurfOverviewViewModel(it) }))
                    store.dispatch(UpdateDetailsListAction(it))
                })
    }

    interface ViewInterface {
        fun updateDataSet(updatedData: BarData)
        fun updateDetails(updatedDetails: DetailsViewModel.Element)
    }
}
