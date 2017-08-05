package pl.k2net.ktalanda.maroubrascanner

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import dagger.Module
import dagger.Provides
import pl.k2net.ktalanda.maroubrascanner.main.MainViewModel
import pl.k2net.ktalanda.redux.Store
import javax.inject.Singleton

@Module
class AppModule(val app: App) {
    @Provides @Singleton fun provideApp() = app

    @Provides @Singleton fun provideStore(): Store {
        return Store(
                MaroubraReducer,
                hashMapOf(
                        MainViewModel::class.toString() to MainViewModel()
                )
        )
    }

    @Provides fun provideLineDataSet(): LineDataSet {
        val lineDataSet = LineDataSet(listOf(), "")
        lineDataSet.setDrawFilled(true)
        return lineDataSet
    }

    @Provides fun provideLineData(): LineData {
        return LineData()
    }

    @Provides fun provideEntry(): Entry {
        return Entry()
    }
}
