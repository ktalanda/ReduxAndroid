package pl.k2net.ktalanda.redux.example

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder

class MainActivity : Activity(), MainPresenter.ViewInterface {

    @BindView(R.id.todoInput) lateinit var todoInputView: EditText
    @BindView(R.id.todoList) lateinit var todoListView: ListView

    private lateinit var unbinder: Unbinder

    private val presenter: MainPresenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        unbinder = ButterKnife.bind(this)

        presenter.bind(this)
    }

    override fun onDestroy() {
        unbinder.unbind()
        presenter.unbind()

        super.onDestroy()
    }

    @OnClick(R.id.addTodo)
    fun addTodo() {
        presenter.addTodo(todoInputView.text.toString())
        todoInputView.text.clear()
    }

    override fun updateTodoList(todoList: List<String>) {
        todoListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todoList)
    }
}
