package cvut.fit.pidmobapp.model.response

import cvut.fit.pidmobapp.model.Route

data class RouteNextTripTimeResponse(
    val delayMin: Int,
    val expectedArrival: String,
    val route: Route
)