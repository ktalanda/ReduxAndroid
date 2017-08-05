package pl.k2net.ktalanda.maroubrascanner.main

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import pl.k2net.ktalanda.data.maroubrascanner.MaroubraData
import pl.k2net.ktalanda.data.model.Forecast
import pl.k2net.ktalanda.redux.Presenter
import pl.k2net.ktalanda.redux.Store
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class MainPresenter @Inject constructor(
        store: Store,
        val maroubraData: MaroubraData,
        val dataSetProvider: Provider<LineDataSet>,
        val dataLineProvider: Provider<LineData>,
        val entryProvider: Provider<Entry>
) : Presenter<MainPresenter.ViewInterface>(store) {

    init {
        refreshData()
    }

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

    fun mapValuesToLineData(swellList: List<MainViewModel.SwellViewModel>): LineData {
        val result = dataLineProvider.get()
        val dataSet = dataSetProvider.get()
        dataSet.values = swellList.map { mapSwellViewModelToEntry(it) }
        result.addDataSet(dataSet)
        return result
    }

    fun mapSwellViewModelToEntry(swellViewModel: MainViewModel.SwellViewModel): Entry {
        val entry = entryProvider.get()
        entry.x = swellViewModel.timestamp.toFloat()
        entry.y = swellViewModel.height.toFloat()
        return entry
    }

    fun mapForecastToSwellViewModel(forecast: Forecast): MainViewModel.SwellViewModel {
        return MainViewModel.SwellViewModel(
                forecast.timestamp,
                forecast.swell.components["primary"]!!.height.toInt()
        )
    }

    interface ViewInterface {
        fun updateDataSet(data: LineData)
    }
}
