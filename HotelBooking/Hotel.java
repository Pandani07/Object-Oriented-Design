package HotelBooking;

import java.util.*;

public interface Hotel {
    int getStars();

    String getDescription();

    float getCost();
}

class BasicHotel implements Hotel {
    private int stars;

    public BasicHotel() {
        this.stars = 3;
    }

    @Override
    public String getDescription() {
        return "Basic Hotel";
    }

    @Override
    public float getCost() {
        return 100; // base cost
    }

    @Override
    public int getStars() {
        return this.stars;
    }
}

class FiveStar implements Hotel {
    private int stars;

    public FiveStar() {
        this.stars = 5;
    }

    @Override
    public String getDescription() {
        return "Basic Hotel";
    }

    @Override
    public float getCost() {
        return 100; // base cost
    }

    @Override
    public int getStars() {
        return this.stars;
    }
}

class Luxury implements Hotel {
    private int stars;

    public Luxury() {
        this.stars = 7;
    }

    @Override
    public String getDescription() {
        return "Basic Hotel";
    }

    @Override
    public float getCost() {
        return 100; // base cost
    }

    @Override
    public int getStars() {
        return this.stars;
    }
}

abstract class HotelDecorator implements Hotel {
    protected Hotel decoratedHotel;

    public HotelDecorator(Hotel hotel) {
        this.decoratedHotel = hotel;
    }

    @Override
    public String getDescription() {
        return decoratedHotel.getDescription();
    }

    @Override
    public float getCost() {
        return decoratedHotel.getCost(); // base cost
    }

    @Override
    public int getStars() {
        return decoratedHotel.getStars();
    }

}