package pl.k2net.ktalanda.data.maroubrascanner

import io.reactivex.Observable
import pl.k2net.ktalanda.data.maroubrascanner.model.Forecast

interface MaroubraData {
    fun init(key: String, isDebug: Boolean = false)
    fun getForecast(): Observable<Forecast>
}
