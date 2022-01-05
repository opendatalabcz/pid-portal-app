package cz.fit.cvut.pidbackend.Service;

import cz.fit.cvut.pidbackend.Model.*;
import cz.fit.cvut.pidbackend.Model.Dto.RouteTimeDto;
import cz.fit.cvut.pidbackend.Model.Dto.TripVehicleDto;
import cz.fit.cvut.pidbackend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public Optional<TripVehicleDto> getClosestTripOfRoute(String stopId, String routeId) {
        Optional<Stop> stop = stopRepo.findById(stopId);
        if (stop.isEmpty())
            return Optional.empty();

        Set<Trip> allTrips = tripRepo.findAllByRoute_Id(routeId);
        Set<Trip> tripsThroughStop = filterByStop(allTrips, stop.get());
        if (tripsThroughStop.isEmpty())
            return Optional.empty();

        Trip closestTrip = null;
        int shortestTimeMin = -1;
        for(Trip t : tripsThroughStop) {
            if (!isPassedStop(t, stop.get())) {
                if (closestTrip == null) {
                    shortestTimeMin = calcTimeToStop(t, stop.get());
                    if (shortestTimeMin != -1)
                        closestTrip = t;
                    continue;
                }
                int tmpTime = calcTimeToStop(t, stop.get());
                if (tmpTime == -1)
                    continue;

                if (shortestTimeMin > tmpTime) {
                    closestTrip = t;
                    shortestTimeMin = tmpTime;
                }
            }
        }
        if (closestTrip == null)
            return Optional.empty();
        Optional<Vehicle> vehicle = vehicleRepo.findById(closestTrip.getUid());
        if (vehicle.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new TripVehicleDto(closestTrip, vehicle.get()));
    }

    private int calcTimeToStop(Trip t, Stop stop) {
        Optional<Vehicle> vehicle = vehicleRepo.findById(t.getUid());
        if (vehicle.isEmpty())
            return -1;

        Optional<TripStops> tripStops = tripStopsRepo.findById_TripIdAndId_StopIdAndId_DayOfWeek(t.getUid(), stop.getId(), getDayOfWeek());
        if (tripStops.isEmpty())
            return -1;

        LocalDateTime now = LocalDateTime.now();

        return tripStops.get().getArrival().toLocalTime().minusHours(now.getHour()).minusMinutes(now.getMinute()).getMinute();
    }

    private boolean isPassedStop(Trip t, Stop stop) {
        Optional<Vehicle> vehicle = vehicleRepo.findById(t.getUid());
        if (vehicle.isEmpty())
            return true;

        Stop nextStop = vehicle.get().getNextStop();
        if (nextStop == null)
            return true;

        Set<TripStops> tripStops = tripStopsRepo.findById_TripIdAndId_DayOfWeek(t.getUid(), getDayOfWeek());
        if (tripStops.isEmpty())
            return true;

        int stopIndex = -1;
        int currStopIndex = -1;
        for (TripStops ts: tripStops) {
            if (ts.getId().getStopId().equals(stop.getId()))
                stopIndex = ts.getId().getIndex();
            if (ts.getId().getStopId().equals(nextStop.getId()))
                currStopIndex = ts.getId().getIndex();
        }

        if (stopIndex == -1 || currStopIndex == -1)
            return true;

        return currStopIndex <= stopIndex;
    }

    private Set<Trip> filterByStop(Set<Trip> allTrips, Stop stop) {
        Set<TripStops> tripStopsThroughStop = tripStopsRepo.findAllById_StopId(stop.getId());
        Set<String> tripsIds = tripStopsThroughStop.stream().map(tripStops -> tripStops.getId().getTripId()).collect(Collectors.toSet());
        Set<Trip> tripThroughStop = new HashSet<>();
        for (Trip trip : allTrips) {
            if (tripsIds.contains(trip.getUid()))
                tripThroughStop.add(trip);
        }
        return tripThroughStop;
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
