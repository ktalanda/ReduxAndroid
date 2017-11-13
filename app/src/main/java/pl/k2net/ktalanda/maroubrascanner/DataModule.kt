package pl.k2net.ktalanda.maroubrascanner

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.k2net.ktalanda.data.maroubrascanner.DataImpl
import pl.k2net.ktalanda.domain.data.Data
import javax.inject.Singleton

@Module
class DataModule(private val context: Context) {
    @Provides @Singleton fun provideData() : Data = DataImpl(context, BuildConfig.MSW_API_KEY)
}
