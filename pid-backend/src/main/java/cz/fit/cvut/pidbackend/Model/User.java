package cz.fit.cvut.pidbackend.Model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
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

    @ManyToMany(cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name="users_favourite_trips",
            joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="trip_id"))
    private Set<Trip> favouriteTrips;

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="users_favourite_routes",
            joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="route_id"))
    private Set<Route> favouriteRoutes;

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
