package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.model.Trip
import cvut.fit.pidmobapp.repository.AppRepository

class SaveFavouriteTripAction(private val appRepository: AppRepository) {

    suspend fun execute(trip: Trip, token: String) {
        return appRepository.saveFavouriteTrip(trip, token)
    }
}