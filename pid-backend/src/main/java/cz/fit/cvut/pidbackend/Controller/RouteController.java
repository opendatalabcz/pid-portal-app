package cz.fit.cvut.pidbackend.Controller;

import cz.fit.cvut.pidbackend.Model.*;
import cz.fit.cvut.pidbackend.Model.Dto.RouteShapeVehicles;
import cz.fit.cvut.pidbackend.Model.Dto.TripVehicleDto;
import cz.fit.cvut.pidbackend.Service.RouteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/route")
public class RouteController {

    private static final Logger logger = LogManager.getLogger(RouteController.class);

    @Autowired
    RouteService routeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Route> getById(@PathVariable(value = "id") String id) {
        Optional<Route> route = routeService.findById(id);
        if (route.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(route.get());
    }

    @RequestMapping(value = "/{id}/trips", method = RequestMethod.GET)
    public ResponseEntity<RouteShapeVehicles> getByIdWithShapeAndTrips(@PathVariable(value = "id") String id) {
        Optional<RouteShapeVehicles> route = routeService.getByIdWithShapeAndTrips(id);
        if (route.isEmpty()) {
            logger.info("Route not found.");
            return ResponseEntity.notFound().build();
        }
        logger.info("ROUTE: " + route);
        return ResponseEntity.ok(route.get());
    }

    // get Routes by similar Name
    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
    public ResponseEntity<Set<Route>> getByNameLike(@PathVariable(value = "name") String nameLike) {
        Set<Route> routes = routeService.findByNameLike(nameLike);
        if (routes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(routes);
    }

    // get trips with vehicles' positions for given route
    @RequestMapping(value = "/{id}/trips_vehicles", method = RequestMethod.GET)
    public ResponseEntity<Set<TripVehicleDto>> getTripsWithVehicles(@PathVariable(value = "id") String id) {
        Set<TripVehicleDto> trips = routeService.getTripsForRouteWithVehicles(id);
        if (trips.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trips);
    }

    // get vehicles with positions for given route
    @RequestMapping(value = "/{id}/vehicles", method = RequestMethod.GET)
    public ResponseEntity<Set<Vehicle>> getVehicles(@PathVariable(value = "id") String id) {
        Set<Vehicle> vehicles = routeService.getVehiclesForRoute(id);
        if (vehicles.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicles);
    }
}
