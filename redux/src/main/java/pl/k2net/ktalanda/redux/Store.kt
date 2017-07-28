package pl.k2net.ktalanda.maroubrascanner.redux

import io.reactivex.subjects.PublishSubject

abstract class Store(val reducer: Reducer) {
    val subject: PublishSubject<String> = PublishSubject.create()

    lateinit var map: Map<String, ViewModel>

    fun reduce(action: Action) {
        map = map.mapValues {
            if (action.type() == it.key) reducer.reduce(it.value, action)
            else it.value
        }
    }

    fun dispatch(action: Action) {
        reduce(action)
        subject.onNext("update")
    }
}
