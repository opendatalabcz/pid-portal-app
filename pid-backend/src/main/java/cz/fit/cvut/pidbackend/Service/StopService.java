package cz.fit.cvut.pidbackend.Service;

import cz.fit.cvut.pidbackend.Model.*;
import cz.fit.cvut.pidbackend.Repository.RouteRepository;
import cz.fit.cvut.pidbackend.Repository.StopRepository;
import cz.fit.cvut.pidbackend.Repository.TripRepository;
import cz.fit.cvut.pidbackend.Repository.TripStopsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StopService {

    @Autowired
    private StopRepository stopRepo;
    @Autowired
    private RouteRepository routeRepo;
    @Autowired
    private TripRepository tripRepo;
    @Autowired
    private TripStopsRepository tripStopsRepo;

    public Set<Stop> findAll() {
        return StreamSupport.stream(stopRepo.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    public Optional<Stop> findById(String id) {
        return stopRepo.findById(id);
    }

    public Set<Stop> findByNameLike(String nameLike) {
        return  StreamSupport.stream(stopRepo.findStopByNameIsLike(nameLike).spliterator(), false)
                .collect(Collectors.toSet());
    }
//    public Set<Stop> getStopsInArea(Point p1, Point p2) {
////        return stopRepo.findStopsByPosition(p1, p2);
////        return stopRepo.findAll().iterator();
//        return StreamSupport.stream(stopRepo.findAll().spliterator(), false)
//                .collect(Collectors
//                        .toSet());

//    }
    // is it needed?

    public Set<Trip> getTripsThroughStop(String stopId) {
        Set<TripStops> tripStops = tripStopsRepo.findAllById_StopId(stopId);


        return null;

    }
    // TODO

    public Optional<Trip> getClosestTripOfRoute(String stopId, String routeId) {
        Optional<Stop> stop = stopRepo.findById(stopId);
        Set<Trip> allTrips = tripRepo.findAllByRoute_Id(routeId);
//        Set<Trip> tripsThroughStop = filterByStop(allTrips, stop);
        Trip closestTrip = null;
        int shortestTimeMin = -1;
//        for(Trip t : tripsThroughStop) {
//            if (isPassedStop(t, stop)) {
//                if (closestTrip == null) {
//                    closestTrip = t;
//                    shortestTimeMin = calcTimeToStop(t, stop);
//                    continue;
//                }
//                int tmpTime = calcTimeToStop(t, stop);
//                if (shortestTimeMin > tmpTime) {
//                    closestTrip = t;
//                    shortestTimeMin = tmpTime;
//                }
//            }
//        }
        if (closestTrip == null)
            return Optional.empty();
        return Optional.of(closestTrip);
    }

    public Set<Route> getRoutesForStop(String stopId) {
        Set<TripStops> tripStops = tripStopsRepo.findAllById_StopId(stopId);
        Set<Route> routes = new HashSet<>();
        for(TripStops t: tripStops) {
            Optional<Trip> trip = tripRepo.findById(t.getId().getTripId());
            if (trip.isEmpty()) {
                continue;
            }
            routes.add(trip.get().getRoute());
        }

        return routes;
    }
}
