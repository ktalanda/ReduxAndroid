package pl.k2net.ktalanda.maroubrascanner

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity(), MainDispatcher.ViewInterface {
    val dispatcher: MainDispatcher = MainDispatcher(this)

    override fun setTitle(title: String) {
        mainTitle.text = title
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeTitle.setOnClickListener {
            run {
                dispatcher.dispatch(MainChangeTitleAction("DISPATCHED"))
            }
        }
    }
}
