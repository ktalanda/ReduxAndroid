package pl.k2net.ktalanda.data.maroubrascanner

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class DataModule(val apiKey: String) {

    @Provides fun provideApiKey() = apiKey

    @Provides
    fun provideRetrofit(apiKey: String) : Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
                .baseUrl("http://magicseaweed.com/api/$apiKey/")
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideContext() : Context = App()

    @Provides
    fun provideDatabase(context: Context) : Database =
        Room.databaseBuilder(context, Database::class.java, "my-todo-db").allowMainThreadQueries().build()

}