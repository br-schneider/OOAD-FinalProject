package com.example;
import java.util.Observable;
import java.util.Observer;
import java.io.*;


public class Salesperson implements Observer {
	private Store salesperson;

	@Override
	public void update(Observable observable, Object arg) {
		if (observable instanceof Store) {
			salesperson = (Store) observable;
			System.out.println("Hello this is David, the salesman, thank you for your purchase!");
		}
	}
}
