package cz.fit.cvut.pidbackend.Repository;

import cz.fit.cvut.pidbackend.Model.Shape;
import cz.fit.cvut.pidbackend.Model.ShapeId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShapeRepository extends CrudRepository<Shape, ShapeId> {
    //Optional<Shape> findByUidAndPtSequence(String uid, int ptSequence);
    Optional<Shape> findByUid_Uid(String uid);
}
