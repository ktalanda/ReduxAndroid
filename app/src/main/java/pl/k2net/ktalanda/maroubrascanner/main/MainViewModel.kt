package pl.k2net.ktalanda.maroubrascanner.main

import pl.k2net.ktalanda.redux.ViewModel

data class MainViewModel(
        val swellList: List<SwellViewModel> = listOf(
                MainViewModel.SwellViewModel(0, 0, 0, "")
        )
) : ViewModel {
    data class SwellViewModel(
            val timestamp: Long,
            val height: Int,
            val period: Int,
            val direction: String
    )
}
