package cz.fit.cvut.pidbackend.Model.Dto;

import cz.fit.cvut.pidbackend.Model.Trip;
import cz.fit.cvut.pidbackend.Model.Vehicle;

public class TripVehicleDto {
    private Trip trip;
    private Vehicle vehicles;

    public TripVehicleDto(Trip trip, Vehicle vehicles) {
        this.trip = trip;
        this.vehicles = vehicles;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Vehicle getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicle vehicles) {
        this.vehicles = vehicles;
    }
}
