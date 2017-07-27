package pl.k2net.ktalanda.maroubrascanner.redux

import io.reactivex.subjects.PublishSubject

abstract class Store(val reducer: Reducer) {
    val subject: PublishSubject<String> = PublishSubject.create()
    abstract fun reduce(action: Action)
    fun dispatch(action: Action) {
        reduce(action)
        subject.onNext("update")
    }
}
