package cz.fit.cvut.pidbackend.Service;

import cz.fit.cvut.pidbackend.Model.Trip;
import cz.fit.cvut.pidbackend.Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepo;

    public Optional<Trip> findById(String id) {
        return tripRepo.findById(id);
    }
}
