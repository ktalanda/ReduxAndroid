package pl.k2net.ktalanda.data.maroubrascanner

import android.content.Context
import io.reactivex.Observable
import pl.k2net.ktalanda.data.maroubrascanner.database.Database
import pl.k2net.ktalanda.data.maroubrascanner.database.DatabaseModule
import pl.k2net.ktalanda.data.maroubrascanner.database.model.SurfConditionEntity
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

    override fun getForecast(): Observable<SurfCondition> =
            retrofit.create(Api::class.java)
                    .getMaroubraForecast()
                    .flatMap { Observable.fromIterable(it) }
                    .buffer(4)
                    .map { it[0] }
                    .map {
                        SurfConditionEntity(
                                0,
                                it.localTimestamp,
                                (it.swell.minBreakingHeight + it.swell.maxBreakingHeight) / 2,
                                it.swell.components["combined"]!!.period,
                                it.swell.components["combined"]!!.compassDirection,
                                it.wind.speed,
                                it.wind.compassDirection)
                    }
                    .map {
                        logger.logInfo("Data", it.toString())
                        it
                    }
                    .map { it.toDomain() }
}
