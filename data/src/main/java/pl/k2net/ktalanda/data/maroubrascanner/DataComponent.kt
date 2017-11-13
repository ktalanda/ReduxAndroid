package pl.k2net.ktalanda.data.maroubrascanner

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetworkModule::class, DatabaseModule::class))
interface DataComponent {
    fun inject(data: DataImpl)
}
