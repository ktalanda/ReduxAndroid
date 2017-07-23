package pl.k2net.ktalanda.maroubrascanner.redux

interface Reducer {
    fun reduce(viewModel: ViewModel, action: Action): ViewModel
}