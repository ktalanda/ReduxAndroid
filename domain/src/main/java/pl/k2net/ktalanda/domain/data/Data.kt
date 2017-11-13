package pl.k2net.ktalanda.domain



interface Data {
    fun getForecast() : Observable<SurfCondition>
}