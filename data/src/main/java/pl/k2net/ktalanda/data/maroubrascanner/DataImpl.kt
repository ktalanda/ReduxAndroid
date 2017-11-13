package pl.k2net.ktalanda.data.maroubrascanner

import android.content.Context
import io.reactivex.Observable
import pl.k2net.ktalanda.domain.SurfCondition
import pl.k2net.ktalanda.domain.data.Data
import retrofit2.Retrofit
import java.util.Date
import javax.inject.Inject

class DataImpl(context: Context, key: String) : Data {
    @Inject lateinit var retrofit: Retrofit

    init {
        DaggerDataComponent
                .builder()
                .networkModule(NetworkModule(key))
                .databaseModule(DatabaseModule(context))
                .build()
                .inject(this)
    }

    override fun getForecast(): Observable<SurfCondition> =
            retrofit.create(Api::class.java)
                    .getMaroubraForecast()
                    .flatMap { Observable.fromIterable(it) }
                    .buffer(4)
                    .map { it[0] }
                    .map {
                        SurfCondition(
                                Date(it.localTimestamp * 1000),
                                (it.swell.minBreakingHeight + it.swell.maxBreakingHeight).toDouble() / 2,
                                it.swell.components["combined"]!!.period,
                                it.swell.components["combined"]!!.compassDirection,
                                it.wind.speed,
                                it.wind.compassDirection)
                    }
}
