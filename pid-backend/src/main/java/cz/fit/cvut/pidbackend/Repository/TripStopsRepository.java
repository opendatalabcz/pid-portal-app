package cz.fit.cvut.pidbackend.Repository;

import cz.fit.cvut.pidbackend.Model.Trip;
import cz.fit.cvut.pidbackend.Model.TripStops;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TripStopsRepository extends CrudRepository<TripStops, Trip> {
    Set<TripStops> findAllByStop_Id(String stopId);
}
