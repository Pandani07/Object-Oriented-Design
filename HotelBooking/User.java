package HotelBooking;

import java.lang.*;
import java.util.*;

abstract class User {
    int userId;
    String name;
    String phone;
    String email;
    String sex;

    abstract void getDiscount();
}

class PaidUser extends User {
    @Override
    void getDiscount() {
        // TODO Auto-generated method stub

    }
}

class PremiumUser extends User {
    @Override
    void getDiscount() {
        // TODO Auto-generated method stub

    }
}

class EnterpriseUser extends User {
    @Override
    void getDiscount() {
        // TODO Auto-generated method stub

    }
}
