public class Car {

    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car(String name, int cylinders) {
        this.name = name;
        this.engine = true;
        this.cylinders = cylinders;
        this.wheels = 4;
    }

    public String carInfo() {
        return "Car name: " + getName() +
                "\nCylinders: " + getCylinders() +
                "\nWheels: 4";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public String startEngine() {
        return "The engine of " + getName() + " has been started.";
    }

    public String accelerate() {
        return getName() + " is accelerating.";
    }

    public String brake() {
        return getName() + " hit the brakes.";
    }

}

class Honda extends Car {

    private String model;

    public Honda(String name, String model, int cylinders) {
        super(name, cylinders);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String carInfo() {
        return "Car name: " + getName() +
                "\nModel: " + getModel() +
                "\nCylinders: " + getCylinders() +
                "\nWheels: 4";
    }

    @Override
    public String startEngine() {
        return "The engine of "+ getName() + " " + getModel() + " has been started.";
    }

    @Override
    public String accelerate() {
        return getName() + " " + getModel() + " is accelerating.";
    }

    @Override
    public String brake() {
        return getName() + " " + getModel() + " hit the brakes.";
    }

}

class Toyota extends Car {

    private String model;

    public Toyota(String name, String model, int cylinders) {
        super(name, cylinders);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String carInfo() {
        return "Car name: " + getName() +
                "\nModel: " + getModel() +
                "\nCylinders: " + getCylinders() +
                "\nWheels: 4";
    }

    @Override
    public String startEngine() {
        return "The engine of "+ getName() + " " + getModel() + " has been started.";
    }

    @Override
    public String accelerate() {
        return getName() + " " + getModel() + " is accelerating.";
    }

    @Override
    public String brake() {
        return getName() + " " + getModel() + " hit the brakes.";
    }

}

class Kia extends Car {

    private String model;

    public Kia(String name, String model, int cylinders) {
        super(name, cylinders);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String carInfo() {
        return "Car name: " + getName() +
                "\nModel: " + getModel() +
                "\nCylinders: " + getCylinders() +
                "\nWheels: 4";
    }

    @Override
    public String startEngine() {
        return "The engine of "+ getName() + " " + getModel() + " has been started.";
    }

    @Override
    public String accelerate() {
        return getName() + " " + getModel() + " is accelerating.";
    }

    @Override
    public String brake() {
        return getName() + " " + getModel() + " hit the brakes.";
    }

}

/*
UNIT TESTING IN MAIN:

    Honda Fit = new Honda("Honda","Fit",3);
    System.out.println("");
    System.out.println(Fit.carInfo());
    System.out.println("");
    System.out.println(Fit.startEngine());
    System.out.println("");
    System.out.println(Fit.accelerate());
    System.out.println("");
    System.out.println(Fit.brake());
    System.out.println("");

    Toyota Supra = new Toyota("Toyota","Supra",4);
    System.out.println("");
    System.out.println(Supra.carInfo());
    System.out.println("");
    System.out.println(Supra.startEngine());
    System.out.println("");
    System.out.println(Supra.accelerate());
    System.out.println("");
    System.out.println(Supra.brake());
    System.out.println("");

    Kia Optima = new Kia("Kia","Optima",4);
    System.out.println("");
    System.out.println(Optima.carInfo());
    System.out.println("");
    System.out.println(Optima.startEngine());
    System.out.println("");
    System.out.println(Optima.accelerate());
    System.out.println("");
    System.out.println(Optima.brake());
    System.out.println("");

*/
