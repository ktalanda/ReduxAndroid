package pl.k2net.ktalanda.maroubrascanner.main.chart

import com.github.mikephil.charting.data.BarEntry
import java.util.Date

object BarEntryFactory {

    fun create(x: Float, y: Float, date: Date): BarEntry {
        return BarEntry(x, y, date)
    }
}
