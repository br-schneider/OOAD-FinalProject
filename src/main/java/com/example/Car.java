package com.example;

public class Car {
    String type;
    String make;
    String model;
    int year;
    int mileage;
    String color;
    double price;

    public Car(String type, String make, String model,int year,int mileage, String color, double price) {
        this.type = type;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.color = color;
        this.price = price;
    }

    String getType() {
        return type;
    }

    String getMake() {
        return make;
    }

    String getModel() {
        return model;
    }
    int getYear() {
        return year;
    }

    int getMileage() {
        return mileage;
    }

    String getColor() {
        return color;
    }

    Double getPrice() {
        return price;
    }

    String printCar() {
        return ("Type: " + type + ",  Make: " + make + ",  Model: " + model + ",  Year: " + Integer.toString(year)
                + ",  Mileage: " + Integer.toString(mileage) + ",  Color: " +color + ",  Price: $" + Double.toString(price)
                +  "\r\n");
    }

    String printMakeModelYear() {
        return (Integer.toString(year) + " " + make + " " + model);
    }

    String quickDescription() {
        return ("This " + make + " " + model + " is " + color + " and has " + Integer.toString(mileage) + " miles on it!");
    }

    String printPricing() {
        return("Priced at $" + price + "");
    }

}
