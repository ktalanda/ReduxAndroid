package pl.k2net.ktalanda.data

import io.reactivex.Observable
import pl.k2net.ktalanda.data.model.Forecast
import retrofit2.http.GET

interface Api {
    @GET("forecast/?spot_id=1183")
    fun getMaroubraForecast(): Observable<List<Forecast>>
}
