package pl.k2net.ktalanda.maroubrascanner.main.details

import pl.k2net.ktalanda.domain.SurfCondition
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SurfDetailsMapper @Inject constructor() {
    fun mapSurfConditionToSurfDetailsViewModel(surfCondition: SurfCondition): DetailsViewModel.Element
            = DetailsViewModel.Element(
            surfCondition.time,
            surfCondition.swellHeight,
            surfCondition.period,
            surfCondition.direction,
            surfCondition.windSpeed,
            surfCondition.windDirection
    )
}
