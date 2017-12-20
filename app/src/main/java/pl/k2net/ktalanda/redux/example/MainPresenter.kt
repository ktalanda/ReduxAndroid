package pl.k2net.ktalanda.redux.example

import io.reactivex.subjects.PublishSubject
import pl.k2net.ktalanda.redux.Presenter
import pl.k2net.ktalanda.redux.Store

class MainPresenter: Presenter<MainPresenter.ViewInterface>(
        Store(AppReducer, PublishSubject.create(), AppLogger, mapOf(
                MainViewModel::class.toString() to MainViewModel(listOf())
        ))
) {
    override fun update() =
        view.updateTodoList((store.state[MainViewModel::class.toString()] as MainViewModel).todoList)

    fun addTodo(todo: String) = store.dispatch(AddTodoAction(todo))

    interface ViewInterface {
        fun updateTodoList(todoList: List<String>)
    }
}
