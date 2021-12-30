package cz.fit.cvut.pidbackend.Service;

import cz.fit.cvut.pidbackend.Controller.RouteController;
import cz.fit.cvut.pidbackend.Model.*;
import cz.fit.cvut.pidbackend.Model.Dto.RouteShapeVehicles;
import cz.fit.cvut.pidbackend.Model.Dto.TripVehicleDto;
import cz.fit.cvut.pidbackend.Repository.RouteRepository;
import cz.fit.cvut.pidbackend.Repository.ShapeRepository;
import cz.fit.cvut.pidbackend.Repository.TripRepository;
import cz.fit.cvut.pidbackend.Repository.VehicleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RouteService {
    private static final Logger logger = LogManager.getLogger(RouteService.class);
    @Autowired
    private RouteRepository routeRepo;
    @Autowired
    private TripRepository tripRepo;
    @Autowired
    private VehicleRepository vehicleRepo;
    @Autowired
    private ShapeRepository shapeRepo;

    public Optional<Route> findById(String id) {
        return routeRepo.findById(id);
    }

    public Set<Route> findByNameLike(String nameLike) {
        Set<Route> routes = routeRepo.findAllByShortNameIsLike(nameLike);
        if (routes == null)
            return new HashSet<>();
        return routes;
    }

    public Set<Trip> getTripsForRoute(String routeId) {
        Set<Trip> tripsForRoute = tripRepo.findAllByRoute_Id(routeId);
        if (tripsForRoute.isEmpty())
            return new HashSet<>();
        return tripsForRoute;
    }

    public Set<Vehicle> getVehiclesForRoute(String routeId) {
        Optional<Route> route = routeRepo.findById(routeId);
        if (route.isEmpty())
            return new HashSet<>();
        Set<Vehicle> vehicles = vehicleRepo.findAllByOriginRouteName(route.get().getShortName());
        if (vehicles.isEmpty())
            return new HashSet<>();
        return vehicles;
    }

    public Set<TripVehicleDto> getTripsForRouteWithVehicles(String id) {
        Set<Trip> trips = getTripsForRoute(id);
        Set<TripVehicleDto> tripVehicles = new HashSet<>();
        for (Trip trip : trips) {
            Optional<Vehicle> v = vehicleRepo.findById(trip.getUid());
            if (v.isEmpty()) continue;
            tripVehicles.add(new TripVehicleDto(trip, v.get()));
        }

        return tripVehicles;
    }

    public Optional<RouteShapeVehicles> getByIdWithShapeAndTrips(String id) {




        Optional<Route> route = findById(id);
        if (route.isEmpty()) {
            return Optional.empty();
        }
//        Set<Shape> shape = shapeRepo.findAllByUid_Uid(route.get().getShapeId());
//        if (shape.isEmpty()) {
//            shape.add(new Shape(new ShapeId("L9V2", 100000), 50.08377, 14.42812, 11.17199));
//            shape.add(new Shape(new ShapeId("L9V2", 100001), 50.08434, 14.42896, 11.25945));
////            return Optional.empty();
//        }
        Set<Vehicle> vehicles = vehicleRepo.findAllByOriginRouteName(route.get().getShortName());
        if (vehicles.isEmpty()) {
            return Optional.empty();
        }
        Optional<Trip> trip = tripRepo.findById(vehicles.iterator().next().getId());

        if (trip.isEmpty()) logger.warn("trip not found for vehicle: " + vehicles.iterator().next().getId());
        Set<Shape> shape = shapeRepo.findAllByUid_Uid(trip.get().getShapeId());

        return Optional.of(new RouteShapeVehicles(route.get(), shape, vehicles));
    }
}
