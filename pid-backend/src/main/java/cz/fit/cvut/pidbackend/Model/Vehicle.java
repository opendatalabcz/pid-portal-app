package cz.fit.cvut.pidbackend.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "vehicles")
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

    public Vehicle() {
    }

    public Vehicle(String id, Trip trip, Stop nextStop, Stop lastStop, String originRouteName, String cisLineId, int cisTripNumber, Timestamp startTimestamp, Timestamp lastModifiedTimestamp, Double lat, Double lon, int speed, Double distTraveled, boolean tracking, int bearing, int tripSequenceId, int delay, int delayLastStop, boolean isCanceled, Timestamp lastStopDeparture, Timestamp nextStopArrival, String vehicleType, String agencyName, String scheduledAgencyName, String registrationNumber, int allPosition) {
        this.id = id;
        this.trip = trip;
        this.nextStop = nextStop;
        this.lastStop = lastStop;
        this.originRouteName = originRouteName;
        this.cisLineId = cisLineId;
        this.cisTripNumber = cisTripNumber;
        this.startTimestamp = startTimestamp;
        this.lastModifiedTimestamp = lastModifiedTimestamp;
        this.lat = lat;
        this.lon = lon;
        this.speed = speed;
        this.distTraveled = distTraveled;
        this.tracking = tracking;
        this.bearing = bearing;
        this.tripSequenceId = tripSequenceId;
        this.delay = delay;
        this.delayLastStop = delayLastStop;
        this.isCanceled = isCanceled;
        this.lastStopDeparture = lastStopDeparture;
        this.nextStopArrival = nextStopArrival;
        this.vehicleType = vehicleType;
        this.agencyName = agencyName;
        this.scheduledAgencyName = scheduledAgencyName;
        this.registrationNumber = registrationNumber;
        this.allPosition = allPosition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Stop getNextStop() {
        return nextStop;
    }

    public void setNextStop(Stop nextStop) {
        this.nextStop = nextStop;
    }

    public Stop getLastStop() {
        return lastStop;
    }

    public void setLastStop(Stop lastStop) {
        this.lastStop = lastStop;
    }

    public String getOriginRouteName() {
        return originRouteName;
    }

    public void setOriginRouteName(String originRouteName) {
        this.originRouteName = originRouteName;
    }

    public String getCisLineId() {
        return cisLineId;
    }

    public void setCisLineId(String cisLineId) {
        this.cisLineId = cisLineId;
    }

    public int getCisTripNumber() {
        return cisTripNumber;
    }

    public void setCisTripNumber(int cisTripNumber) {
        this.cisTripNumber = cisTripNumber;
    }

    public Timestamp getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Timestamp startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Timestamp getLastModifiedTimestamp() {
        return lastModifiedTimestamp;
    }

    public void setLastModifiedTimestamp(Timestamp lastModifiedTimestamp) {
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Double getDistTraveled() {
        return distTraveled;
    }

    public void setDistTraveled(Double distTraveled) {
        this.distTraveled = distTraveled;
    }

    public boolean isTracking() {
        return tracking;
    }

    public void setTracking(boolean tracking) {
        this.tracking = tracking;
    }

    public int getBearing() {
        return bearing;
    }

    public void setBearing(int bearing) {
        this.bearing = bearing;
    }

    public int getTripSequenceId() {
        return tripSequenceId;
    }

    public void setTripSequenceId(int tripSequenceId) {
        this.tripSequenceId = tripSequenceId;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getDelayLastStop() {
        return delayLastStop;
    }

    public void setDelayLastStop(int delayLastStop) {
        this.delayLastStop = delayLastStop;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    public Timestamp getLastStopDeparture() {
        return lastStopDeparture;
    }

    public void setLastStopDeparture(Timestamp lastStopDeparture) {
        this.lastStopDeparture = lastStopDeparture;
    }

    public Timestamp getNextStopArrival() {
        return nextStopArrival;
    }

    public void setNextStopArrival(Timestamp nextStopArrival) {
        this.nextStopArrival = nextStopArrival;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getScheduledAgencyName() {
        return scheduledAgencyName;
    }

    public void setScheduledAgencyName(String scheduledAgencyName) {
        this.scheduledAgencyName = scheduledAgencyName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getAllPosition() {
        return allPosition;
    }

    public void setAllPosition(int allPosition) {
        this.allPosition = allPosition;
    }
}
