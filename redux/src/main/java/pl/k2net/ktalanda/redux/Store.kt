package pl.k2net.ktalanda.maroubrascanner.redux

import io.reactivex.subjects.PublishSubject

class Store(val reducer: Reducer, var state: Map<String, ViewModel>) {
    val subject: PublishSubject<String> = PublishSubject.create()

    fun reduce(action: Action) {
        state = state.mapValues {
            if (action.type() == it.key) reducer.reduce(it.value, action)
            else it.value
        }
    }

    fun dispatch(action: Action) {
        reduce(action)
        subject.onNext("update")
    }
}
