package com.exercise1;

public class Vodafone implements Sim {

	@Override
	public void internet() {
		System.out.println("Internet surfing using Vodafone");
	}

	@Override
	public void call() {
		System.out.println("Calling using Vodafone");
	}

	@Override
	public void message() {
		System.out.println("Messaging using Vodafone");
	}

}
