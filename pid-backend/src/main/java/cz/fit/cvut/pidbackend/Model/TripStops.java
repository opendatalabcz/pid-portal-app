package cz.fit.cvut.pidbackend.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class TripStops {
    @Id
    @GeneratedValue
    private String id;

//    @ManyToOne
//    @JoinColumn(name = "trip_id", referencedColumnName = "uid")
//    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    private Trip trips;

    @OneToOne
    @JoinColumn(name = "stop_id", referencedColumnName = "uid")
    private Stop stop;

    @Column(name = "arrival")
    private Timestamp arrival;

    public TripStops() {
    }

    public TripStops(String id, Trip trips, Stop stop, Timestamp arrival) {
        this.id = id;
        this.trips = trips;
        this.stop = stop;
        this.arrival = arrival;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Trip getTrips() {
        return trips;
    }

    public void setTrips(Trip trip) {
        this.trips = trip;
    }

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }

    public Timestamp getArrival() {
        return arrival;
    }

    public void setArrival(Timestamp arrival) {
        this.arrival = arrival;
    }
}
