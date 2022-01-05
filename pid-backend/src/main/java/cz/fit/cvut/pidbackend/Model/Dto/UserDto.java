package cz.fit.cvut.pidbackend.Model.Dto;

import cz.fit.cvut.pidbackend.Model.Route;
import cz.fit.cvut.pidbackend.Model.Trip;
import cz.fit.cvut.pidbackend.Model.User;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String role;
    private Set<TripDto> favouriteTrips;
    private Set<Route> favouriteRoutes;

    public UserDto() {
    }

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
        this.favouriteRoutes = user.getFavouriteRoutes();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<TripDto> getFavouriteTrips() {
        return favouriteTrips;
    }

    public void setFavouriteTrips(Set<TripDto> favouriteTrips) {
        this.favouriteTrips = favouriteTrips;
    }

    public Set<Route> getFavouriteRoutes() {
        return favouriteRoutes;
    }

    public void setFavouriteRoutes(Set<Route> favouriteRoutes) {
        this.favouriteRoutes = favouriteRoutes;
    }
}
