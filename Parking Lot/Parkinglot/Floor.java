package Parkinglot;

import java.util.List;

public class Floor {
    private String floor_id;
    private int floor_number;
    private String floor_name;
    private List<ParkingSlot> parkingSlots;

    public Floor(String floor_id, int floor_number, String floor_name, List<ParkingSlot> parkingSlots) {
        this.floor_id = floor_id;
        this.floor_name = floor_name;
        this.floor_number = floor_number;
        this.parkingSlots = parkingSlots;
    }

    public void emptyFloor() {
        for (ParkingSlot slot : parkingSlots) {
            slot.emptySlot();
        }
    }
}