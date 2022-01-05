package cz.fit.cvut.pidbackend.Repository;

import cz.fit.cvut.pidbackend.Model.Delay;
import cz.fit.cvut.pidbackend.Model.DelayId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelayRepository extends CrudRepository<Delay, DelayId> {
}
