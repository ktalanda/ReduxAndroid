package pl.k2net.ktalanda.redux

import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

class Store(private val reducer: Reducer,
            private val subject: PublishSubject<String>,
            val logger: ReduxLogger,
            var state: Map<String, ViewModel>) {

    fun reduce(action: Action) {
        logger.info("Redux Store", "Action ${action.type()} reduced.")
        logger.info("Redux Store", "State before: $state")
        state = state.mapValues {
            if (action.type() == it.key) reducer.reduce(it.value, action)
            else it.value
        }

        logger.info("Redux Store", "State after: $state")
    }

    fun dispatch(action: Action) {
        logger.info("Redux Store", "Action ${action.type()} dispatched.")
        reduce(action)
        subject.onNext("update")
    }

    fun subscribe(doOnUpdate: () -> Unit): Disposable {
        logger.info("Redux Store", "Store update subscribed.")
        return subject.subscribe({ doOnUpdate() })
    }
}
