package cz.fit.cvut.pidbackend.Model.Dto;

import cz.fit.cvut.pidbackend.Model.Route;

import java.sql.Timestamp;

public class RouteTimeDto {
    private Route route;
    private Timestamp expectedArrival;
    private int delaySec;

    public RouteTimeDto(Route route, Timestamp expectedArrival, int delaySec) {
        this.route = route;
        this.expectedArrival = expectedArrival;
        this.delaySec = delaySec;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Timestamp getExpectedArrival() {
        return expectedArrival;
    }

    public void setExpectedArrival(Timestamp expectedArrival) {
        this.expectedArrival = expectedArrival;
    }

    public int getDelaySec() {
        return delaySec;
    }

    public void setDelaySec(int delaySec) {
        this.delaySec = delaySec;
    }
}
