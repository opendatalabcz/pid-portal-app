package cz.fit.cvut.pidbackend.Model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stops")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
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
}
