public class Vehicle {

    public static void main(String[] args) {
        // unit testing here
    }

    protected String brand;
    protected String model;
    protected int speed = 0;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

}

class Car extends Vehicle {

    int gears;
    boolean powerOn = false;

    public Car(String brand, String model, int gears) {
        super(brand, model);
        this.gears = gears;
    }

    public void turnOn() {
        if (!powerOn) {
            powerOn = true;
        }
    }

    public void turnOff() {
        if (powerOn) {
            powerOn = false;
        }
    }

    public void accelerate() {
        this.speed++;
    }

    public void slowDown() {
        if (this.speed > 0) {
            this.speed--;
        }
    }
}

class PickupTruck extends Car {
    
    double bootCapacity;  // in sq meters

    public PickupTruck(String brand, String model, int gears, double bootCapacity) {
        super(brand, model, gears);
        this.bootCapacity = bootCapacity;
    }

}
