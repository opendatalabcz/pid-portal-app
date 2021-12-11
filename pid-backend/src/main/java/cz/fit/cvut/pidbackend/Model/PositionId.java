package cz.fit.cvut.pidbackend.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Embeddable
public class PositionId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "uid")
    @MapsId
    private Trip trip;
    @Column(name = "last_modified_timestamp")
    private Timestamp lastModifiedTimestamp;
}
