package pl.k2net.ktalanda.maroubrascanner

import dagger.Module
import dagger.Provides
import pl.k2net.ktalanda.domain.SurfForecast
import pl.k2net.ktalanda.domain.SurfForecastImpl
import javax.inject.Singleton

@Module
class DomainModule {
    @Provides @Singleton fun provideSurfForecast() : SurfForecast = SurfForecastImpl()
}
