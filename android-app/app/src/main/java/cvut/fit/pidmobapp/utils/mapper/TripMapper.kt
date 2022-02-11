package cvut.fit.pidmobapp.utils.mapper

import cvut.fit.pidmobapp.model.Trip
import cvut.fit.pidmobapp.model.dto.TripDto

class TripMapper {
    companion object {
        fun toTrip(
            tripDto: TripDto
        ): Trip {
            return Trip(
                uid = tripDto.uid,
                routeId = tripDto.route.uid,
                serviceId = "",
                shapeId = tripDto.shapeId,
                direction = tripDto.direction,
                exception = tripDto.exceptional,
                headsign = tripDto.headsign,
                wheelchair = tripDto.wheelchair,
                bikesAllowed = tripDto.bikesAllowed,
                blockId = tripDto.blockId,
            )
        }
    }
}