package pl.k2net.ktalanda.maroubrascanner

import io.reactivex.Observable
import pl.k2net.ktalanda.data.MaroubraData
import pl.k2net.ktalanda.data.model.*

class MockMaroubraData : MaroubraData {

    val forecast = arrayOf(
            Forecast(
                    timestamp = 1501254000,
                    localTimestamp = 1501286400,
                    swell = Swell(
                            absMinBreakingHeight = 0.99,
                            absMaxBreakingHeight = 1.54,
                            unit = "ft",
                            minBreakingHeight = 1,
                            maxBreakingHeight = 2,
                            components = hashMapOf(

                                    "combined" to SwellComponent(
                                            height = 5.5,
                                            period = 8,
                                            direction = 351.24,
                                            compassDirection = "S"),
                                    "primary" to SwellComponent(
                                            height = 5.0,
                                            period = 8,
                                            direction = 358.02,
                                            compassDirection = "S"),
                                    "secondary" to SwellComponent(
                                            height = 1.4,
                                            period = 11,
                                            direction = 6.67,
                                            compassDirection = "S"
                                    ),
                                    "tertiary" to SwellComponent(
                                            height = 2.5,
                                            period = 5,
                                            direction = 75.38,
                                            compassDirection = "WSW"
                                    )
                            )
                    ),
                    condition = Condition(
                            pressure = 1021,
                            temperature = 14,
                            weather = 10,
                            unitPressure = "mb",
                            unit = "c"
                    ),
                    issueTimestamp = 1501243200,
                    fadedRating = 0,
                    solidRating = 1,
                    wind = Wind(
                            speed = 15,
                            direction = 67,
                            compassDirection = "WSW",
                            chill = 8,
                            gusts = 15,
                            unit = "mph"
                    )
            ),
            Forecast(

                    timestamp = 1501264800,
                    localTimestamp = 1501297200,
                    issueTimestamp = 1501243200,
                    fadedRating = 0,
                    solidRating = 1,
                    swell = Swell(
                            absMinBreakingHeight = 1.16,
                            absMaxBreakingHeight = 1.81,
                            unit = "ft",
                            minBreakingHeight = 1,
                            maxBreakingHeight = 2,
                            components = hashMapOf(
                                    "combined" to SwellComponent(
                                            height = 6.0,
                                            period = 9,
                                            direction = 354.83,
                                            compassDirection = "S"
                                    ),
                                    "primary" to SwellComponent(
                                            height = 5.5,
                                            period = 9,
                                            direction = 0.36000000000001,
                                            compassDirection = "S"
                                    ),
                                    "secondary" to SwellComponent(
                                            height = 2.0,
                                            period = 10,
                                            direction = 2.57,
                                            compassDirection = "S")

                            )),
                    wind = Wind(speed = 12,
                            direction = 68,
                            compassDirection = "WSW",
                            chill = 9,
                            gusts = 11,
                            unit = "mph"),
                    condition = Condition(
                            pressure = 1021,
                            temperature = 14,
                            weather = 10,
                            unitPressure = "mb",
                            unit = "c"

                    )
            ),
            Forecast(

                    timestamp = 1501275600,
                    localTimestamp = 1501308000,
                    issueTimestamp = 1501243200,
                    fadedRating = 0,
                    solidRating = 1,
                    swell = Swell(
                            absMinBreakingHeight = 1.27,
                            absMaxBreakingHeight = 1.99,
                            unit = "ft",
                            minBreakingHeight = 1,
                            maxBreakingHeight = 2,
                            components = hashMapOf(
                                    "combined" to SwellComponent(
                                            height = 6.0,
                                            period = 9,
                                            direction = 359.19,
                                            compassDirection = "S"
                                    ),
                                    "primary" to SwellComponent(
                                            height = 6.0,
                                            period = 9,
                                            direction = 0.25999999999999,
                                            compassDirection = "S"
                                    ),
                                    "secondary" to SwellComponent(
                                            height = 0.6,
                                            period = 12,
                                            direction = 255.77,
                                            compassDirection = "ENE"
                                    )
                            )
                    ),
                    wind = Wind(
                            speed = 12,
                            direction = 89,
                            compassDirection = "W",
                            chill = 9,
                            gusts = 11,
                            unit = "mph"
                    ),
                    condition = Condition(
                            pressure = 1022,
                            temperature = 13,
                            weather = 1,
                            unitPressure = "mb",
                            unit = "c"
                    )
            ),
            Forecast(
                    timestamp = 1501286400,
                    localTimestamp = 1501318800,
                    issueTimestamp = 1501243200,
                    fadedRating = 0,
                    solidRating = 1,
                    swell = Swell(
                            absMinBreakingHeight = 1.17,
                            absMaxBreakingHeight = 1.83,
                            unit = "ft",
                            minBreakingHeight = 1,
                            maxBreakingHeight = 2,
                            components = hashMapOf(
                                    "combined" to SwellComponent(
                                            height = 5.5,
                                            period = 9,
                                            direction = 2.29,
                                            compassDirection = "S"
                                    ),
                                    "primary" to SwellComponent(
                                            height = 5.5,
                                            period = 9,
                                            direction = 1.58,
                                            compassDirection = "S"
                                    ),
                                    "secondary" to SwellComponent(
                                            height = 0.6,
                                            period = 12,
                                            direction = 256.92,
                                            compassDirection = "ENE"
                                    )
                            )
                    ),
                    wind = Wind(
                            speed = 11,
                            direction = 114,
                            compassDirection = "WNW",
                            chill = 8,
                            gusts = 11,
                            unit = "mph"
                    ),
                    condition = Condition(
                        pressure = 1021,
                        temperature = 13,
                        weather = 1,
                        unitPressure = "mb",
                        unit = "c"
                    )
            )
    )

    override fun init(key: String, isDebug: Boolean) {}

    override fun getForecast(): Observable<Forecast> {
        return Observable.fromIterable(forecast.toList())
    }
}