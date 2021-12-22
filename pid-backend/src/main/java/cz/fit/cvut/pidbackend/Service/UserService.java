package cz.fit.cvut.pidbackend.Service;

import cz.fit.cvut.pidbackend.Model.Route;
import cz.fit.cvut.pidbackend.Model.Trip;
import cz.fit.cvut.pidbackend.Model.User;
import cz.fit.cvut.pidbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

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
        return null;
    }
}
