package cz.fit.cvut.pidbackend.Service;

import cz.fit.cvut.pidbackend.Model.Shape;
import cz.fit.cvut.pidbackend.Repository.ShapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class ShapeService {

    @Autowired
    private ShapeRepository shapeRepo;


    public Set<Shape> findById(String id) {
        return shapeRepo.findAllByUid_Uid(id);
    }
}
