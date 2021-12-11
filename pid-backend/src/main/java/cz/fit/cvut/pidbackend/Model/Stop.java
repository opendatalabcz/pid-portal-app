package cz.fit.cvut.pidbackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stops")
public class Stop {

    @Id
    @Column(name = "uid")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "lat")
    private Double lat;
    @Column(name = "lon")
    private Double lon;
    @Column(name = "zone_id")
    private String zoneId;
    @Column(name = "wheelchair")
    private int weelchair;
    @Column(name = "parent_station")
    private String parentStation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public int getWeelchair() {
        return weelchair;
    }

    public void setWeelchair(int weelchair) {
        this.weelchair = weelchair;
    }

    public String getParentStation() {
        return parentStation;
    }

    public void setParentStation(String parentStation) {
        this.parentStation = parentStation;
    }
}
