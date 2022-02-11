package cz.fit.cvut.pidbackend.Service;

import cz.fit.cvut.pidbackend.Model.Delay;
import cz.fit.cvut.pidbackend.Model.Dto.DelayDto;
import cz.fit.cvut.pidbackend.Model.Dto.TripDelayDto;
import cz.fit.cvut.pidbackend.Model.Dto.TripDto;
import cz.fit.cvut.pidbackend.Model.Dto.TripResponse;
import cz.fit.cvut.pidbackend.Model.Shape;
import cz.fit.cvut.pidbackend.Model.Trip;
import cz.fit.cvut.pidbackend.Model.Vehicle;
import cz.fit.cvut.pidbackend.Repository.DelayRepository;
import cz.fit.cvut.pidbackend.Repository.ShapeRepository;
import cz.fit.cvut.pidbackend.Repository.TripRepository;
import cz.fit.cvut.pidbackend.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepo;
    @Autowired
    private VehicleRepository vehicleRepo;
    @Autowired
    private ShapeRepository shapeRepo;
    @Autowired
    private DelayRepository delayRepo;

    public Optional<TripResponse> findById(String id) {
        Optional<Trip> trip = tripRepo.findById(id);
        if (trip.isEmpty())
            return Optional.empty();
        Optional<Vehicle> vehicle = vehicleRepo.findById(id);
        if (vehicle.isEmpty())
            return Optional.empty();
        Set<Shape> shapes = shapeRepo.findAllByUid_Uid(trip.get().getShapeId());
        return Optional.of(new TripResponse(new TripDto(trip.get()), vehicle.get(), shapes, new ArrayList<>()));
    }

    public TripDelayDto findByIdWithDelays(String tripId, String stopId) {
        Optional<Trip> trip = tripRepo.findById(tripId);
        if (trip.isEmpty())
            return null;
        List<DelayDto> delays = findLastSevenDelays(tripId, stopId);
        return new TripDelayDto(trip.get(), delays);
    }

    public List<DelayDto> findLastSevenDelays(String tripId, String stopId) {
        List<Delay> delayList = delayRepo.findAllByDelayId_TripIdAndDelayId_StopId(tripId, stopId)
                .stream()
                .filter(
                    delay -> delay.getDelayId()
                            .getDateD().toLocalDate()
                            .isAfter(LocalDate.now().minusDays(7)))
                .collect(Collectors.toList());

        List<DelayDto> delays = new ArrayList<>();
        for (Delay delay : delayList) {
            delays.add(new DelayDto(delay.getDelayId().getDateD().toString(), delay.getDelayMin()));
        }
        return delays;
    }
}
