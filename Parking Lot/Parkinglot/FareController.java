package Parkinglot;

import java.math.BigDecimal;
import java.util.*;

public class FareController {
    private Map<Vehicle, ParkingDetails> vehicleParkingDetails = new HashMap<>();

    public void onVehicleEntry(Vehicle vehicle, ParkingLot parkingLot) {
        vehicleParkingDetails.put(vehicle, new ParkingDetails(vehicle, parkingLot, new Date(), null));
    }

    public void onVehicleExit(Vehicle vehicle) {
        ParkingDetails parkingDetails = vehicleParkingDetails.get(vehicle);
        parkingDetails.exit = new Date();
    }

    public BigDecimal getFare(Vehicle vehicle) {
        ParkingDetails parkingDetails = vehicleParkingDetails.get(vehicle);
        return parkingFare(parkingDetails.parkingLot, parkingDetails.entry, parkingDetails.exit);
    }

    private BigDecimal parkingFare(ParkingLot parking, Date entry, Date exit) {
        return null;
    }

}