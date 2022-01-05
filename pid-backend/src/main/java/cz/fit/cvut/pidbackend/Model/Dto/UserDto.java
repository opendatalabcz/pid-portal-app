package cz.fit.cvut.pidbackend.Model.Dto;

import cz.fit.cvut.pidbackend.Model.Route;
import cz.fit.cvut.pidbackend.Model.Trip;
import cz.fit.cvut.pidbackend.Model.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String role;
    private Set<String> favouriteTripsIds;
    private Set<Route> favouriteRoutes;


    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.favouriteTripsIds = user.getFavouriteTrips().stream().map(Trip::getUid).collect(Collectors.toSet());
        this.favouriteRoutes = user.getFavouriteRoutes();
    }
}
