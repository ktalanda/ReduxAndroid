package pl.k2net.ktalanda.redux

import io.reactivex.disposables.Disposable

abstract class Presenter<V: Any>(val store: Store) {
    lateinit var view: V
    lateinit var disposable: Disposable

    fun bind(view: V) {
        this.view = view
        disposable = store.subscribe({update()})
        update()
    }

    fun unbind() {
        disposable.dispose()
    }

    abstract fun update()
}
