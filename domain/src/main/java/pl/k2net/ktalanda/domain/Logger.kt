package pl.k2net.ktalanda.domain

interface Logger {
    fun logInfo(tag: String, message: String)
}