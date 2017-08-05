package pl.k2net.ktalanda.redux

import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

class Store(val reducer: Reducer,
            val subject: PublishSubject<String>,
            var state: Map<String, ViewModel>) {

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

    fun subscribe(doOnUpdate: () -> Unit) : Disposable {
        return subject.subscribe({doOnUpdate()})
    }
}
