package cz.fit.cvut.pidbackend.Controller;

import cz.fit.cvut.pidbackend.Model.Route;
import cz.fit.cvut.pidbackend.Model.Trip;
import cz.fit.cvut.pidbackend.Model.Vehicle;
import cz.fit.cvut.pidbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Set<Route>> getFavouriteRoutes(@PathVariable(value = "id") String id) {
//        Set<Route> fRoutes = userService.getFavouriteRoutes(id);
//        if (fRoutes.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(fRoutes);
//    }

    @RequestMapping(value = "/routes", method = RequestMethod.GET)
//    @PreAuthorize()
    public ResponseEntity<Set<Route>> getFavouriteRoutes(Principal principal) {
        Set<Route> fRoutes = userService.getFavouriteRoutes(principal.getName());
        if (fRoutes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fRoutes);
    }

    @RequestMapping(value = "/trips", method = RequestMethod.GET)
    public ResponseEntity<Set<Trip>> getFavouriteTrips(@PathVariable(value = "id") String id) {
        Set<Trip> fTrips = userService.getFavouriteTrips(id);
        if (fTrips.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fTrips);
    }


}
