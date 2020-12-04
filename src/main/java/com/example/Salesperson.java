package com.example;

import java.util.Observable;
import java.util.Observer;

public class Salesperson implements Observer{
	private Store salesperson;

	@Override
	public void update(Observable observable, Object arg) {
		System.out.println("test");

		if (observable instanceof Store) {
			salesperson =  (Store) observable;
			System.out.println("test");
		}
	}
}
		
