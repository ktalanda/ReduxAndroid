package pl.k2net.ktalanda.maroubrascanner.main

import com.nhaarman.mockito_kotlin.mock
import io.reactivex.subjects.PublishSubject
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import pl.k2net.ktalanda.data.model.Condition
import pl.k2net.ktalanda.data.model.Forecast
import pl.k2net.ktalanda.data.model.Swell
import pl.k2net.ktalanda.data.model.SwellComponent
import pl.k2net.ktalanda.data.model.Wind
import pl.k2net.ktalanda.maroubrascanner.utils.BarEntryFactory
import pl.k2net.ktalanda.redux.Store

class MainPresenterTest internal constructor() {

    lateinit var mainPresenter: MainPresenter

    @Before
    fun setUp() {
        val store = Store(mock(), PublishSubject.create(), mock())
        mainPresenter = MainPresenter(store, mock(), mock(), mock(), BarEntryFactory)
    }

    @Test
    fun givenValidForecast_whenMapForecastToSwellViewModel_shouldReturnValidViewModel() {
        val forecast = Forecast(
                1502463600,
                1502496000,
                1502452800,
                1,
                0,
                Swell(
                        1.15,
                        1.8,
                        "ft",
                        1,
                        2,
                        mapOf(
                                Pair("combined", SwellComponent(
                                        4.5,
                                        10,
                                        343.05,
                                        "SSE")
                                ),
                                Pair("primary", SwellComponent(
                                        2.5,
                                        10,
                                        345.38,
                                        "SSE")
                                ),
                                Pair("secondary", SwellComponent(
                                        0.9,
                                        8,
                                        231.63,
                                        "NE")
                                ),
                                Pair("tertiary", SwellComponent(
                                        3.5,
                                        5,
                                        51.73,
                                        "SW")
                                )
                        )),

                Wind(
                        21,
                        80,
                        "W",
                        8,
                        26,
                        "mph"
                ),
                Condition(
                        1017,
                        16,
                        10,
                        "mb",
                        "c"
                )
        )

        val actual = mainPresenter.mapForecastToSwellViewModel(forecast)
        val expected = MainViewModel.SwellViewModel(
                1502463600,
                4,
                10,
                "SSE"
        )

        Assert.assertEquals(expected, actual)
    }
}