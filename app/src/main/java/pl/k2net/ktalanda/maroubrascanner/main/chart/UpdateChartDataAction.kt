package pl.k2net.ktalanda.maroubrascanner.main.chart

import pl.k2net.ktalanda.redux.Action

class UpdateChartDataAction(val updatedSwellData: List<ChartViewModel.Element>) : Action {
    override fun type(): String {
        return ChartViewModel::class.toString()
    }
}
