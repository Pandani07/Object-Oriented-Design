package HotelBooking;

import java.util.*;

interface AggregatorService {
    void bookRoom(int hotelId, int userId, List<Room> rooms);
}

class ExistingBookingSystem {
    public void bookRoomInHotel(int hotelId, int userId, List<Room> rooms) {
    }
}

public class AggregatorAdapter implements AggregatorService {
    private ExistingBookingSystem bookingSystem;

    public AggregatorAdapter(ExistingBookingSystem bookingSystem) {
        this.bookingSystem = bookingSystem;
    }

    @Override
    public void bookRoom(int hotelId, int userId, List<Room> rooms) {
        bookingSystem.bookRoomInHotel(hotelId, userId, rooms);
    }
}