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
@Table(name = "routes")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Route {

    @Id
    @Column(name = "uid")
    private String id;

    @Column(name = "long_name")
    private String longName;
    @Column(name = "short_name")
    private String shortName;
//    @Column(name = "\"desc\"")
    @Column(name = "desc")
    private String desc;
    @Column(name = "agency")
    private String agency;
    @Column(name = "color")
    private String color;
    @Column(name = "text_color")
    private String textColor;
    @Column(name = "type")
    private String type;
    @Column(name = "url")
    private String url;
    @Column(name = "is_night")
    private boolean isNight;

    @Column(name = "shape_id")
    private String shapeId;
}
