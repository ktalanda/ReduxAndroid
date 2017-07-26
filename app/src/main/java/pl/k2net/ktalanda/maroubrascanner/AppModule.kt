package pl.k2net.ktalanda.maroubrascanner

import dagger.Module
import dagger.Provides
import pl.k2net.ktalanda.data.MaroubraData
import pl.k2net.ktalanda.data.MaroubraDataImplementation
import javax.inject.Singleton

@Module
class AppModule(val app: App) {
    @Provides @Singleton fun provideApp() = app

    @Provides @Singleton fun provideMaroubraData(): MaroubraData {
        val maroubraData = MaroubraDataImplementation()
        maroubraData.init(BuildConfig.MSW_API_KEY, true)
        return maroubraData
    }
}
