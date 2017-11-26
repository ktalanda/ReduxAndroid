package pl.k2net.ktalanda.maroubrascanner.main.chart

import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import pl.k2net.ktalanda.domain.SurfCondition
import java.util.Date

class ChartMapperTest internal constructor() {

    private lateinit var chartMapper: ChartMapper

    @Before
    fun setUp() {
        chartMapper = ChartMapper(mock(), mock(), BarEntryFactory)
    }

    @Test
    fun givenValidSurfCondition_whenMapSurfConditionToSwellViewModel_shouldReturnValidViewModel() {
        val input = SurfCondition(
                Date(1502463600),
                4.5,
                10,
                "SSE",
                5,
                "SSE"
        )
        val actual = chartMapper.mapSurfConditionToChartViewModel(input)
        val expected = ChartViewModel.Element(
                Date(1502463600),
                4.5
        )
        Assert.assertEquals(expected, actual)
    }
}
