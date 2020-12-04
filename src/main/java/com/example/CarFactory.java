package com.example;

public class CarFactory {

	public static Car getCar(String carType) {
		
		if (carType == null) {
			return null;
		}
		else if(carType.equalsIgnoreCase("Sedan")) {
			return new Sedan();
		}
		else if (carType.equalsIgnoreCase("Coupe")) {
			return new Coupe();
		}
		else if (carType.equalsIgnoreCase("SUV")) {
			return new SUV();
		}
		else if (carType.equalsIgnoreCase("Hatchback")) {
			return new Hatchback();
		}
		else if (carType.equalsIgnoreCase("Truck")) {
			return new Truck();
		}
		else if (carType.equalsIgnoreCase("SportsCar")) {
			return new SportsCar();
		}
		return null;
	}
}
