package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.repository.AppRepository
import cvut.fit.pidmobapp.model.Route

class GetRouteByIdAction(private val appRepository: AppRepository) {

    suspend fun execute(routeId: String): Route? {
        return appRepository.getRouteById(routeId)
    }
}