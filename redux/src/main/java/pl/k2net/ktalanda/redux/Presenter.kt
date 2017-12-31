package pl.k2net.ktalanda.redux

import io.reactivex.disposables.Disposable

abstract class Presenter<V : Any>(val store: Store) {
    internal var updateActionList: MutableList<() -> Unit> = mutableListOf()

    lateinit var view: V
    lateinit var disposable: Disposable

    fun bind(view: V) {
        store.logger.info("Redux Presenter", "Binded.")
        this.view = view
        disposable = store.subscribe({ update() })
        update()
    }

    fun unbind() {
        store.logger.info("Redux Presenter", "Unbinded.")
        disposable.dispose()
    }

    fun addToUpdateList(action: () -> Unit) = updateActionList.add(action)

    internal fun update() {
        for (action in updateActionList) action()
        updateActionList = mutableListOf()
    }
}
