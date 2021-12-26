package cz.fit.cvut.pidbackend.Controller;

import cz.fit.cvut.pidbackend.Model.Shape;
import cz.fit.cvut.pidbackend.Model.Vehicle;
import cz.fit.cvut.pidbackend.Repository.ShapeRepository;
import cz.fit.cvut.pidbackend.Service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;
import java.util.Set;

@Controller
public class ShapeController {
    @Autowired
    private ShapeService shapeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Set<Shape>> getById(@PathVariable(value = "id") String id) {
        Set<Shape> shape = shapeService.findById(id);
        if (shape.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shape);
    }
}
