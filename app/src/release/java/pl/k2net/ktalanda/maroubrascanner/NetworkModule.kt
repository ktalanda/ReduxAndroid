package pl.k2net.ktalanda.maroubrascanner.release

import dagger.Module
import dagger.Provides
import pl.k2net.ktalanda.data.MaroubraData
import pl.k2net.ktalanda.data.MaroubraDataImplementation
import pl.k2net.ktalanda.maroubrascanner.BuildConfig
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides @Singleton fun provideMaroubraData(): MaroubraData {
        val maroubraData = MaroubraDataImplementation()
        maroubraData.init(BuildConfig.MSW_API_KEY, true)
        return maroubraData
    }
}