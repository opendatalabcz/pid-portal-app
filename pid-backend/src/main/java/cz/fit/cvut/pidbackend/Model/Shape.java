package cz.fit.cvut.pidbackend.Model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shapes")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Shape implements Serializable {

    @EmbeddedId
    public ShapeId uid;

    @Column(name = "lat")
    private Double lat;
    @Column(name = "lon")
    private Double lon;
    @Column(name = "dist_traveled")
    private Double distTraveled;
}
