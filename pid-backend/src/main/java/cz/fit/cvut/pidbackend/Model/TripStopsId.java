package cz.fit.cvut.pidbackend.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TripStopsId implements Serializable {
    private String tripId;
    private int ptSequence;

    public TripStopsId() {
    }

    public TripStopsId(String tripId, int ptSequence) {
        this.tripId = tripId;
        this.ptSequence = ptSequence;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public int getPtSequence() {
        return ptSequence;
    }

    public void setPtSequence(int ptSequence) {
        this.ptSequence = ptSequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripStopsId that = (TripStopsId) o;
        return ptSequence == that.ptSequence && tripId.equals(that.tripId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripId, ptSequence);
    }
}
