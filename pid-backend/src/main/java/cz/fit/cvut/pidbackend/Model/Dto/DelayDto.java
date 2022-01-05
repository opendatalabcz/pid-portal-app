package cz.fit.cvut.pidbackend.Model.Dto;

public class DelayDto {
    private String date;
    private int delayMin;

    public DelayDto() {
    }

    public DelayDto(String date, int delayMin) {
        this.date = date;
        this.delayMin = delayMin;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDelayMin() {
        return delayMin;
    }

    public void setDelayMin(int delayMin) {
        this.delayMin = delayMin;
    }
}
