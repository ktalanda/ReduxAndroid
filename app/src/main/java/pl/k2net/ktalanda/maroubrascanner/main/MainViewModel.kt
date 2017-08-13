package pl.k2net.ktalanda.maroubrascanner.main

import pl.k2net.ktalanda.redux.ViewModel
import java.util.*

data class MainViewModel(
        val surfConditionList: List<SurfConditionViewModel> = listOf(
                MainViewModel.SurfConditionViewModel(Date(), 0.0, 0, "")
        )
) : ViewModel {
    data class SurfConditionViewModel(
            val date: Date,
            val height: Double,
            val period: Int,
            val direction: String
    )
}
