package cz.fit.cvut.pidbackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @Column(name = "uid")
    private String uid;

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "uid")
    private Route route;
    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "uid", insertable = false, updatable = false)
    @JsonIgnore
    private Service service;

    @Column(name = "shape_id")
    private String shapeId;
    @Column(name = "direction")
    private int direction;
    @Column(name = "exceptional")
    private int exceptional;
    @Column(name = "headsign")
    private String headsign;
    @Column(name = "wheelchair")
    private boolean wheelchair;
    @Column(name = "bikes_allowed")
    private boolean bikesAllowed;
    @Column(name = "block_id")
    private String blockId;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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

    public void setExceptional(int exception) {
        this.exceptional = exception;
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
