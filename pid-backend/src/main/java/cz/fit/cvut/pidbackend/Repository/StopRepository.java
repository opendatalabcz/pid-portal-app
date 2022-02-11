package cz.fit.cvut.pidbackend.Repository;

import cz.fit.cvut.pidbackend.Model.Stop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StopRepository extends CrudRepository<Stop, String> {
    Set<Stop> findStopByNameIsLike(String name);
}
