package com.example;

public class Sedan implements Car{
	
	String make;
	String model;
	int year;
	String color;
	int mileage;
	double price;

	public Sedan() {
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
        return "The sedan make chosen is "+make+".";
    }
    
    
    public void setModel(String model) {
    	this.model = model;
    }
    
    
    public String getModel() {
    	return "The sedan model chose is "+model+".";
    }
    
    public void setYear(int year) {
    	this.year = year;
    }
    
    
    public String getYear() {
    	return "The sedan year chosen is "+year+".";
    }
    
    @Override
    public void setColor(String color) {
    	this.color = color;
    }
    
    
    public String getColor() {
    	return "The sedan color chosen is "+color+".";
    }
    
    
    public void setMileage(int mileage) {
    	this.mileage = mileage;
    }
    
    
    public String getMileage() {
    	return "The sedan mileage of the chosen car is "+mileage+".";
    }
    
    
    public void setPrice(double price) {
    	this.price = price;
    }
    
    
    public String getPrice() {
    	return "The sedan price for the car chosen is "+price+".";
    }
    
}
