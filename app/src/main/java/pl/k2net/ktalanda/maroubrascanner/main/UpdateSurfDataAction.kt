package pl.k2net.ktalanda.maroubrascanner.main

import pl.k2net.ktalanda.maroubrascanner.main.chart.ChartViewModel
import pl.k2net.ktalanda.redux.Action

class UpdateSurfDataAction(val updatedSwellData: List<ChartViewModel.SurfOverviewViewModel>) : Action {
    override fun type(): String {
        return ChartViewModel::class.toString()
    }
}
