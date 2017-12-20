package pl.k2net.ktalanda.redux.example

import pl.k2net.ktalanda.redux.Action
import pl.k2net.ktalanda.redux.Reducer
import pl.k2net.ktalanda.redux.ViewModel

object AppReducer : Reducer {
    override fun reduce(viewModel: ViewModel, action: Action): ViewModel {
        return when (action) {
            is AddTodoAction -> MainViewModel((viewModel as MainViewModel).todoList + action.todo)
            else -> viewModel
        }
    }
}