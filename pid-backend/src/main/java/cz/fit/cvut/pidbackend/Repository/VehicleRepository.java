package cz.fit.cvut.pidbackend.Repository;

import cz.fit.cvut.pidbackend.Model.Trip;
import cz.fit.cvut.pidbackend.Model.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, String> {
    // find current
    Set<Vehicle> findAllByTripAndTrackingIsTrue(Trip t);
    Set<Vehicle> findAllByOriginRouteName(String routeName);

}
