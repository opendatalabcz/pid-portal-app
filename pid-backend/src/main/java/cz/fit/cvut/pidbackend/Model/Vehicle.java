package cz.fit.cvut.pidbackend.Model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "vehicles")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Vehicle {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "uid")
    @MapsId
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "next_stop_id", referencedColumnName = "uid")
    private Stop nextStop; // Stop Entity
    @ManyToOne
    @JoinColumn(name = "last_stop_id", referencedColumnName = "uid")
    private Stop lastStop; // (previous stop) Stop Entity

    @Column(name = "origin_route_name")
    private String originRouteName;
    @Column(name = "cis_line_id")
    private String cisLineId;
    @Column(name = "cis_trip_number")
    private int cisTripNumber;
    @Column(name = "start_timestamp")
    private Timestamp startTimestamp;
    @Column(name = "last_modified_timestamp")
    private Timestamp lastModifiedTimestamp;
    @Column(name = "lat")
    private Double lat;
    @Column(name = "lon")
    private Double lon;
    @Column(name = "speed")
    private int speed;
    @Column(name = "dist_traveled")
    private Double distTraveled;
    @Column(name = "tracking")
    private boolean tracking;
    @Column(name = "bearing")
    private int bearing;
    @Column(name = "trip_sequence_id")
    private int tripSequenceId;
    @Column(name = "delay")
    private int delay;
    @Column(name = "delay_last_stop")
    private int delayLastStop;
    @Column(name = "is_canceled")
    private boolean isCanceled;
    @Column(name = "last_stop_departure")
    private Timestamp lastStopDeparture; // (previous stop)
    @Column(name = "next_stop_arrival")
    private Timestamp nextStopArrival;
    @Column(name = "vehicle_type")
    private String vehicleType;
    @Column(name = "agency_name")
    private String agencyName;
    @Column(name = "scheduled_agency_name")
    private String scheduledAgencyName;
    @Column(name = "registration_number")
    private String registrationNumber;
    @Column(name = "all_position")
    private int allPosition;
}
