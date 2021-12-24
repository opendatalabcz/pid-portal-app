package cz.fit.cvut.pidbackend.Service;

import cz.fit.cvut.pidbackend.Model.*;
import cz.fit.cvut.pidbackend.Model.Dto.RouteTimeDto;
import cz.fit.cvut.pidbackend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
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
    @Autowired
    private VehicleRepository vehicleRepo;

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

//    public Set<Trip> getTripsThroughStop(String stopId) {
//        Set<TripStops> tripStops = tripStopsRepo.findAllById_StopId(stopId);
//
//
//        return null;
//
//    }
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
        DayOfWeek today = getDayOfWeek();

        Set<TripStops> tripStops = tripStopsRepo.findAllById_StopId_AndId_DayOfWeek(stopId, today);
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

    public Set<RouteTimeDto> getRoutesForStopWithTime(String stopId) {
        DayOfWeek today = getDayOfWeek();

        Set<TripStops> tripStops = tripStopsRepo.findAllById_StopId_AndId_DayOfWeek(stopId, today);
        Set<RouteTimeDto> routes = new HashSet<>();
        for(TripStops t: tripStops) {
            Optional<Trip> trip = tripRepo.findById(t.getId().getTripId());
            if (trip.isEmpty()) {
                continue;
            }
            Optional<Vehicle> vehicle = vehicleRepo.findById(trip.get().getUid());
            if (vehicle.isEmpty()) {
                continue;
            }

            routes.add(new RouteTimeDto(trip.get().getRoute(), t.getArrival(), vehicle.get().getDelay()));
        }

        return routes;
    }

    private DayOfWeek getDayOfWeek() {
        final Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1 || dayOfWeek == 7) {
            return DayOfWeek.WEEKEND;
        } else {
            return DayOfWeek.WEEK_DAY;
        }
    }
}
