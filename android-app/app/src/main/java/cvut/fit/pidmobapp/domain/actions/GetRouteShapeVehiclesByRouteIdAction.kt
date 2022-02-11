package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.model.response.RouteShapeVehicles
import cvut.fit.pidmobapp.repository.AppRepository

class GetRouteShapeVehiclesByRouteIdAction(private val appRepository: AppRepository) {
    suspend fun execute(routeId: String): RouteShapeVehicles? {
        return appRepository.getTripByRouteId(routeId)
    }
}