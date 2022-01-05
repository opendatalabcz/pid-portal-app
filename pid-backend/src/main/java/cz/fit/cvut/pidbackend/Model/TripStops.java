package cz.fit.cvut.pidbackend.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table
public class TripStops implements Serializable {

    @EmbeddedId
    private TripStopsId id;

    @Column(name = "arrival")
    private Time arrival;

    public TripStops() {
    }

    public TripStops(TripStopsId id, Time arrival) {
        this.id = id;
        this.arrival = arrival;
    }

    public TripStopsId getId() {
        return id;
    }

    public void setId(TripStopsId id) {
        this.id = id;
    }

    public Time getArrival() {
        return arrival;
    }

    public void setArrival(Time arrival) {
        this.arrival = arrival;
    }
}
