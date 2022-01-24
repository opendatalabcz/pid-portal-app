package cz.fit.cvut.pidbackend.Model.Dto;

import cz.fit.cvut.pidbackend.Model.Route;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class RouteTimeDto {
    private Route route;
    private Time expectedArrival;
    private int delayMin;
}
