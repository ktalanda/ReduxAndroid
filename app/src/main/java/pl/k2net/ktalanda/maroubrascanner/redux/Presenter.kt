package pl.k2net.ktalanda.maroubrascanner.redux

abstract class Presenter<out S: Store>(val store: S) {
    abstract fun update()
}
