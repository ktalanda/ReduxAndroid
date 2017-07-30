package pl.k2net.ktalanda.maroubrascanner.release

import dagger.Module
import dagger.Provides
import pl.k2net.ktalanda.data.MaroubraData
import pl.k2net.ktalanda.maroubrascanner.MockMaroubraData
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides @Singleton fun provideMaroubraData(): MaroubraData {
        return MockMaroubraData()
    }
}