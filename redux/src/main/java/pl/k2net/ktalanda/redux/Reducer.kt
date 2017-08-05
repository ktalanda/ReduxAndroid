package pl.k2net.ktalanda.redux

interface Reducer {
    fun reduce(viewModel: ViewModel, action: Action): ViewModel
}
