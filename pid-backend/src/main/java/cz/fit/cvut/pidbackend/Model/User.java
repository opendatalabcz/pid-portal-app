package cz.fit.cvut.pidbackend.Model;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="users_favourite_trips", joinColumns=@JoinColumn(name="user_id"),
        inverseJoinColumns=@JoinColumn(name="trip_id"))//@JoinTable is used to map Join table in database
    private Set<Trip> favouriteTrips;

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="users_favourite_routes", joinColumns=@JoinColumn(name="user_id"),
        inverseJoinColumns=@JoinColumn(name="route_id"))//@JoinTable is used to map Join table in database
    private Set<Route> favouriteRoutes;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Trip> getFavouriteTrips() {
        return favouriteTrips;
    }

    public void setFavouriteTrips(Set<Trip> favouriteTrips) {
        this.favouriteTrips = favouriteTrips;
    }

    public Set<Route> getFavouriteRoutes() {
        return favouriteRoutes;
    }

    public void setFavouriteRoutes(Set<Route> favouriteRoutes) {
        this.favouriteRoutes = favouriteRoutes;
    }

    public void addFavouriteRoute(Route route) {
        favouriteRoutes.add(route);
    }
    public void deleteFavouriteRoute(Route route) {
        favouriteRoutes.remove(route);
    }

    public void addFavouriteTrip(Trip trip) {
        favouriteTrips.add(trip);
    }
    public void deleteFavouriteTrip(Trip trip) {
        favouriteTrips.remove(trip);
    }
}
