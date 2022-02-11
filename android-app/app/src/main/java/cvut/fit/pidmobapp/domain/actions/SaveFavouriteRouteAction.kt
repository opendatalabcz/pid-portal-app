package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.model.Route
import cvut.fit.pidmobapp.repository.AppRepository

class SaveFavouriteRouteAction(private val appRepository: AppRepository) {

    suspend fun execute(route: Route, token: String) {
        return appRepository.saveFavouriteRoute(route, token)
    }
}