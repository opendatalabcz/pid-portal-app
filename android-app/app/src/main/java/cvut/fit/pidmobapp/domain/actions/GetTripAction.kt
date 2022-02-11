package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.model.response.TripResponse
import cvut.fit.pidmobapp.repository.AppRepository


class GetTripAction(private val appRepository: AppRepository) {
    suspend fun execute(tripId: String): TripResponse? {
        return appRepository.getTripById(tripId)
    }
}