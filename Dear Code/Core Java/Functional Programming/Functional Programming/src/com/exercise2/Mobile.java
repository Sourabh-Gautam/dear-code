package com.exercise2;

public class Mobile {

	public static void main(String[] args) {
		Wifi wifi = new Jio() ;
		service(wifi);
		
		Wifi wifi2 = new Tata();
		service(wifi2);
	}

	public static void service(Wifi wifi) {
		wifi.internet();
	}
	
}
