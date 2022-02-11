package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.model.Route
import cvut.fit.pidmobapp.repository.AppRepository

class GetFavouriteRouteByUidAction(private val appRepository: AppRepository) {

    suspend fun execute(routeUid: String): Route? {
        return appRepository.getFavouriteRouteById(routeUid)
    }
}