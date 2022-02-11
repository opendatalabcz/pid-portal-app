package cz.fit.cvut.pidbackend.Model.Dto;

import cz.fit.cvut.pidbackend.Model.Trip;
import lombok.Data;

@Data
public class TripDto {
    private String uid;
    private String routeId;
    private String shapeId;
    private String serviceId;
    private int direction;
    private int exceptional;
    private String headsign;
    private boolean wheelchair;
    private boolean bikesAllowed;
    private String blockId;

    public TripDto(Trip trip) {
        this.uid = trip.getUid();
        this.routeId = trip.getRoute().getId();
        this.shapeId = trip.getShapeId();
        this.serviceId = trip.getService().getUid();
        this.direction = trip.getDirection();
        this.exceptional = trip.getExceptional();
        this.headsign = trip.getHeadsign();
        this.wheelchair = trip.isWheelchair();
        this.bikesAllowed = trip.isBikesAllowed();
        this.blockId = trip.getBlockId();
    }
}
