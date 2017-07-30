package pl.k2net.ktalanda.maroubrascanner.main

import pl.k2net.ktalanda.maroubrascanner.redux.ViewModel

class MainViewModel(
        val swellList: List<SwellViewModel> = listOf(
                MainViewModel.SwellViewModel(0, 1),
                MainViewModel.SwellViewModel(1, 3)
        )
) : ViewModel {
    class SwellViewModel(val timestamp: Long, val height: Int)
}