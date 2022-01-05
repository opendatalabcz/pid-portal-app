package cz.fit.cvut.pidbackend.Model.Dto;

import cz.fit.cvut.pidbackend.Model.Trip;


public class TripDto {
    private String uid;
    private String routeId;
    private String shapeId;
    private int direction;
    private int exceptional;
    private String headsign;
    private boolean wheelchair;
    private boolean bikesAllowed;
    private String blockId;

    public TripDto() {
    }

    public TripDto(Trip trip) {
        this.uid = trip.getUid();
        this.routeId = trip.getRoute().getId();
        this.shapeId = trip.getShapeId();
        this.direction = trip.getDirection();
        this.exceptional = trip.getExceptional();
        this.headsign = trip.getHeadsign();
        this.wheelchair = trip.isWheelchair();
        this.bikesAllowed = trip.isBikesAllowed();
        this.blockId = trip.getBlockId();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getShapeId() {
        return shapeId;
    }

    public void setShapeId(String shapeId) {
        this.shapeId = shapeId;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getExceptional() {
        return exceptional;
    }

    public void setExceptional(int exceptional) {
        this.exceptional = exceptional;
    }

    public String getHeadsign() {
        return headsign;
    }

    public void setHeadsign(String headsign) {
        this.headsign = headsign;
    }

    public boolean isWheelchair() {
        return wheelchair;
    }

    public void setWheelchair(boolean wheelchair) {
        this.wheelchair = wheelchair;
    }

    public boolean isBikesAllowed() {
        return bikesAllowed;
    }

    public void setBikesAllowed(boolean bikesAllowed) {
        this.bikesAllowed = bikesAllowed;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }
}
