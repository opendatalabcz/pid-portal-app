package cz.fit.cvut.pidbackend.Service;

import cz.fit.cvut.pidbackend.Model.Route;
import cz.fit.cvut.pidbackend.Model.Vehicle;
import cz.fit.cvut.pidbackend.Repository.RouteRepository;
import cz.fit.cvut.pidbackend.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepo;
    @Autowired
    private RouteRepository routeRepo;

    public Optional<Vehicle> findById(String id) {
        return vehicleRepo.findById(id);
    }

    public Set<Vehicle> findAllByRoute(String routeId) {
        Optional<Route> route = routeRepo.findById(routeId);
        if (route.isEmpty()) return new HashSet<>();

        return vehicleRepo.findAllByOriginRouteName(route.get().getLongName());
    }


//    public Optional<Position> getPosition(String id) {
//
//        return null;
//    }
}
