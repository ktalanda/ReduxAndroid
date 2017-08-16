package pl.k2net.ktalanda.maroubrascanner.main

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class HourAxisValueFormatterTest {

    lateinit var hourAxisValueFormatter: HourAxisValueFormatter

    @Before
    fun setUp() {
        hourAxisValueFormatter = HourAxisValueFormatter(1502887485000)
    }

    @Test
    fun givenPositiveInputValue_whenGetFormattedValue_shouldReturnCorrectDate() {
        val actual = hourAxisValueFormatter.getFormattedValue(10f, null)
        Assert.assertEquals("17/08/17", actual)
    }

    @Test
    fun givenNegativeInputValue_whenGetFormattedValue_shouldReturnCorrectDate() {
        val actual = hourAxisValueFormatter.getFormattedValue(-30f, null)
        Assert.assertEquals("15/08/17", actual)
    }
}