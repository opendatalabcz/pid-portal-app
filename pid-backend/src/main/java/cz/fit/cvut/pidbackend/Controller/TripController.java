package cz.fit.cvut.pidbackend.Controller;

import cz.fit.cvut.pidbackend.Model.Dto.TripDelayDto;
import cz.fit.cvut.pidbackend.Model.Dto.TripResponse;
import cz.fit.cvut.pidbackend.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/trip")
public class TripController {

    @Autowired
    TripService tripService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TripResponse> getById(@PathVariable(value = "id") String id) {
        Optional<TripResponse> trip = tripService.findById(id);
        if (trip.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trip.get());
    }

    @RequestMapping(value = "/{tripId}/{stopId}", method = RequestMethod.GET)
    public ResponseEntity<TripDelayDto> getByIdWithDelays(@PathVariable(value = "tripId") String tripId, @PathVariable(value = "stopId") String stopId) {
        TripDelayDto tripD = tripService.findByIdWithDelays(tripId, stopId);
        if (tripD == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tripD);
    }
}
