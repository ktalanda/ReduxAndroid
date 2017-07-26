package pl.k2net.ktalanda.maroubrascanner.redux

abstract class Presenter<out S: Store, V: Any>(val store: S) {

    lateinit var view: V

    fun bind(view: V) {
        this.view = view
    }

    abstract fun update()
}
