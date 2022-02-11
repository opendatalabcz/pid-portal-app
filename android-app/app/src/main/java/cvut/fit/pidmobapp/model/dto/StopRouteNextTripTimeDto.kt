package cvut.fit.pidmobapp.model.dto

import cvut.fit.pidmobapp.model.Route

data class StopRouteNextTripTimeDto(
    val stop: String,
    val route: Route,
    val delayMin: Int,
    val expectedArrival: String
)
