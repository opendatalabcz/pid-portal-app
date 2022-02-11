package cz.fit.cvut.pidbackend.Model.Dto;

import cz.fit.cvut.pidbackend.Model.Route;
import cz.fit.cvut.pidbackend.Model.Trip;
import cz.fit.cvut.pidbackend.Model.User;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String role;
    private Set<TripDto> favouriteTrips;
//    private Set<Trip> favouriteTrips;
    private Set<Route> favouriteRoutes;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.favouriteTrips = user.getFavouriteTrips() == null
                ? new HashSet<>()
                : user.getFavouriteTrips().stream().map(TripDto::new).collect(Collectors.toSet());
//        this.favouriteTrips = user.getFavouriteTrips();
        this.favouriteRoutes = user.getFavouriteRoutes();
    }
}
