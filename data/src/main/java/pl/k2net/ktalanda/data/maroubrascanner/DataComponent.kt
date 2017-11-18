package pl.k2net.ktalanda.data.maroubrascanner

import dagger.Component
import pl.k2net.ktalanda.data.maroubrascanner.database.DatabaseModule
import pl.k2net.ktalanda.data.maroubrascanner.network.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(DataModule::class, NetworkModule::class, DatabaseModule::class))
interface DataComponent {
    fun inject(data: DataImpl)
}
