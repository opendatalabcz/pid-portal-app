package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.model.Trip
import cvut.fit.pidmobapp.repository.AppRepository

class SaveFavouriteTripsAction(private val appRepository: AppRepository) {

    suspend fun execute(trips: List<Trip>) {
        return appRepository.saveFavouriteTrips(trips)
    }
}