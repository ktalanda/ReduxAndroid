package pl.k2net.ktalanda.maroubrascanner

class MainDispatcher(val view: ViewInterface) {
    var viewModel: MainViewModel = MainViewModel("Hello")
    val reducer: MainReducer = MainReducer()

    fun update() {
        view.setTitle(viewModel.mainTitle)
    }

    fun dispatch(action: Action) {
        viewModel = reducer.reduce(viewModel, action)
        update()
    }

    interface ViewInterface {
        fun setTitle(title: String)
    }
}
