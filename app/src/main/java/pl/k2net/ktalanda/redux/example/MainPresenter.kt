package pl.k2net.ktalanda.redux.example

import io.reactivex.subjects.PublishSubject
import pl.k2net.ktalanda.redux.Presenter
import pl.k2net.ktalanda.redux.Store

class MainPresenter: Presenter<MainPresenter.ViewInterface>(
        Store(AppReducer, PublishSubject.create(), AppLogger, mapOf(
                MainViewModel::class.toString() to MainViewModel(listOf())
        ))
) {

    fun addTodo(todo: String) {
        addToUpdateList {
            view.updateTodoList((store.state[MainViewModel::class.toString()] as MainViewModel).todoList)
        }
        store.dispatch(AddTodoAction(todo))
    }

    interface ViewInterface {
        fun updateTodoList(todoList: List<String>)
    }
}
