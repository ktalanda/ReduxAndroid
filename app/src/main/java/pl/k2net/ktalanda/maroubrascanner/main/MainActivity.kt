package pl.k2net.ktalanda.maroubrascanner.main

import android.app.Activity
import android.os.Bundle
import com.github.mikephil.charting.data.BarData
import kotlinx.android.synthetic.main.activity_main.conditionTime
import kotlinx.android.synthetic.main.activity_main.refreshLayout
import kotlinx.android.synthetic.main.activity_main.swellChart
import pl.k2net.ktalanda.maroubrascanner.App
import pl.k2net.ktalanda.maroubrascanner.R
import pl.k2net.ktalanda.maroubrascanner.main.chart.HourAxisValueFormatter
import pl.k2net.ktalanda.maroubrascanner.main.details.DetailsViewModel
import javax.inject.Inject

class MainActivity : Activity(), MainPresenter.ViewInterface {
    @Inject lateinit var presenter: MainPresenter
    @Inject lateinit var valueFormatter: HourAxisValueFormatter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        (application as App).component.inject(this)
        presenter.bind(this)

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

    override fun updateDetails(updatedDetails: DetailsViewModel.Element) {
        conditionTime?.text = updatedDetails.direction
    }

}
