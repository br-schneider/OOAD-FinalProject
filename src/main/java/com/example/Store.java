package com.example;
import java.util.Observable;


public class Store extends Observable{
	private String type = "store1";
	private String name = "name";
	private int sedanCount = 10;
	private int coupeCount = 10;
	private int hatchbackCount = 10;
	private int sportscarCount = 10;
	private int truckCount = 10;
	private int suvCount = 10;
	
public Store(String name) {
		this.name = name;
	}
	
	public Store(int sedanCount,int coupeCount, int hatchbackCount, int sportscarCount, int truckCount, int suvCount) {
		this.sedanCount = sedanCount;
		this.coupeCount = coupeCount;
		this.hatchbackCount = hatchbackCount;
		this.sportscarCount = sportscarCount;
		this.truckCount = truckCount;
		this.suvCount = suvCount;
	}
	
	public void decrement(String carType) {
		
		if(carType.equalsIgnoreCase("sedan")) {
			for (int i = 0; i < sedanCount; i++) {
				sedanCount --;
				this.setChanged();
		        this.notifyObservers();
			}
			if (sedanCount == 0) {
				System.out.println("We are out of sedans sorry");
			}
		}
		else if (carType.equalsIgnoreCase("coupe")) {
			for (int i = 0; i < coupeCount; i++) {
				coupeCount --;
				this.setChanged();
		        this.notifyObservers();
			}
			if (coupeCount == 0) {
				System.out.println("We are out of coupes sorry");
			}
		}
		else if (carType.equalsIgnoreCase("truck")) {
			for (int i = 0; i < truckCount; i++) {
				truckCount --;
				this.setChanged();
		        this.notifyObservers();
			}
			if (truckCount == 0) {
				System.out.println("We are out of trucks sorry");
			}
		}
		else if (carType.equalsIgnoreCase("sports car")) {
			for (int i = 0; i < sportscarCount; i++) {
				sportscarCount --;
				this.setChanged();
		        this.notifyObservers();
			}
			if (sportscarCount == 0) {
				System.out.println("We are out of sports cars sorry");
			}
		}
		else if (carType.equalsIgnoreCase("hatchback")) {
			for (int i = 0; i < hatchbackCount; i++) {
				hatchbackCount --;
				this.setChanged();
		        this.notifyObservers();
			}
			if (hatchbackCount == 0) {
				System.out.println("We are out of hatcbacks sorry");
			}
		}
		else if (carType.equalsIgnoreCase("SUV")) {
			for (int i = 0; i < suvCount; i++) {
				suvCount --;
				this.setChanged();
		        this.notifyObservers();
			}
			if (suvCount == 0) {
				System.out.println("We are out of SUVs sorry");
			}
		}
		
	}
	
}
