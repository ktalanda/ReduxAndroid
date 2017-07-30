package pl.k2net.ktalanda.maroubrascanner.main

import android.app.Activity
import android.os.Bundle
import com.github.mikephil.charting.data.LineData
import kotlinx.android.synthetic.main.activity_main.*
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

        swellChart.setDrawGridBackground(true)
        swellChart.setDrawBorders(false)
        swellChart.description.isEnabled = false
        swellChart.axisLeft.setDrawGridLines(false)
        swellChart.axisLeft.setDrawLabels(false)
        swellChart.axisLeft.setDrawAxisLine(false)
        swellChart.axisRight.setDrawGridLines(false)
        swellChart.axisRight.setDrawLabels(false)
        swellChart.axisRight.setDrawAxisLine(false)
        swellChart.axisLeft.axisMinimum = 0.0f
        swellChart.axisLeft.setDrawGridLines(false)

        presenter.update()
    }

    override fun updateDataSet(data: LineData) {
        swellChart.data = data
    }
}