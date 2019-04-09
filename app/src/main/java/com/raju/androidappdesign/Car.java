package com.raju.androidappdesign;

public class Car {

    private int vehicleNumber;
    private String make, color;
    private int year;
    private double price, engineSize;

    public Car(int vehicleNumber, String make, String color, int year, double price, double engineSize) {
        this.vehicleNumber = vehicleNumber;
        this.make = make;
        this.color = color;
        this.year = year;
        this.price = price;
        this.engineSize = engineSize;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public String getMake() {
        return make;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public double getEngineSize() {
        return engineSize;
    }
}
