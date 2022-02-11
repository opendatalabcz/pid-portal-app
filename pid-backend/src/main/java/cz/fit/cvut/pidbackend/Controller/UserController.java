package cz.fit.cvut.pidbackend.Controller;

import cz.fit.cvut.pidbackend.Model.Route;
import cz.fit.cvut.pidbackend.Model.Trip;
import cz.fit.cvut.pidbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/routes", method = RequestMethod.GET)
//    @PreAuthorize()
    public ResponseEntity<Set<Route>> getFavouriteRoutes(Principal principal) {
        Set<Route> fRoutes = userService.getFavouriteRoutes(principal.getName());
        if (fRoutes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fRoutes);
    }

    @RequestMapping(value = "/routes/{routeId}", method = RequestMethod.POST)
//    @PreAuthorize()
    public ResponseEntity<String> addFavouriteRoute(Principal principal, @PathVariable String routeId) {
        return ResponseEntity.ok(userService.addFavouriteRoute(principal.getName(), routeId));
    }

    @RequestMapping(value = "/routes/{routeId}", method = RequestMethod.DELETE)
//    @PreAuthorize()
    public ResponseEntity<String> deleteFavouriteRoute(Principal principal, @PathVariable String routeId) {
        return ResponseEntity.ok(userService.deleteFavouriteRoute(principal.getName(), routeId));
    }

    @RequestMapping(value = "/trips/{tripId}", method = RequestMethod.POST)
//    @PreAuthorize()
    public ResponseEntity<String> addFavouriteTrip(Principal principal, @PathVariable String tripId) {
        return ResponseEntity.ok(userService.addFavouriteTrip(principal.getName(), tripId));
    }

    @RequestMapping(value = "/trips/{tripId}", method = RequestMethod.DELETE)
//    @PreAuthorize()
    public ResponseEntity<String> deleteFavouriteTrip(Principal principal, @PathVariable String tripId) {
        return ResponseEntity.ok(userService.deleteFavouriteTrip(principal.getName(), tripId));
    }


    @RequestMapping(value = "/trips", method = RequestMethod.GET)
    public ResponseEntity<Set<Trip>> getFavouriteTrips(Principal principal) {
        Set<Trip> fTrips = userService.getFavouriteTrips(principal.getName());
        if (fTrips.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fTrips);
    }
}
