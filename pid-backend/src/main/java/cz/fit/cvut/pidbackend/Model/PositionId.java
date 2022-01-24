package cz.fit.cvut.pidbackend.Model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PositionId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "uid")
    @MapsId
    private Trip trip;

    @Column(name = "last_modified_timestamp")
    private Timestamp lastModifiedTimestamp;
}
