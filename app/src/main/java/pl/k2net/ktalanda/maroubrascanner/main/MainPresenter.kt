package pl.k2net.ktalanda.maroubrascanner.main

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import pl.k2net.ktalanda.domain.SurfCondition
import pl.k2net.ktalanda.domain.SurfForecast
import pl.k2net.ktalanda.maroubrascanner.utils.BarEntryFactory
import pl.k2net.ktalanda.redux.Presenter
import pl.k2net.ktalanda.redux.Store
import java.util.Date
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class MainPresenter @Inject constructor(
        store: Store,
        val surfForecast: SurfForecast,
        val dataSetProvider: Provider<BarDataSet>,
        val dataProvider: Provider<BarData>,
        val entryFactory: BarEntryFactory
) : Presenter<MainPresenter.ViewInterface>(store) {
    override fun update() {
        view.updateDataSet(mapValuesToLineData(
                (store.state[MainViewModel::class.toString()] as MainViewModel).surfConditionList))
    }

    fun refreshData() {
        surfForecast.getForecast()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { mapSurfConditionToSwellViewModel(it) }
                .collect({ mutableListOf<MainViewModel.SurfConditionViewModel>() }, { list, element -> list.add(element) })
                .subscribe(Consumer { store.dispatch(MainUpdateDataAction(it)) })
    }

    fun mapValuesToLineData(swellList: List<MainViewModel.SurfConditionViewModel>): BarData {
        val result = dataProvider.get()
        val dataSet = dataSetProvider.get()
        dataSet.values = swellList.map { mapSwellViewModelToEntry(it) }
        result.addDataSet(dataSet)
        return result
    }

    fun mapSwellViewModelToEntry(swellViewModel: MainViewModel.SurfConditionViewModel): BarEntry {
        val now = Date().time / 1000
        val h = (swellViewModel.date.time - now) / 60 / 60
        val entry = entryFactory.create(
                h.toFloat(),
                swellViewModel.height.toFloat()
        )
        return entry
    }

    fun mapSurfConditionToSwellViewModel(surfCondition: SurfCondition): MainViewModel.SurfConditionViewModel {
        return MainViewModel.SurfConditionViewModel(surfCondition.time, surfCondition.swellHeight, surfCondition.period, surfCondition.direction)
    }

    interface ViewInterface {
        fun updateDataSet(data: BarData)
    }
}
