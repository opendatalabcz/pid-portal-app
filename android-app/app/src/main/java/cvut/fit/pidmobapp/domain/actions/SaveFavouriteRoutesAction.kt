package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.model.Route
import cvut.fit.pidmobapp.repository.AppRepository

class SaveFavouriteRoutesAction(private val appRepository: AppRepository) {

    suspend fun execute(routes: List<Route>) {
        return appRepository.saveFavouriteRoutes(routes)
    }
}