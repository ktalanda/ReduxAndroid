package pl.k2net.ktalanda.data.maroubrascanner

import android.content.Context
import io.reactivex.Observable
import pl.k2net.ktalanda.data.maroubrascanner.database.Database
import pl.k2net.ktalanda.data.maroubrascanner.database.DatabaseModule
import pl.k2net.ktalanda.data.maroubrascanner.network.Api
import pl.k2net.ktalanda.data.maroubrascanner.network.NetworkModule
import pl.k2net.ktalanda.domain.Logger
import pl.k2net.ktalanda.domain.SurfCondition
import pl.k2net.ktalanda.domain.data.Data
import retrofit2.Retrofit
import javax.inject.Inject

class DataImpl(context: Context, key: String, logger: Logger) : Data {
    @Inject lateinit var retrofit: Retrofit
    @Inject lateinit var database: Database
    @Inject lateinit var logger: Logger

    init {
        DaggerDataComponent
                .builder()
                .dataModule(DataModule(logger))
                .networkModule(NetworkModule(key))
                .databaseModule(DatabaseModule(context))
                .build()
                .inject(this)
    }

    override fun getForecast(): Observable<List<SurfCondition>> =
            Observable.mergeDelayError(
                    database.dao().getSurfCondition()
                            .toObservable(),
                    retrofit.create(Api::class.java)
                            .getMaroubraForecast()
                            .doOnSuccess { database.dao().clear() }
                            .toObservable()
                            .map(ApiToDbMapper::mapForecastList)
                            .doOnNext({ it.forEach { database.dao().insertForecast(it) } })
            ).map {
                it.map { it.toDomain() }
            }
}
