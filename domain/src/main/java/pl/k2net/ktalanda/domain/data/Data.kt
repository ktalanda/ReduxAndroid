package pl.k2net.ktalanda.domain.data

import io.reactivex.Observable
import pl.k2net.ktalanda.domain.SurfCondition

interface Data {
    fun getForecast() : Observable<SurfCondition>
}