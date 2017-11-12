package pl.k2net.ktalanda.domain

import io.reactivex.Observable

interface SurfForecast {
    fun getForecast(): Observable<SurfCondition>
}
