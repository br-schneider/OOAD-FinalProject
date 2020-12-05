package com.example;

import java.util.Observable;
import java.io.*;

public class Store extends Observable {
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

	public Store(int sedanCount, int coupeCount, int hatchbackCount, int sportscarCount, int truckCount, int suvCount) {
		this.sedanCount = sedanCount;
		this.coupeCount = coupeCount;
		this.hatchbackCount = hatchbackCount;
		this.sportscarCount = sportscarCount;
		this.truckCount = truckCount;
		this.suvCount = suvCount;
	}

	public void decrement(String carType) throws IOException {
		FileWriter writer = new FileWriter("store_inventory.txt", true);

		if (carType.equalsIgnoreCase("sedan")) {
			if (sedanCount == 0) {
				System.out.println("We are out of sedans sorry!");
				return;
			}
			sedanCount--;
			this.setChanged();
			this.notifyObservers();
			writer.write("We have " + sedanCount + " sedans left");
			writer.write("\r\n");

		} else if (carType.equalsIgnoreCase("coupe")) {
			if (coupeCount == 0) {
				System.out.println("We are out of coupes sorry!");
				return;
			}
			coupeCount--;
			this.setChanged();
			this.notifyObservers();
			writer.write("We have " + coupeCount + " coupes left");
			writer.write("\r\n");

		} else if (carType.equalsIgnoreCase("truck")) {
			if (truckCount == 0) {
				System.out.println("We are out of trucks sorry!");
				return;
			}
			truckCount--;
			this.setChanged();
			this.notifyObservers();
			writer.write("We have " + truckCount + " trucks left");
			writer.write("\r\n");

		} else if (carType.equalsIgnoreCase("sportscar")) {
			if (sportscarCount == 0) {
				System.out.println("We are out of sports cars sorry!");
				return;
			}
			sportscarCount--;
			this.setChanged();
			this.notifyObservers();
			writer.write("We have " + sportscarCount + " sports cars left");
			writer.write("\r\n");

		} else if (carType.equalsIgnoreCase("hatchback")) {
			if (hatchbackCount == 0) {
				System.out.println("We are out of hatcbacks sorry!");
				return;
			}
			hatchbackCount--;
			this.setChanged();
			this.notifyObservers();
			writer.write("We have " + hatchbackCount + " hatchbacks left");
			writer.write("\r\n");

		} else if (carType.equalsIgnoreCase("SUV")) {
			if (suvCount == 0) {
				System.out.println("We are out of SUVs sorry!");
				return;
			}
			suvCount--;
			this.setChanged();
			this.notifyObservers();
			writer.write("We have " + suvCount + " SUVs left");
			writer.write("\r\n");
		}
		writer.close();
	}
}
