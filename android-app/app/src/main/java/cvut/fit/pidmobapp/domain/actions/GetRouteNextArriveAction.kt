package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.model.dto.StopRouteNextTripTimeDto
import cvut.fit.pidmobapp.repository.AppRepository

class GetRouteNextArriveAction(private val appRepository: AppRepository) {

    suspend fun execute(stopUid: String): List<StopRouteNextTripTimeDto> {
        val routeNextTripTime = appRepository.getRoutesWithNextTrip(stopUid)
        val stopRouteNextTripTimeDto: MutableList<StopRouteNextTripTimeDto> = mutableListOf()
        for (r in routeNextTripTime) {
            stopRouteNextTripTimeDto.add(StopRouteNextTripTimeDto(stopUid, r.route, r.delayMin, r.expectedArrival))
        }
        return stopRouteNextTripTimeDto;
    }
}