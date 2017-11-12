package pl.k2net.ktalanda.domain

import io.reactivex.Observable
import java.util.Date

class SurfForecastImpl : SurfForecast {

    override fun getForecast(): Observable<SurfCondition> {
        return Observable.just(
                SurfCondition(
                        Date(),
                        0.0,
                        0,
                        "SE",
                        0,
                        "SE"),
                SurfCondition(
                        Date(),
                        0.0,
                        0,
                        "SE",
                        0,
                        "SE")
        )
    }
}
