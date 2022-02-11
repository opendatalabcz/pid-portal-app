package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.model.Trip
import cvut.fit.pidmobapp.repository.AppRepository

class GetFavouriteTripsAction(private val appRepository: AppRepository) {
    suspend fun execute(): List<Trip> {
        return appRepository.getFavouriteTrips()
    }
}