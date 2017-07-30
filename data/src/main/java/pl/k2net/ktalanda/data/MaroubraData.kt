package pl.k2net.ktalanda.data

import io.reactivex.Observable
import pl.k2net.ktalanda.data.model.Forecast

interface MaroubraData {
    fun init(key: String, isDebug: Boolean = false)
    fun getForecast(): Observable<Forecast>
}