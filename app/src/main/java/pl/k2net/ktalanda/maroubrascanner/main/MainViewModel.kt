package pl.k2net.ktalanda.maroubrascanner.main

import pl.k2net.ktalanda.redux.ViewModel

class MainViewModel(
        val swellList: List<SwellViewModel> = listOf(
                MainViewModel.SwellViewModel(0, 0)
        )
) : ViewModel {
    class SwellViewModel(val timestamp: Long, val height: Int)
}
