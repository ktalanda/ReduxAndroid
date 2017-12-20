package pl.k2net.ktalanda.redux.example

import pl.k2net.ktalanda.redux.Action

class AddTodoAction(val todo: String): Action {
    override fun type(): String = MainViewModel::class.toString()
}