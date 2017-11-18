package pl.k2net.ktalanda.maroubrascanner

import android.util.Log
import pl.k2net.ktalanda.domain.Logger

object AppLogger : Logger {
    override fun logInfo(tag: String, message: String) {
        Log.i(tag, message)
    }
}
