
package Parkinglot;

public class ParkingSlot {
    private String slot_id;
    private String slot_number;
    private ParkingStatus status;
    private SlotSize slot_size;
    private Vehicle vehicle;

    public ParkingSlot(String slot_id, String slot_number, ParkingStatus status, SlotSize slot_size) {
        this.slot_id = slot_id;
        this.slot_number = slot_number;
        this.status = status;
        this.slot_size = slot_size;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (slot_size.canPark(vehicle.getType())) {
            this.vehicle = vehicle;
            this.status = ParkingStatus.Occupied;
            System.out.println(vehicle.toString() + " parked in slot " + slot_number);
        } else {
            System.out.println(vehicle.toString() + " cannot be parked in slot " + slot_number);
        }
    }

    public void emptySlot() {
        this.vehicle = null;
        this.status = ParkingStatus.Empty;
        System.out.println("Slot " + slot_number + " is now empty.");
    }
}