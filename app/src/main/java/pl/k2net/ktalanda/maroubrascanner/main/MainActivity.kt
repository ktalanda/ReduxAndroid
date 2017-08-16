package pl.k2net.ktalanda.maroubrascanner.main

import android.app.Activity
import android.os.Bundle
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import kotlinx.android.synthetic.main.activity_main.refreshLayout
import kotlinx.android.synthetic.main.activity_main.swellChart
import pl.k2net.ktalanda.maroubrascanner.App
import pl.k2net.ktalanda.maroubrascanner.R
import javax.inject.Inject

class MainActivity : Activity(), MainPresenter.ViewInterface {
    @Inject lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        (application as App).component.inject(this)
        presenter.bind(this)

        swellChart.run {
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
            description.isEnabled = false
            isDoubleTapToZoomEnabled = false
            setPinchZoom(false)
            setScaleEnabled(false)
            setOnChartValueSelectedListener(ChartClick())
            setDrawGridBackground(true)
            setDrawBorders(false)
        }

        refreshLayout.setOnRefreshListener {
            presenter.refreshData()
            refreshLayout.isRefreshing = false
        }
    }

    override fun updateDataSet(updatedData: BarData) {
        swellChart.run {
            data = updatedData
            notifyDataSetChanged()
            invalidate()
        }
    }

    class ChartClick : OnChartValueSelectedListener {
        override fun onValueSelected(entry: Entry?, highlight: Highlight?) {
        }

        override fun onNothingSelected() {
        }
    }
}
