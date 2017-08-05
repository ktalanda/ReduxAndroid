package pl.k2net.ktalanda.maroubrascanner

import dagger.Component
import pl.k2net.ktalanda.maroubrascanner.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface AppComponent {
    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
}
