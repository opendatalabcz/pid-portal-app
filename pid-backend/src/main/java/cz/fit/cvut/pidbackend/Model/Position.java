package cz.fit.cvut.pidbackend.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "positions")
public class Position {

    @EmbeddedId
    public PositionId uid;

    @ManyToOne
    @JoinColumn(name = "next_stop_id", referencedColumnName = "uid")
    private Stop nextStopId; // Stop Entity
    @ManyToOne
    @JoinColumn(name = "last_stop_id", referencedColumnName = "uid")
    private Stop prevStopId; // Stop Entity

    @Column(name = "start_timestamp")
    private Timestamp startTimestamp;
    @Column(name = "lat")
    private Double lat;
    @Column(name = "lon")
    private Double lon;
    @Column(name = "trip_sequenceId")
    private Long tripSequenceId;
    @Column(name = "dist_traveled")
    private Double distTraveled;
    @Column(name = "is_canceled")
    private boolean isCanceled;

}
