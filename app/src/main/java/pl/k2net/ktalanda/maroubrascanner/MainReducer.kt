package pl.k2net.ktalanda.maroubrascanner

class MainReducer {
    fun reduce(viewModel: MainViewModel, action: Action) : MainViewModel {

        when (action) {
            is MainChangeTitleAction -> {
                return MainViewModel(action.newTitle)
            }
            else -> {
                return viewModel
            }
        }
    }
}