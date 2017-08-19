package pl.k2net.ktalanda.maroubrascanner.main.chart

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import pl.k2net.ktalanda.domain.SurfCondition
import pl.k2net.ktalanda.maroubrascanner.utils.BarEntryFactory
import java.util.Date
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ChartMapper @Inject constructor(private val dataSetProvider: Provider<BarDataSet>,
                                      private val dataProvider: Provider<BarData>,
                                      private val entryFactory: BarEntryFactory) {

    fun mapSurfConditionToSurfOverviewViewModel(surfCondition: SurfCondition): ChartViewModel.SurfOverviewViewModel {
        return ChartViewModel.SurfOverviewViewModel(surfCondition.time,
                surfCondition.swellHeight)
    }

    fun mapValuesToData(swellList: List<ChartViewModel.SurfOverviewViewModel>): BarData {
        val result = dataProvider.get()
        val dataSet = dataSetProvider.get()
        dataSet.values = swellList.map { mapSwellViewModelToEntry(it) }
        result.addDataSet(dataSet)
        return result
    }

    private fun mapSwellViewModelToEntry(swellViewModel: ChartViewModel.SurfOverviewViewModel): BarEntry {
        val now = Date().time
        val timeHourDelta = (swellViewModel.date.time - now) / 60 / 60 / 1000

        return entryFactory.create(
                timeHourDelta.toFloat(),
                swellViewModel.height.toFloat())
    }
}