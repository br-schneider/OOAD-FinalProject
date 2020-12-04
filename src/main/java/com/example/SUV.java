package com.example;

public class SUV implements Car{

	String make;
	String model;
	int year;
	String color;
	int mileage;
	double price;

	public SUV() {
        super();
        this.make = "";
        this.model = "";
        this.year = 0;
        this.color = "";
        this.mileage = 0;
        this.price = 0.00;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getMake() {
        return "The make chosen is "+make+".";
    }

    public void setModel(String model) {
    	this.model = model;
    }

    public String getModel() {
    	return "The model chose is "+model+".";
    }

    public void setYear(int year) {
    	this.year = year;
    }

    public int getYear() {
    	return year+ " ";
    }

    public void setColor(String color) {
    	this.color = color;
    }

    public String getColor() {
    	return color+ " ";
    }

    public void setMileage(int mileage) {
    	this.mileage = mileage;
    }

    public String getMileage() {
    	return "Miles: "+mileage+ " ";
    }

    public void setPrice(double price) {
    	this.price = price;
    }

    public String getPrice() {
    	return " $"+price+" ";
    }

}
