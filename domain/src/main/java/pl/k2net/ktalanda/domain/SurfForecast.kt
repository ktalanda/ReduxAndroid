package pl.k2net.ktalanda.domain

import io.reactivex.Observable
import pl.k2net.ktalanda.data.model.Forecast
import java.util.*

class SurfForecast {
    fun processForecast(forecastStream: Observable<Forecast>): Observable<SurfCondition> {
        return forecastStream.map { mapForecastToSurfCondition(it) }
    }

    fun mapForecastToSurfCondition(forecast: Forecast): SurfCondition {
        val date = Date(forecast.localTimestamp * 1000)
        val swellHeight = (forecast.swell.minBreakingHeight + forecast.swell.maxBreakingHeight).toDouble() / 2
        val period = forecast.swell.components["combined"]!!.period

        return SurfCondition(date, swellHeight, period)
    }
}
