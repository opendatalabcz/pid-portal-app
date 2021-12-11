package cz.fit.cvut.pidbackend.Repository;

import cz.fit.cvut.pidbackend.Model.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface RouteRepository extends CrudRepository<Route, String> {
    Set<Route> findAllByShortNameIsLike(String name);
}
