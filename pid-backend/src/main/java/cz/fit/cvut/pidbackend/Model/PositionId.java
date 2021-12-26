package cz.fit.cvut.pidbackend.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
public class PositionId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "uid")
    @MapsId
    private Trip trip;
    @Column(name = "last_modified_timestamp")
    private Timestamp lastModifiedTimestamp;

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Timestamp getLastModifiedTimestamp() {
        return lastModifiedTimestamp;
    }

    public void setLastModifiedTimestamp(Timestamp lastModifiedTimestamp) {
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionId that = (PositionId) o;
        return Objects.equals(trip, that.trip) && Objects.equals(lastModifiedTimestamp, that.lastModifiedTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trip, lastModifiedTimestamp);
    }
}
