package pl.k2net.ktalanda.maroubrascanner.main

import android.app.Activity
import android.os.Bundle
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

        changeTitle.setOnClickListener {
            run { presenter.changeTitle() }
        }
    }

    override fun setTitle(title: String) {
        mainTitle.text = title
    }
}
