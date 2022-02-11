package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.model.Route
import cvut.fit.pidmobapp.repository.AppRepository

class GetFavouriteRoutesAction(private val appRepository: AppRepository) {

    suspend fun execute(): List<Route> {
        return appRepository.getFavouriteRoutes()
    }
}