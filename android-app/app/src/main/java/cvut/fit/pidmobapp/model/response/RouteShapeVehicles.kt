package cvut.fit.pidmobapp.model.response

import cvut.fit.pidmobapp.model.Route
import cvut.fit.pidmobapp.model.Shape
import cvut.fit.pidmobapp.model.Vehicle

data class RouteShapeVehicles(
    val route: Route,
    val routeShape: List<Shape>?,
    val vehicles: List<Vehicle>?
)