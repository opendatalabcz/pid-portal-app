package cvut.fit.pidmobapp.model.dto

import cvut.fit.pidmobapp.model.Route

data class TripDto(
    val uid: String,
    val route: Route,
    val direction: Int,
    val shapeId: String,
    val exceptional: Int,
    val wheelchair: Boolean,
    val headsign: String,
    val bikesAllowed: Boolean,
    val blockId: String,
)