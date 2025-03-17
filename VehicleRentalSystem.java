abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    Vehicle(String vehicleNumber, String type, double rentalRate) {
        setVehicleNumber(vehicleNumber);
        setType(type);
        setRentalRate(rentalRate);
    }

    public void vehicleDetails() {
        System.out.println("Vehicle Number: " + this.vehicleNumber);
        System.out.println("Vehicle Type: " + this.type);
        System.out.println("Rental Rate per day: " + this.rentalRate);
    }

    public String getVehicleNumber() {
        return this.vehicleNumber;
    }

    public String getType() {
        return this.type;
    }

    public double getRentalRate() {
        return this.rentalRate;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    abstract double calculateRentalCost(int days);
}

interface Insurable {
    void calculateInsurance();
    double getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private double insuranceCost;

    Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public void calculateInsurance() {
        this.insuranceCost = getRentalRate() * 0.05;
    }

    @Override
    public double getInsuranceDetails() {
        return this.insuranceCost;
    }
}

class Bike extends Vehicle implements Insurable {
    private double insuranceCost;

    Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public void calculateInsurance() {
        this.insuranceCost = getRentalRate() * 0.03;
    }

    @Override
    public double getInsuranceDetails() {
        return this.insuranceCost;
    }
}

class Truck extends Vehicle implements Insurable {
    private double insuranceCost;

    Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public void calculateInsurance() {
        this.insuranceCost = getRentalRate() * 0.1;
    }

    @Override
    public double getInsuranceDetails() {
        return this.insuranceCost;
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle car = new Car("C123", 1000);
        Vehicle bike = new Bike("B456", 500);
        Vehicle truck = new Truck("T789", 2000);

        Vehicle[] vehicles = {car, bike, truck};

        for (Vehicle v : vehicles) {
            v.vehicleDetails();
            System.out.println("Rental Cost for 5 days: " + v.calculateRentalCost(5));
            ((Insurable) v).calculateInsurance();
            System.out.println("Insurance Cost: " + ((Insurable) v).getInsuranceDetails());
        }
    }
}