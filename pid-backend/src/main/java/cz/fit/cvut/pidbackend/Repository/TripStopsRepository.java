package cz.fit.cvut.pidbackend.Repository;

import cz.fit.cvut.pidbackend.Model.DayOfWeek;
import cz.fit.cvut.pidbackend.Model.Trip;
import cz.fit.cvut.pidbackend.Model.TripStops;
import cz.fit.cvut.pidbackend.Model.TripStopsId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TripStopsRepository extends CrudRepository<TripStops, TripStopsId> {
    Set<TripStops> findAllById_StopId_AndId_DayOfWeek(String stopId, DayOfWeek dayOfWeek);
    Set<TripStops> findAllById_TripId(String tripId);
    Set<TripStops> findAllById_TripIdAndId_StopId(String tripId, String stopId);
    Optional<TripStops> findById_TripIdAndId_StopIdAndId_DayOfWeek(String tripId, String stopId, DayOfWeek dayOfWeek);

    Set<TripStops> findAllById_StopId(String stopId);

    Set<TripStops> findById_TripIdAndId_DayOfWeek(String uid, DayOfWeek dayOfWeek);
}
