package pl.k2net.ktalanda.maroubrascanner.redux

import io.reactivex.Completable

abstract class Store(val reducer: Reducer) {
    abstract fun dispatch(action: Action): Completable
}
