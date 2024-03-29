package cz.fit.cvut.pidbackend.Controller;

import cz.fit.cvut.pidbackend.Model.Vehicle;
import cz.fit.cvut.pidbackend.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    // get Vehicle by its ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Vehicle> getById(@PathVariable(value = "id") String id) {
        Optional<Vehicle> vehicle = vehicleService.findById(id);
        if (vehicle.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicle.get());
    }

    @RequestMapping(value = "/route/{route_id}", method = RequestMethod.GET)
    public ResponseEntity<Set<Vehicle>> getAllByRoute(@PathVariable(value = "route_id") String id) {
        Set<Vehicle> vehicles = vehicleService.findAllByRoute(id);
        if (vehicles.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicles);
    }
}
