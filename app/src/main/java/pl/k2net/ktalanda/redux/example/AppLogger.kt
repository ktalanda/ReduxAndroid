package pl.k2net.ktalanda.redux.example

import android.util.Log
import pl.k2net.ktalanda.redux.ReduxLogger

object AppLogger : ReduxLogger {
    override fun info(title: String, message: String) {
        Log.d(title, message)
    }
}