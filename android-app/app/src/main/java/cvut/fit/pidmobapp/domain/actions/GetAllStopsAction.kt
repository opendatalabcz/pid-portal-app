package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.repository.AppRepository
import cvut.fit.pidmobapp.model.Stop

class GetAllStopsAction(private val appRepository: AppRepository) {

    suspend fun execute(): List<Stop> {
        return appRepository.getAllStops()
    }
}