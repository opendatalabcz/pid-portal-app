package cz.fit.cvut.pidbackend.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TripStopsId implements Serializable {

    private String tripId;
    private String stopId;
    private int index;

    public TripStopsId() {
    }

    public TripStopsId(String tripId, int ptSequence) {
        this.tripId = tripId;
        this.index = ptSequence;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
