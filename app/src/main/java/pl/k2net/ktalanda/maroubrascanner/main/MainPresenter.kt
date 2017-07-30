package pl.k2net.ktalanda.maroubrascanner.main

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import pl.k2net.ktalanda.data.MaroubraData
import pl.k2net.ktalanda.maroubrascanner.redux.Presenter
import pl.k2net.ktalanda.maroubrascanner.redux.Store
import javax.inject.Inject
import javax.inject.Provider

class MainPresenter @Inject constructor(store: Store) : Presenter<MainPresenter.ViewInterface>(store) {
    @Inject lateinit var maroubraData: MaroubraData
    @Inject lateinit var dataSetProvider: Provider<LineDataSet>
    @Inject lateinit var dataLineProvider: Provider<LineData>
    @Inject lateinit var entryProvider: Provider<Entry>


    override fun update() {
        view.updateDataSet(mapValuesToLineData(
                (store.state[MainViewModel::class.toString()] as MainViewModel).swellList))
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

    fun mapValuesToLineData(swellList: List<MainViewModel.SwellViewModel>): LineData {
        val result = dataLineProvider.get()
        val dataSet = dataSetProvider.get()
        dataSet.values = swellList.map { mapSwellViewModelToEntry(it) }
        result.addDataSet(dataSet)
        return result
    }

    fun mapSwellViewModelToEntry(swellViewModel: MainViewModel.SwellViewModel): Entry {
        val entry = entryProvider.get()
        entry.x = swellViewModel.timestamp.toFloat()
        entry.y = swellViewModel.height.toFloat()
        return entry
    }

    interface ViewInterface {
        fun updateDataSet(data: LineData)
    }
}
