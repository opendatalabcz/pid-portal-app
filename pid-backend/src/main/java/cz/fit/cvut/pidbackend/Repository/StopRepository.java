package cz.fit.cvut.pidbackend.Repository;

import cz.fit.cvut.pidbackend.Model.Point;
import cz.fit.cvut.pidbackend.Model.Stop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface StopRepository extends CrudRepository<Stop, String> {
    Set<Stop> findStopByNameIsLike(String name);

    // select * as s
    // from stop
    // where s.lat >= p1.lat
    // and s.lng >= p1.lng
    // and s.lat <= p2.lat
    // and s.lng >= p2.lng
    //Set<Stop> findStopsByPosition(Point p1, Point p2);
}
