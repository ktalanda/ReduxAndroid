package pl.k2net.ktalanda.maroubrascanner.main.chart

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class HourAxisValueFormatterTest {

    private lateinit var hourAxisValueFormatter: HourAxisValueFormatter

    @Before
    fun setUp() {
        hourAxisValueFormatter = HourAxisValueFormatter(1502887485000)
    }

    @Test
    fun givenPositiveInputValue_whenGetFormattedValue_shouldReturnCorrectDate() {
        val actual = hourAxisValueFormatter.getFormattedValue(20f, null)
        Assert.assertEquals("Thu", actual)
    }

    @Test
    fun givenNegativeInputValue_whenGetFormattedValue_shouldReturnCorrectDate() {
        val actual = hourAxisValueFormatter.getFormattedValue(-30f, null)
        Assert.assertEquals("Tue", actual)
    }
}