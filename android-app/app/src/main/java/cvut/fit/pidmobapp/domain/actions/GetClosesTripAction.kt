package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.model.response.TripResponse
import cvut.fit.pidmobapp.repository.AppRepository

class GetClosesTripAction(private val appRepository: AppRepository) {
    suspend fun execute(stopId: String, routeId: String): TripResponse? {
        return appRepository.getClosestTripByRouteId(stopId, routeId)
    }
}