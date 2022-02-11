package cvut.fit.pidmobapp.model.response

import cvut.fit.pidmobapp.model.Trip
import cvut.fit.pidmobapp.model.Shape
import cvut.fit.pidmobapp.model.Vehicle
import cvut.fit.pidmobapp.model.dto.DelayDto

data class TripResponse(
    val trip: Trip,
    val vehicle: Vehicle,
    val shapes: List<Shape>?,
    val delays: List<DelayDto>
)
