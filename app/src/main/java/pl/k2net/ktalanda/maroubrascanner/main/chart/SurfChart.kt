package pl.k2net.ktalanda.maroubrascanner.main.chart

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import pl.k2net.ktalanda.maroubrascanner.App
import java.util.Date
import javax.inject.Inject

class SurfChart : BarChart, SurfChartPresenter.ViewInterface {
    @Inject lateinit var valueFormatter: HourAxisValueFormatter
    @Inject lateinit var presenter: SurfChartPresenter

    constructor(context: Context?) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun init() {
        super.init()
        ((context as Activity).application as App).component.inject(this)
        presenter.bind(this)
        axisLeft.run {
            setDrawGridLines(false)
            setDrawLabels(false)
            setDrawAxisLine(false)
            axisMinimum = 0.0f
            setDrawGridLines(false)
        }
        axisRight.run {
            setDrawGridLines(false)
            setDrawLabels(false)
            setDrawAxisLine(false)
        }
        xAxis.valueFormatter = valueFormatter
        description.isEnabled = false
        isDoubleTapToZoomEnabled = false

        setPinchZoom(false)
        setScaleEnabled(false)
        setOnChartValueSelectedListener(ChartClick())
        setDrawGridBackground(true)
        setDrawBorders(false)
    }

    inner class ChartClick : OnChartValueSelectedListener {
        override fun onValueSelected(entry: Entry?, highlight: Highlight?) {
            presenter.showDetails(entry!!.data as Date)
        }

        override fun onNothingSelected() {
        }
    }
}
