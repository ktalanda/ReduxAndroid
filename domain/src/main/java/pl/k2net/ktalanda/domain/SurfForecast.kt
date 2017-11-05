package pl.k2net.ktalanda.domain

import io.reactivex.Observable
import java.util.Date

class SurfForecast {

    fun getForecast(): Observable<SurfCondition> {
        return Observable.just(SurfCondition(Date(), 0.0,0,"",0,""))
    }
}
