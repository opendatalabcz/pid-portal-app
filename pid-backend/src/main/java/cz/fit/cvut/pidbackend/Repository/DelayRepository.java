package cz.fit.cvut.pidbackend.Repository;

import cz.fit.cvut.pidbackend.Model.Delay;
import cz.fit.cvut.pidbackend.Model.DelayId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DelayRepository extends CrudRepository<Delay, DelayId> {
    List<Delay> findAllByDelayId_TripIdAndDelayId_StopId(String tripId, String stopId);
    Optional<Delay> findDelayByDelayId_TripIdAndDelayId_StopIdAndDelayId_DateD(String tripId, String stopId, Date date);
}
