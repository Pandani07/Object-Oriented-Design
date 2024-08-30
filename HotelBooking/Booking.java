package HotelBooking;

import java.util.Date;
import java.util.List;

public class Booking {
    int bookingId;
    int userId;
    int hotelId;
    List<Room> bookedRooms;
    int amount;

    PaymentStatus status;
    Date check_in;
    Date check_out;
    PaymentStrategy paymentStrategy;

    public void makePayment() {
        paymentStrategy.pay(this.amount);
        this.status = PaymentStatus.PAID;
    }
}
