package pl.k2net.ktalanda.data.maroubrascanner

import dagger.Module
import dagger.Provides
import pl.k2net.ktalanda.domain.Logger
import javax.inject.Singleton

@Module
class DataModule(val logger: Logger) {

    @Provides
    @Singleton
    fun provideLogger(): pl.k2net.ktalanda.domain.Logger = logger
}
