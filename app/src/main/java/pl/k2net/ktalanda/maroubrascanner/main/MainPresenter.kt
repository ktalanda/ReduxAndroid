package pl.k2net.ktalanda.maroubrascanner.main

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import pl.k2net.ktalanda.data.maroubrascanner.MaroubraData
import pl.k2net.ktalanda.data.model.Forecast
import pl.k2net.ktalanda.maroubrascanner.utils.BarEntryFactory
import pl.k2net.ktalanda.redux.Presenter
import pl.k2net.ktalanda.redux.Store
import java.util.*
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class MainPresenter @Inject constructor(
        store: Store,
        val maroubraData: MaroubraData,
        val dataSetProvider: Provider<BarDataSet>,
        val dataProvider: Provider<BarData>,
        val entryFactory: BarEntryFactory
) : Presenter<MainPresenter.ViewInterface>(store) {

    override fun update() {
        view.updateDataSet(mapValuesToLineData(
                (store.state[MainViewModel::class.toString()] as MainViewModel).swellList))
    }

    fun refreshData() {
        maroubraData.getForecast()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            store.dispatch(MainUpdateDataAction(it.map { mapForecastToSwellViewModel(it) }))
                        }
                )
    }

    fun mapValuesToLineData(swellList: List<MainViewModel.SwellViewModel>): BarData {
        val result = dataProvider.get()
        val dataSet = dataSetProvider.get()
        dataSet.values = swellList.map { mapSwellViewModelToEntry(it) }
        result.addDataSet(dataSet)
        return result
    }

    fun mapSwellViewModelToEntry(swellViewModel: MainViewModel.SwellViewModel): BarEntry {

        val now = Date().time / 1000

        val h = (swellViewModel.timestamp - now) / 60 / 60

        val entry = entryFactory.create(
                h.toFloat(),
                swellViewModel.height.toFloat()
        )
        return entry
    }

    fun mapForecastToSwellViewModel(forecast: Forecast): MainViewModel.SwellViewModel {
        return MainViewModel.SwellViewModel(
                forecast.timestamp,
                forecast.swell.components["combined"]!!.height.toInt(),
                forecast.swell.components["combined"]!!.period,
                forecast.swell.components["combined"]!!.compassDirection
        )
    }

    interface ViewInterface {
        fun updateDataSet(data: BarData)
    }
}
