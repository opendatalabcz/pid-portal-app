package cz.fit.cvut.pidbackend.Service;

import cz.fit.cvut.pidbackend.Model.Dto.TripVehicleDto;
import cz.fit.cvut.pidbackend.Model.Position;
import cz.fit.cvut.pidbackend.Model.Route;
import cz.fit.cvut.pidbackend.Model.Trip;
import cz.fit.cvut.pidbackend.Model.Vehicle;
import cz.fit.cvut.pidbackend.Repository.RouteRepository;
import cz.fit.cvut.pidbackend.Repository.TripRepository;
import cz.fit.cvut.pidbackend.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RouteService {

    @Autowired
    RouteRepository routeRepo;
    @Autowired
    TripRepository tripRepo;
    @Autowired
    VehicleRepository vehicleRepo;

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
}
