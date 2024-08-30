package HotelBooking;

import java.util.*;
import java.lang.*;

public interface PaymentStrategy {
    void pay(int amount);
}

class CashPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {

    }
}

class CardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
    }
}

class DigitalWalletPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        // logic to handle digital wallet payment
    }
}

