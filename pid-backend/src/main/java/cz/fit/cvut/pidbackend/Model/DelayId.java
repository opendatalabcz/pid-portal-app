package cz.fit.cvut.pidbackend.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class DelayId implements Serializable {

    private String tripId;
    private String stopId;
    private Date dDate;

    public DelayId() {
    }

    public DelayId(String tripId, String stopId, Date date) {
        this.tripId = tripId;
        this.stopId = stopId;
        this.dDate = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DelayId delayId = (DelayId) o;
        return Objects.equals(tripId, delayId.tripId) && Objects.equals(stopId, delayId.stopId) && Objects.equals(dDate, delayId.dDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripId, stopId, dDate);
    }
}
