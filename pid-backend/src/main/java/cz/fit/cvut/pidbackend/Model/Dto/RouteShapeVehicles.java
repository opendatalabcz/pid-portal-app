package cz.fit.cvut.pidbackend.Model.Dto;

import cz.fit.cvut.pidbackend.Model.Route;
import cz.fit.cvut.pidbackend.Model.Shape;
import cz.fit.cvut.pidbackend.Model.Trip;
import cz.fit.cvut.pidbackend.Model.Vehicle;

import java.util.Set;

public class RouteShapeVehicles {
    private Route route;
    private Set<Shape> routeShape;
    private Set<Vehicle> vehicles;

    public RouteShapeVehicles() {
    }

    public RouteShapeVehicles(Route route, Set<Shape> shape, Set<Vehicle> trips) {
        this.route = route;
        this.routeShape = shape;
        this.vehicles = trips;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Set<Shape> getRouteShape() {
        return routeShape;
    }

    public void setRouteShape(Set<Shape> routeShape) {
        this.routeShape = routeShape;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
