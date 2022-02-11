package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.model.Vehicle
import cvut.fit.pidmobapp.repository.AppRepository

class GetVehicleAction(private val appRepository: AppRepository) {
    suspend fun execute(vehicleId: String): Vehicle? {
        return appRepository.getVehicleById(vehicleId)
    }
}