package cz.fit.cvut.pidbackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "point")
public class Point {
    @Id
    private Long id;
    @Column(name = "lat", nullable = false)
    private Double lat;
    @Column(name = "lgn", nullable = false)
    private Double lgn;

    public Point(){}

    public Point(Double lat, Double lgn) {
        this.lat = lat;
        this.lgn = lgn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLgn() {
        return lgn;
    }

    public void setLgn(Double lgn) {
        this.lgn = lgn;
    }
}
