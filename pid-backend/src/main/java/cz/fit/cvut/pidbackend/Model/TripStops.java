package cz.fit.cvut.pidbackend.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class TripStops {
    @EmbeddedId
    private TripStopsId id;

//    @ManyToOne
//    @JoinColumn(name = "trip_id", referencedColumnName = "uid")
//    @MapsId
//    private Trip trip;

    @OneToOne
    @JoinColumn(name = "stop_id", referencedColumnName = "uid")
    private Stop stop;

    @Column(name = "arrival")
    private Timestamp arrival;

    public TripStops() {
    }

    public TripStops(TripStopsId id, Trip trip, Stop stop, Timestamp arrival) {
        this.id = id;
//        this.trip = trip;
        this.stop = stop;
        this.arrival = arrival;
    }

    public TripStopsId getId() {
        return id;
    }

    public void setId(TripStopsId id) {
        this.id = id;
    }

//    public Trip getTrip() {
//        return trip;
//    }
//
//    public void setTrip(Trip trip) {
//        this.trip = trip;
//    }

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
