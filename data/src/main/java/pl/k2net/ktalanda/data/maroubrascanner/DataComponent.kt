package pl.k2net.ktalanda.data.maroubrascanner

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(DataModule::class))
interface DataComponent
