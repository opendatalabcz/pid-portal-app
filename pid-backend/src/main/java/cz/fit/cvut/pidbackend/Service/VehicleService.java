package cz.fit.cvut.pidbackend.Service;

import cz.fit.cvut.pidbackend.Model.Position;
import cz.fit.cvut.pidbackend.Model.Vehicle;
import cz.fit.cvut.pidbackend.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepo;

    public Optional<Vehicle> findById(String id) {
        return vehicleRepo.findById(id);
    }


//    public Optional<Position> getPosition(String id) {
//
//        return null;
//    }
}
