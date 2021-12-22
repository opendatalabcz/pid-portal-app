package cz.fit.cvut.pidbackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "routes")
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

    public Route() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isNight() {
        return isNight;
    }

    public void setNight(boolean night) {
        isNight = night;
    }
}
