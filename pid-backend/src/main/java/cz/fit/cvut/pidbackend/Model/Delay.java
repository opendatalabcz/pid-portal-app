package cz.fit.cvut.pidbackend.Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Delay {
    @EmbeddedId
    private DelayId delayId;
    private int delayMin;

    public Delay() {
    }

    public Delay(DelayId delayId, int delayMin) {
        this.delayId = delayId;
        this.delayMin = delayMin;
    }

    public DelayId getDelayId() {
        return delayId;
    }

    public void setDelayId(DelayId delayId) {
        this.delayId = delayId;
    }

    public int getDelayMin() {
        return delayMin;
    }

    public void setDelayMin(int delayMin) {
        this.delayMin = delayMin;
    }
}
