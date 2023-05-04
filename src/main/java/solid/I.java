package solid;

// Interface segregation

public class I {
    public static void main(String[] args) {

    }
}

// Segregation means keeping things separated, and the Interface Segregation Principle is about separating the interfaces.
// The principle states that many client-specific interfaces are better than one general-purpose interface.
// Clients should not be forced to implement a function they do no need.

class Car {

}

interface ParkingLot {

    void parkCar();    // Decrease empty spot count by 1

    void unparkCar(); // Increase empty spots by 1

    void getCapacity();    // Returns car capacity

    double calculateFee(Car car); // Returns the price based on number of hours

    void doPayment(Car car);
}

class FreeParking implements ParkingLot {

    @Override
    public void parkCar() {

    }

    @Override
    public void unparkCar() {

    }

    @Override
    public void getCapacity() {

    }

    @Override
    public double calculateFee(Car car) {
        return 0;
    }

    @Override
    public void doPayment(Car car) {
        System.out.println("Parking lot is free");
    }
}

// Our parking lot interface was composed of 2 things:
// Parking related logic (park car, unpark car, get capacity) and payment related logic.

interface ParkingLot_ {
    void parkCar();           // Decrease empty spot count by 1

    void unparkCar();       // Increase empty spots by 1

    void getCapacity();   // Returns car capacity
}

interface PaidParkingLot_ extends ParkingLot_ {
    void doPayment(Car car);
}

interface FreeParkingLot_ extends ParkingLot_ { }

interface HourlyFeeParkingLot_ extends PaidParkingLot_ {
    double calculateFee(Car car); // Returns the price based on number of hours
}
interface ConstantFeeParkingLot_ extends PaidParkingLot_ { }


class FreeParkingImpl implements FreeParkingLot_ {

    @Override
    public void parkCar() {

    }

    @Override
    public void unparkCar() {

    }

    @Override
    public void getCapacity() {

    }
}
class ConstantFeeParkingLotImpl implements ConstantFeeParkingLot_ {

    @Override
    public void parkCar() {

    }

    @Override
    public void unparkCar() {

    }

    @Override
    public void getCapacity() {

    }

    @Override
    public void doPayment(Car car) {

    }
}
class HourlyFeeParkingLotImpl implements HourlyFeeParkingLot_ {

    @Override
    public void parkCar() {

    }

    @Override
    public void unparkCar() {

    }

    @Override
    public void getCapacity() {

    }

    @Override
    public void doPayment(Car car) {

    }

    @Override
    public double calculateFee(Car car) {
        return 0;
    }
}