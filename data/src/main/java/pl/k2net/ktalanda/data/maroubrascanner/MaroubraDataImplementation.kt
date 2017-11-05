package pl.k2net.ktalanda.data.maroubrascanner

import io.reactivex.Observable
import pl.k2net.ktalanda.data.maroubrascanner.model.Forecast
import retrofit2.Retrofit
import javax.inject.Inject

class MaroubraDataImplementation : MaroubraData {

    @Inject lateinit var retrofit : Retrofit

    override fun init(key: String, isDebug: Boolean) {
        DaggerDataComponent
                .builder()
                .dataModule(DataModule(key))
                .build()
    }

    override fun getForecast(): Observable<Forecast> {
        return retrofit.create(Api::class.java)
                .getMaroubraForecast()
                .flatMap { Observable.fromIterable(it) }
    }
}
