package pl.k2net.ktalanda.data.maroubrascanner

import pl.k2net.ktalanda.data.maroubrascanner.database.model.SurfConditionEntity
import pl.k2net.ktalanda.data.maroubrascanner.network.model.Forecast

object ApiToDbMapper {
    fun mapForecastList(it: List<Forecast>): List<SurfConditionEntity> =
            it.filterIndexed { index, _ -> index % 4 == 0 }
                    .map(this::mapForecast)

    fun mapForecast(forecast: Forecast): SurfConditionEntity =
            SurfConditionEntity(
                    forecast.localTimestamp,
                    (forecast.swell.minBreakingHeight + forecast.swell.maxBreakingHeight) / 2,
                    forecast.swell.components["combined"]?.period ?: 0,
                    forecast.swell.components["combined"]?.compassDirection ?: "",
                    forecast.wind.speed,
                    forecast.wind.compassDirection)
}
