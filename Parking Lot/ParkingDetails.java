package Parkinglot;

import java.util.*;

public class ParkingDetails {
    Vehicle vehicle;
    ParkingLot parkingLot;
    Date entry;
    Date exit;

    public ParkingDetails(Vehicle vehicle, ParkingLot parkingLot, Date entry, Date exit) {
        this.vehicle = vehicle;
        this.parkingLot = parkingLot;
        this.entry = entry;
        this.exit = exit;
    }
}