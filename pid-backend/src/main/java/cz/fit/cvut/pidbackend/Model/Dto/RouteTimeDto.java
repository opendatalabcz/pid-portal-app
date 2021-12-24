package cz.fit.cvut.pidbackend.Model.Dto;

import cz.fit.cvut.pidbackend.Model.Route;

import java.sql.Timestamp;

public class RouteTimeDto {
    private Route route;
    private Timestamp expectedArrival;
    private int delayMin;

    public RouteTimeDto(Route route, Timestamp expectedArrival, int delayMin) {
        this.route = route;
        this.expectedArrival = expectedArrival;
        this.delayMin = delayMin;
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

    public int getDelayMin() {
        return delayMin;
    }

    public void setDelayMin(int delayMin) {
        this.delayMin = delayMin;
    }
}
