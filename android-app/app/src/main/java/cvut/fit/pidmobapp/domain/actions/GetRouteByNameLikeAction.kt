package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.repository.AppRepository
import cvut.fit.pidmobapp.model.Route

class GetRouteByNameLikeAction(private val appRepository: AppRepository) {

    suspend fun execute(requestText: String): List<Route>? {
        return appRepository.getRouteByNameLike(requestText)
    }
}