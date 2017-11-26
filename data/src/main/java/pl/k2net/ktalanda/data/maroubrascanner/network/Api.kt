package pl.k2net.ktalanda.data.maroubrascanner.network

import io.reactivex.Maybe
import pl.k2net.ktalanda.data.maroubrascanner.network.model.Forecast
import retrofit2.http.GET

interface Api {
    @GET("forecast/?spot_id=1183&units=us")
    fun getMaroubraForecast(): Maybe<List<Forecast>>
}
