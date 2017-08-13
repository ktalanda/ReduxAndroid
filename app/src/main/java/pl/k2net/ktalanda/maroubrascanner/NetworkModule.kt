package pl.k2net.ktalanda.maroubrascanner

import dagger.Module
import dagger.Provides
import pl.k2net.ktalanda.data.maroubrascanner.MaroubraData
import pl.k2net.ktalanda.data.maroubrascanner.MaroubraDataImplementation
import pl.k2net.ktalanda.domain.SurfForecast
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides @Singleton fun provideMaroubraData(): MaroubraData {
        val maroubraData = MaroubraDataImplementation()
        maroubraData.init(BuildConfig.MSW_API_KEY, true)
        return maroubraData
    }

    @Provides @Singleton fun provideSurfForecast(maroubraData: MaroubraData): SurfForecast {
        return SurfForecast(maroubraData)
    }
}