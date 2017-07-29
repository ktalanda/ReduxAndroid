package pl.k2net.ktalanda.maroubrascanner

import io.reactivex.Observable
import pl.k2net.ktalanda.data.MaroubraData
import pl.k2net.ktalanda.data.model.Condition
import pl.k2net.ktalanda.data.model.Forecast
import pl.k2net.ktalanda.data.model.Swell
import pl.k2net.ktalanda.data.model.Wind

class MockMaroubraData : MaroubraData {

    val forecast = Forecast(
            timestamp = 0,
            localTimestamp = 0,
            swell = Swell(minBreakingHeight = 0,
                    absMaxBreakingHeight = 0.0,
                    absMinBreakingHeight = 0.0,
                    maxBreakingHeight = 0,
                    unit = "ft",
                    components = hashMapOf()
            ),
            condition = Condition(pressure = 0, temperature = 0, weather = 0, unit = "C", unitPressure = "hPa"),
            issueTimestamp = 0,
            fadedRating = 0,
            solidRating = 0,
            wind = Wind(speed = 0, direction = 0, compassDirection = "W", chill = 0, gusts = 0, unit = "kmph")
    )


    override fun init(key: String, isDebug: Boolean) { }

    override fun getForecast(): Observable<Forecast> {
        return Observable.just(forecast)
    }
}