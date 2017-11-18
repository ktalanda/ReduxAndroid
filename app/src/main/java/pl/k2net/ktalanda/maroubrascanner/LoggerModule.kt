package pl.k2net.ktalanda.maroubrascanner

import dagger.Module
import dagger.Provides
import pl.k2net.ktalanda.domain.Logger
import pl.k2net.ktalanda.redux.ReduxLogger
import javax.inject.Singleton

@Module
class LoggerModule {
    @Provides
    @Singleton
    fun provideAppLogger(): Logger = AppLogger

    @Provides
    @Singleton
    fun provideReduxLogger(appLogger: Logger): ReduxLogger =
            object : ReduxLogger {
                override fun info(title: String, message: String) = appLogger.logInfo("Redux", message)
            }
}
