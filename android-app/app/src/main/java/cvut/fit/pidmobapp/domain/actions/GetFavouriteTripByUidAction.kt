package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.model.Trip
import cvut.fit.pidmobapp.repository.AppRepository

class GetFavouriteTripByUidAction(private val appRepository: AppRepository) {

    suspend fun execute(tripUid: String): Trip? {
        return appRepository.getFavouriteTripById(tripUid)
    }
}