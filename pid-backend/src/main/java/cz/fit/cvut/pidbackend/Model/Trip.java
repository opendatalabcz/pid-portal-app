package cz.fit.cvut.pidbackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "trips")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Trip {

    @Id
    @Column(name = "uid")
    private String uid;

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "uid")
    private Route route;
    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "uid", insertable = false, updatable = false)
    @JsonIgnore
    private Service service;

    @Column(name = "shape_id")
    private String shapeId;
    @Column(name = "direction")
    private int direction;
    @Column(name = "exceptional")
    private int exceptional;
    @Column(name = "headsign")
    private String headsign;
    @Column(name = "wheelchair")
    private boolean wheelchair;
    @Column(name = "bikes_allowed")
    private boolean bikesAllowed;
    @Column(name = "block_id")
    private String blockId;
}
