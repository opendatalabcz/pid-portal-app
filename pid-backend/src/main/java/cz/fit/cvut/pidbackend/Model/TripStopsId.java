package cz.fit.cvut.pidbackend.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TripStopsId implements Serializable {

    private String tripId;
    private String stopId;
    private int index;
    private DayOfWeek dayOfWeek;

    public TripStopsId() {
    }

    public TripStopsId(String tripId, String stopId, int index, DayOfWeek dayOfWeek) {
        this.tripId = tripId;
        this.stopId = stopId;
        this.index = index;
        this.dayOfWeek = dayOfWeek;
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

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
