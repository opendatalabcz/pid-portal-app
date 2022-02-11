package cz.fit.cvut.pidbackend.Service;

import cz.fit.cvut.pidbackend.Model.Route;
import cz.fit.cvut.pidbackend.Model.Trip;
import cz.fit.cvut.pidbackend.Model.User;
import cz.fit.cvut.pidbackend.Repository.RouteRepository;
import cz.fit.cvut.pidbackend.Repository.TripRepository;
import cz.fit.cvut.pidbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RouteRepository routeRepo;
    @Autowired
    private TripRepository tripRepo;

    public Set<Route> getFavouriteRoutes(String id) {
        Optional<User> user = userRepo.findByUsernameOrEmail(id, id);
        if (user.isEmpty()) {
            return new HashSet<>();
        }

        return user.get().getFavouriteRoutes() != null
                ? user.get().getFavouriteRoutes()
                : new HashSet<>();
    }

    public Set<Trip> getFavouriteTrips(String id) {
        Optional<User> user = userRepo.findByUsernameOrEmail(id, id);
        if (user.isEmpty()) {
            return new HashSet<>();
        }

        return user.get().getFavouriteTrips() != null
                ? user.get().getFavouriteTrips()
                : new HashSet<>();
    }

    public String addFavouriteRoute(String name, String routeId) {
        Optional<User> user = userRepo.findByUsernameOrEmail(name, name);
        if (user.isEmpty())
            return "User does not exist";

        Optional<Route> route = routeRepo.findById(routeId);
        if (route.isEmpty())
            return "Route does not exist";

        user.get().addFavouriteRoute(route.get());
        userRepo.save(user.get());

        return "Added favourite route: " + routeId;
    }

    public String deleteFavouriteRoute(String name, String routeId) {
        Optional<User> user = userRepo.findByUsernameOrEmail(name, name);
        if (user.isEmpty())
            return "User does not exist";

        Optional<Route> route = routeRepo.findById(routeId);
        if (route.isEmpty())
            return "Route does not exist";

        user.get().deleteFavouriteRoute(route.get());
        userRepo.save(user.get());

        return "Deleted favourite route: " + routeId;
    }

    public String addFavouriteTrip(String name, String tripId) {
        Optional<User> user = userRepo.findByUsernameOrEmail(name, name);
        if (user.isEmpty())
            return "User does not exist";

        Optional<Trip> trip = tripRepo.findById(tripId);
        if (trip.isEmpty())
            return "Route does not exist";

        user.get().addFavouriteTrip(trip.get());
        userRepo.save(user.get());

        return "Added favourite route: " + tripId;
    }

    public String deleteFavouriteTrip(String name, String tripId) {
        Optional<User> user = userRepo.findByUsernameOrEmail(name, name);
        if (user.isEmpty())
            return "User does not exist";

        Optional<Trip> trip = tripRepo.findById(tripId);
        if (trip.isEmpty())
            return "Route does not exist";

        user.get().deleteFavouriteTrip(trip.get());
        userRepo.save(user.get());

        return "Deleted favourite route: " + tripId;
    }
}
