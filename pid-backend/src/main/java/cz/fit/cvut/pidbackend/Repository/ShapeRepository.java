package cz.fit.cvut.pidbackend.Repository;

import cz.fit.cvut.pidbackend.Model.Shape;
import cz.fit.cvut.pidbackend.Model.ShapeId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ShapeRepository extends CrudRepository<Shape, ShapeId> {
    //Optional<Shape> findByUidAndPtSequence(String uid, int ptSequence);
    Set<Shape> findAllByUid_Uid(String uid);
}
