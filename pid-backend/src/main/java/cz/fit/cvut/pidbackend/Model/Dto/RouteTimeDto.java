package cz.fit.cvut.pidbackend.Model.Dto;

import cz.fit.cvut.pidbackend.Model.Route;

import java.sql.Time;
import java.sql.Timestamp;

public class RouteTimeDto {
    private Route route;
    private Time expectedArrival;
    private int delayMin;

    public RouteTimeDto(Route route, Time expectedArrival, int delayMin) {
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

    public Time getExpectedArrival() {
        return expectedArrival;
    }

    public void setExpectedArrival(Time expectedArrival) {
        this.expectedArrival = expectedArrival;
    }

    public int getDelayMin() {
        return delayMin;
    }

    public void setDelayMin(int delayMin) {
        this.delayMin = delayMin;
    }
}
