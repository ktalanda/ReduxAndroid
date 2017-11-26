package pl.k2net.ktalanda.data.maroubrascanner

import org.junit.Assert
import org.junit.Test
import pl.k2net.ktalanda.data.maroubrascanner.database.model.SurfConditionEntity
import pl.k2net.ktalanda.data.maroubrascanner.network.model.Condition
import pl.k2net.ktalanda.data.maroubrascanner.network.model.Forecast
import pl.k2net.ktalanda.data.maroubrascanner.network.model.Swell
import pl.k2net.ktalanda.data.maroubrascanner.network.model.SwellComponent
import pl.k2net.ktalanda.data.maroubrascanner.network.model.Wind

class ApiToDbMapperTest {

    @Test
    fun givenEmptySwellCondition_whenMapForecast_shouldReturnDefaultValues() {
        val input = Forecast(
                0,
                0,
                0,
                0,
                0,
                Swell(0.0, 0.0, "", 0.0, 0.0, mapOf()),
                Wind(0, 0, "E", 1, 0, ""),
                Condition(0, 0, 0, "", "")
        )
        val actual = ApiToDbMapper.mapForecast(input)
        val expected = SurfConditionEntity(
                0,
                0.0,
                0,
                "",
                0,
                "E"
        )
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun givenCorrectForecast_whenMapForecast_shouldReturnCorrectData() {
        val input = Forecast(
                100,
                200,
                300,
                4,
                2,
                Swell(1.0, 2.0, "ft", 2.0, 3.0, mapOf(
                        Pair("combined", SwellComponent(1.2, 4, 2.1, "SE"))
                )),
                Wind(5, 0, "E", 1, 0, ""),
                Condition(0, 0, 0, "", "")
        )
        val actual = ApiToDbMapper.mapForecast(input)
        val expected = SurfConditionEntity(
                200,
                2.5,
                4,
                "SE",
                5,
                "E"
        )
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun givenListOfForecast_whenMapForecastList_shouldTakeEvery4thElement() {
        val forecastTemplate = Forecast(
                5,
                0,
                0,
                0,
                0,
                Swell(0.0, 0.0, "", 0.0, 0.0, mapOf()),
                Wind(0, 0, "", 1, 0, ""),
                Condition(0, 0, 0, "", "")
        )
        val surfConditionTemplate = SurfConditionEntity(
                0,
                0.0,
                0,
                "",
                0,
                ""
        )
        val input = listOf(
                forecastTemplate.copy(localTimestamp = 0L),
                forecastTemplate.copy(localTimestamp = 1L),
                forecastTemplate.copy(localTimestamp = 2L),
                forecastTemplate.copy(localTimestamp = 3L),
                forecastTemplate.copy(localTimestamp = 4L),
                forecastTemplate.copy(localTimestamp = 5L),
                forecastTemplate.copy(localTimestamp = 6L),
                forecastTemplate.copy(localTimestamp = 7L))
        val actual = ApiToDbMapper.mapForecastList(input)
        Assert.assertEquals(
                listOf(
                        surfConditionTemplate.copy(timestamp = 0L),
                        surfConditionTemplate.copy(timestamp = 4L)
                ),
                actual)
    }
}
