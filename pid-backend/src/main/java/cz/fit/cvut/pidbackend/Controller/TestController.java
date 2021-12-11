package cz.fit.cvut.pidbackend.Controller;

import cz.fit.cvut.pidbackend.Model.Shape;
import cz.fit.cvut.pidbackend.Model.ShapeId;
import cz.fit.cvut.pidbackend.Repository.ShapeRepository;
import cz.fit.cvut.pidbackend.Service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    ShapeRepository shapeRepository;

    @RequestMapping(value = "/shape/{id}", method = RequestMethod.GET)
    public ResponseEntity<Shape> getShape(@PathVariable(value = "id") String id) {
        Shape shape =  shapeRepository.findAll().iterator().next();
        //return ResponseEntity.ok(shape);
        //shapeRepository.save(new Shape(new ShapeId("lol", 100), ), )
        //return ResponseEntity.ok(shapeRepository.findByUidAndPtSequence(id, 100).get());
        return ResponseEntity.ok(shapeRepository.findByUid_Uid(id).get());
//        return ResponseEntity.ok(shape);
    }

    @RequestMapping(value = "shape/create", method = RequestMethod.GET)
    public ResponseEntity<String> createShape() {
        //Shape shape =  shapeRepository.findAll().iterator().next();
        //return ResponseEntity.ok(shape);
        Shape s = new Shape(new ShapeId("lol", 1), 2.0,1.0,10.0);
        shapeRepository.save(s);
        return ResponseEntity.ok("saved");
    }
}
