package pl.k2net.ktalanda.domain

import io.reactivex.Observable
import pl.k2net.ktalanda.data.maroubrascanner.MaroubraData
import pl.k2net.ktalanda.data.maroubrascanner.model.Forecast
import java.util.Date

class SurfForecast(private val maroubraData: MaroubraData) {

    fun getForecast(): Observable<SurfCondition> {
        return processForecast(maroubraData.getForecast())
    }

    fun processForecast(forecastStream: Observable<Forecast>): Observable<SurfCondition> {
        return forecastStream.map { mapForecastToSurfCondition(it) }
                .buffer(4)
                .map { it[0] }
    }

    fun mapForecastToSurfCondition(forecast: Forecast): SurfCondition {
        val date = Date(forecast.localTimestamp * 1000)
        val swellHeight = (forecast.swell.minBreakingHeight + forecast.swell.maxBreakingHeight).toDouble() / 2
        val period = forecast.swell.components["combined"]!!.period
        val direction = forecast.swell.components["combined"]!!.compassDirection
        val windSpeed = forecast.wind.speed
        val windDirection = forecast.wind.compassDirection

        return SurfCondition(
                date,
                swellHeight,
                period,
                direction,
                windSpeed,
                windDirection)
    }
}
