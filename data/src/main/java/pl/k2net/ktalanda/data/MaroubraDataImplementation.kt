package pl.k2net.ktalanda.data

import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.k2net.ktalanda.data.model.Forecast
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class MaroubraDataImplementation : MaroubraData {
    private lateinit var retrofit: Retrofit

    override fun init(key: String, isDebug: Boolean) {
        val interceptor = HttpLoggingInterceptor()
        if (isDebug) interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        retrofit = Retrofit.Builder()
                .baseUrl("http://magicseaweed.com/api/$key/")
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    override fun getForecast(): Observable<List<Forecast>> {
        return retrofit.create(Api::class.java).getMaroubraForecast()
    }
}
