package cz.fit.cvut.pidbackend.Service;

import cz.fit.cvut.pidbackend.Model.*;
import cz.fit.cvut.pidbackend.Repository.DelayRepository;
import cz.fit.cvut.pidbackend.Repository.UserRepository;
import cz.fit.cvut.pidbackend.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class DelayService {

    @Autowired
    private DelayRepository delayRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private VehicleRepository vehicleRepo;

    public DelayService() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(getUpdateDelaysTask(), 1, 5, TimeUnit.MINUTES);
    }

    public Optional<Delay> findById(DelayId id) {
        return delayRepo.findById(id);
    }

    public Runnable getUpdateDelaysTask() {

        return new Runnable() {

            public void run() {
                updateDelays();
            }

            @Transactional
            private void updateDelays() {
                for (Trip t : getFollowedTrips()) {
                    Optional<Vehicle> v = vehicleRepo.findById(t.getUid());
                    if (v.isEmpty())
                        continue;
                    Stop lastStop = v.get().getLastStop();
                    if (delayRepo.findDelayByDelayId_TripIdAndDelayId_StopIdAndDelayId_DateD(
                            t.getUid(),
                            lastStop.getId(),
                            new java.sql.Date(Calendar.getInstance().getTime().getTime()))
                            .isEmpty()) {
                        addDelay(t.getUid(), lastStop.getId(), new java.sql.Date(Calendar.getInstance().getTime().getTime()), v.get().getDelayLastStop());
                    }
                }
            }

            @Transactional
            private void addDelay(String tripId, String stopId, Date date, int delayMin) {
                delayRepo.save(new Delay(new DelayId(tripId, stopId, date), delayMin));
            }

            @Transactional
            private Set<Trip> getFollowedTrips() {
                List<User> users = userRepo.findAll();
                Set<Trip> trips = new HashSet<>();
                for (User u : users) {
                    trips.addAll(u.getFavouriteTrips());
                }
                return trips;
            }
        };
    }
}
