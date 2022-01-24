package cz.fit.cvut.pidbackend.Model.Dto;

import cz.fit.cvut.pidbackend.Model.Route;
import cz.fit.cvut.pidbackend.Model.Shape;
import cz.fit.cvut.pidbackend.Model.Trip;
import cz.fit.cvut.pidbackend.Model.Vehicle;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class RouteShapeVehicles {
    private Route route;
    private Set<Shape> routeShape;
    private Set<Vehicle> vehicles;
}
