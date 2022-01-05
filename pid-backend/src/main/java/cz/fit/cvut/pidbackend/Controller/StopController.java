package cz.fit.cvut.pidbackend.Controller;

import cz.fit.cvut.pidbackend.Model.*;
import cz.fit.cvut.pidbackend.Model.Dto.RouteTimeDto;
import cz.fit.cvut.pidbackend.Model.Dto.TripVehicleDto;
import cz.fit.cvut.pidbackend.Service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/stop")
public class StopController {

    @Autowired
    StopService stopService;

    // get Stop by its ID
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Set<Stop>> getAll() {
        Set<Stop> stop = stopService.findAll();
        if (stop.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stop);
    }

    // get Stop by its ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Stop> getById(@PathVariable(value = "id") String id) {
        Optional<Stop> stop = stopService.findById(id);
        if (stop.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stop.get());
    }

    // get Stops by similar Name
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Set<Stop>> getByNameLike(@PathVariable(value = "name") String nameLike) {
        Set<Stop> stops = stopService.findByNameLike(nameLike);
        if (stops.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stops);
    }

    @RequestMapping(value = "/{id}/routes", method = RequestMethod.GET)
    public ResponseEntity<Set<Route>> getRoutes(@PathVariable(value = "id") String id) {
        Set<Route> routes = stopService.getRoutesForStop(id);
        if (routes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(routes);
    }

    @RequestMapping(value = "/{id}/routesTime", method = RequestMethod.GET)
    public ResponseEntity<Set<RouteTimeDto>> getRoutesWithTime(@PathVariable(value = "id") String id) {
        Set<RouteTimeDto> routes = stopService.getRoutesForStopWithTime(id);
        if (routes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(routes);
    }

    // get closest trip to a given stop
    @RequestMapping(value = "/{stopId}/{routeId}", method = RequestMethod.GET)
    public ResponseEntity<TripVehicleDto> getClosestTrip(@PathVariable(value = "stopId") String stopId,
                                               @PathVariable(value = "routeId") String routeId) {
        Optional<TripVehicleDto> trip = stopService.getClosestTripOfRoute(stopId, routeId);
        if (trip.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trip.get());
    }

    //mb redundant
    // get Stops in given area restricted by 2 points
//    @RequestMapping(value = "/{p1}/{p2}", method = RequestMethod.GET)
//    public ResponseEntity<Set<Stop>> getInArea(@PathVariable(value = "p1") Point p1,
//                                               @PathVariable(value = "p2") Point p2) {
//        Set<Stop> stops = stopService.getStopsInArea(p1, p2);
//        return ResponseEntity.ok(stops);
//    }
}
