package cz.fit.cvut.pidbackend.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ShapeId implements Serializable {

//    @Column(name = "uid")
    //@Id
    public String uid;
    //@Column(name = "pt_sequence")
    //@Id
    public int ptSequence;

    public ShapeId() {
    }

    public ShapeId(String uid, int ptSequence) {
        this.uid = uid;
        this.ptSequence = ptSequence;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getPtSequence() {
        return ptSequence;
    }

    public void setPtSequence(int ptSequence) {
        this.ptSequence = ptSequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShapeId shapeId = (ShapeId) o;
        return ptSequence == shapeId.ptSequence && uid.equals(shapeId.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, ptSequence);
    }
}
