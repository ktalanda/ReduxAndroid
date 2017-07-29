package pl.k2net.ktalanda.maroubrascanner.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import pl.k2net.ktalanda.data.MaroubraData
import pl.k2net.ktalanda.maroubrascanner.redux.Presenter
import pl.k2net.ktalanda.maroubrascanner.redux.Store
import javax.inject.Inject

class MainPresenter @Inject constructor(store: Store) : Presenter<MainPresenter.ViewInterface>(store) {
    @Inject lateinit var maroubraData: MaroubraData

    override fun update() {
        view.setTitle((store.state[MainViewModel::class.toString()] as MainViewModel).mainTitle)
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
