package com.exercise1;

public class Mobile {

	public static void main(String[] args) {
		
		Sim sim = new Vodafone();
		service(sim);
		
		Sim sim2 = new Airtel();
		service(sim2);
		
	}
	
	public static void service(Sim sim) {
		sim.call();
		sim.message();
		sim.internet();
	}

}
