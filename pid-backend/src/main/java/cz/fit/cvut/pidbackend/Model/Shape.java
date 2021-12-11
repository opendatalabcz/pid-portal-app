package cz.fit.cvut.pidbackend.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shapes")
//@IdClass(ShapeId.class)
public class Shape implements Serializable {

//    @Id
//    public String uid;
//    @Id
//    public int ptSequence;
    @EmbeddedId
    public ShapeId uid;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lon")
    private Double lon;

    @Column(name = "dist_traveled")
    private Double distTraveled;

    public Shape() {
    }

//    public Shape(String uid, int ptSequence, Double lat, Double lon, Double distTraveled) {
//        this.uid = uid;
//        this.ptSequence = ptSequence;
//        this.lat = lat;
//        this.lon = lon;
//        this.distTraveled = distTraveled;
//    }


    public Shape(ShapeId uid, Double lat, Double lon, Double distTraveled) {
        this.uid = uid;
        this.lat = lat;
        this.lon = lon;
        this.distTraveled = distTraveled;
    }

    public ShapeId getUid() {
        return uid;
    }

    public void setUid(ShapeId uid) {
        this.uid = uid;
    }

//    public int getPtSequence() {
//        return ptSequence;
//    }
//
//    public void setPtSequence(int ptSequence) {
//        this.ptSequence = ptSequence;
//    }

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

    public Double getDistTraveled() {
        return distTraveled;
    }

    public void setDistTraveled(Double distTraveled) {
        this.distTraveled = distTraveled;
    }
}
