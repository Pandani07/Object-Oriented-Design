package Parkinglot;

import java.math.BigDecimal;
import java.util.*;

enum ParkingStatus {
    Empty,
    Occupied
}

enum VehicleType {
    BIKE,
    COMPACT,
    SEDAN,
    SUV
}

enum SlotSize {
    BIKE {
        @Override
        public boolean canPark(VehicleType vehicleType) {
            return vehicleType == VehicleType.BIKE;
        }
    },
    SMALL {
        @Override
        public boolean canPark(VehicleType vehicleType) {
            return vehicleType == VehicleType.COMPACT;
        }
    },
    MEDIUM {
        @Override
        public boolean canPark(VehicleType vehicleType) {
            return vehicleType == VehicleType.SEDAN;
        }
    },
    LARGE {
        @Override
        public boolean canPark(VehicleType vehicleType) {
            return vehicleType == VehicleType.SUV;
        }
    };

    public abstract boolean canPark(VehicleType vehicleType);

}

public class ParkingLot {
    private String parking_lot_id;
    private List<Floor> floors;
    private String parking_lot_name;
    private String address;

    public ParkingLot(String parking_lot_id, List<Floor> floors, String parking_lot_name, String address) {
        this.parking_lot_id = parking_lot_id;
        this.floors = floors;
        this.parking_lot_name = parking_lot_name;
        this.address = address;
    }

    public void emptyParkingLot() {
        for (Floor floor : floors) {
            floor.emptyFloor();
        }
    }

}

class Bike implements Vehicle {
    private String bike_number;

    public Bike(String bike_number) {
        this.bike_number = bike_number;
    }

    @Override
    public String toString() {
        return "Bike number = " + this.bike_number;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }

}

class Compact implements Vehicle {
    private String car_number;

    public Compact(String car_number) {
        this.car_number = car_number;
    }

    @Override
    public String toString() {
        return "Car number = " + this.car_number;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.COMPACT;
    }

}

class Sedan implements Vehicle {
    private String car_number;

    public Sedan(String car_number) {
        this.car_number = car_number;
    }

    @Override
    public String toString() {
        return "Car number = " + this.car_number;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.SEDAN;
    }

}

class SUV implements Vehicle {
    private String car_number;

    public SUV(String car_number) {
        this.car_number = car_number;
    }

    @Override
    public String toString() {
        return "Car number = " + this.car_number;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.SUV;
    }

}
