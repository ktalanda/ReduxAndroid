package pl.k2net.ktalanda.maroubrascanner.main

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import pl.k2net.ktalanda.maroubrascanner.R

class MainActivity : Activity(), MainPresenter.ViewInterface {

    val presenter: MainPresenter = MainPresenter(this)

    override fun setTitle(title: String) {
        mainTitle.text = title
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeTitle.setOnClickListener {
            run { presenter.changeTitle() }
        }
    }
}
