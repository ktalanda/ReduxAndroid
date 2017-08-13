package pl.k2net.ktalanda.maroubrascanner.main

import com.nhaarman.mockito_kotlin.mock
import io.reactivex.subjects.PublishSubject
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import pl.k2net.ktalanda.domain.SurfCondition
import pl.k2net.ktalanda.domain.SurfForecast
import pl.k2net.ktalanda.maroubrascanner.utils.BarEntryFactory
import pl.k2net.ktalanda.redux.Store
import java.util.*

class MainPresenterTest internal constructor() {

    lateinit var mainPresenter: MainPresenter

    @Before
    fun setUp() {
        val store = Store(mock(), PublishSubject.create(), mock())
        mainPresenter = MainPresenter(store, SurfForecast(mock()), mock(), mock(), BarEntryFactory)
    }

    @Test
    fun givenValidSurfCondition_whenMapSurfConditionToSwellViewModel_shouldReturnValidViewModel() {
        val surfCondition = SurfCondition(
                Date(1502463600),
                4.5,
                10,
                "SSE"
        )
        val actual = mainPresenter.mapSurfConditionToSwellViewModel(surfCondition)
        val expected = MainViewModel.SurfConditionViewModel(
                Date(1502463600),
                4.5,
                10,
                "SSE"
        )
        Assert.assertEquals(expected, actual)
    }
}
