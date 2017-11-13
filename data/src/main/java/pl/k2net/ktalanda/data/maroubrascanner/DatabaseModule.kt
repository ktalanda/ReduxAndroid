package pl.k2net.ktalanda.data.maroubrascanner

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val context: Context) {

    @Provides @Singleton fun provideContext() = context

    @Provides
    @Singleton
    fun provideDatabase(context: Context) : Database =
            Room.databaseBuilder(context, Database::class.java, "maroubrascanner-db").allowMainThreadQueries().build()
}
