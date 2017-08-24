package pl.k2net.ktalanda.maroubrascanner

import android.util.Log
import pl.k2net.ktalanda.redux.Logger

object AppLogger : Logger {
    override fun info(title: String, message: String) {
        Log.i(title, message)
    }
}
