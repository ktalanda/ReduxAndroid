package pl.k2net.ktalanda.maroubrascanner.main

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import pl.k2net.ktalanda.data.MaroubraData
import pl.k2net.ktalanda.maroubrascanner.MaroubraStore
import pl.k2net.ktalanda.maroubrascanner.redux.Presenter
import javax.inject.Inject

class MainPresenter @Inject constructor() : Presenter<MaroubraStore, MainPresenter.ViewInterface>(store = MaroubraStore) {

    @Inject lateinit var maroubraData: MaroubraData

    override fun update() {
        view.setTitle(store.mainViewModel.mainTitle)
    }

    fun changeTitle() {
        store.dispatch(MainChangeTitleAction("DISPATCHED"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .andThen({ update() })
        maroubraData.getForecast()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = { Log.e("KAMIL", it.toString()) },
                        onError = { Log.e("KAMIL", it.toString()) },
                        onComplete = { Log.e("KAMIL", "") }
                )
    }

    interface ViewInterface {
        fun setTitle(title: String)
    }
}
