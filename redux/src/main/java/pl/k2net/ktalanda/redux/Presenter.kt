package pl.k2net.ktalanda.maroubrascanner.redux

import io.reactivex.disposables.Disposable

abstract class Presenter<out S: Store, V: Any>(val store: S) {
    lateinit var view: V
    lateinit var disposable: Disposable

    fun bind(view: V) {
        this.view = view
        update()
        disposable = store.subject.subscribe { update() }
    }

    fun unbind() {
        disposable.dispose()
    }

    abstract fun update()
}
