package pl.k2net.ktalanda.redux

import io.reactivex.disposables.Disposable

abstract class Presenter<V : Any>(val store: Store) {
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

    abstract fun update()
}
