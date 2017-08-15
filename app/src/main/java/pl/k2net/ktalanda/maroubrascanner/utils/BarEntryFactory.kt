package pl.k2net.ktalanda.maroubrascanner.utils

import com.github.mikephil.charting.data.BarEntry

object BarEntryFactory {

    fun create(x: Float, y: Float): BarEntry {
        return BarEntry(x, y)
    }
}
