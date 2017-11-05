package pl.k2net.ktalanda.data.maroubrascanner

import io.reactivex.Observable
import pl.k2net.ktalanda.data.maroubrascanner.model.Forecast
import retrofit2.http.GET

interface Api {
    @GET("forecast/?spot_id=1183&units=us")
    fun getMaroubraForecast(): Observable<List<Forecast>>
}
