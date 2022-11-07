package com.exercise1;

public class Airtel implements Sim {

	@Override
	public void internet() {
		System.out.println("Internet surfing using Airtel");
	}

	@Override
	public void call() {
		System.out.println("Calling using Airtel");
	}

	@Override
	public void message() {
		System.out.println("Messaging using Airtel");
	}
	
}
