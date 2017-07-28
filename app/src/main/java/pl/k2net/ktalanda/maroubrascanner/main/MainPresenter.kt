package pl.k2net.ktalanda.maroubrascanner.main

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
        view.setTitle((store.map[MainViewModel::class.toString()] as MainViewModel).mainTitle)
    }

    fun changeTitle() {
        maroubraData.getForecast()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            store.dispatch(MainChangeTitleAction("" + it.timestamp))
                        }
                )
    }

    interface ViewInterface {
        fun setTitle(title: String)
    }
}
