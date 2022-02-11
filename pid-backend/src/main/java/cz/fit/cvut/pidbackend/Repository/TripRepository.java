package cz.fit.cvut.pidbackend.Repository;

import cz.fit.cvut.pidbackend.Model.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TripRepository extends CrudRepository<Trip, String> {
    Set<Trip> findAllByRoute_Id(String routeId);
}
