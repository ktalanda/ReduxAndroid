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
import javax.inject.Provider

class MainPresenter(
        store: Store,
        private val surfForecast: SurfForecast,
        private val dataSetProvider: Provider<BarDataSet>,
        private val dataProvider: Provider<BarData>,
        private val entryFactory: BarEntryFactory
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

    private fun mapValuesToLineData(swellList: List<MainViewModel.SurfConditionViewModel>): BarData {
        val result = dataProvider.get()
        val dataSet = dataSetProvider.get()
        dataSet.values = swellList.map { mapSwellViewModelToEntry(it) }
        result.addDataSet(dataSet)
        return result
    }

    private fun mapSwellViewModelToEntry(swellViewModel: MainViewModel.SurfConditionViewModel): BarEntry {
        val now = Date().time
        val timeHourDelta = (swellViewModel.date.time - now) / 60 / 60 / 1000

        return entryFactory.create(
                timeHourDelta.toFloat(),
                swellViewModel.height.toFloat())
    }

    fun mapSurfConditionToSwellViewModel(surfCondition: SurfCondition): MainViewModel.SurfConditionViewModel {
        return MainViewModel.SurfConditionViewModel(surfCondition.time,
                surfCondition.swellHeight,
                surfCondition.period,
                surfCondition.direction)
    }

    interface ViewInterface {
        fun updateDataSet(updatedData: BarData)
    }
}
