package com.exercise3;

public class Mobile {

	public static void main(String[] args) {
		Wifi wifi = new Wifi() {

			@Override
			public void internet() {
				System.out.println("Internet surfing through Wifi from Jio");
			}

		};
		
		wifi.internet();
		
	}
	
}
