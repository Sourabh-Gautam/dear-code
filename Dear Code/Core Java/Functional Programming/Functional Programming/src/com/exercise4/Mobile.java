package com.exercise4;

public class Mobile {

	public static void main(String[] args) {
		
		Wifi wifi = () -> {
			System.out.println("Internet surfing through Wifi from Jio");
		};

		wifi.internet();

	}

}
