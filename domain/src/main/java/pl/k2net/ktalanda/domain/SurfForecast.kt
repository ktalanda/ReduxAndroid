package pl.k2net.ktalanda.domain

import io.reactivex.Observable
import pl.k2net.ktalanda.domain.data.Data

class SurfForecast(val data: Data) {
    fun getForecast(): Observable<SurfCondition> = data.getForecast()
}
