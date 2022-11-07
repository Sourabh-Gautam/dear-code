package com.withgenerics;

public class Driver {

	public static void main(String[] args) {
		
		Printer<Integer> obj = new Printer<>(24);
		System.out.println(obj.getThingToPrint()+10);
		
		Printer<Double> obj2 = new Printer<>(3.14);
		System.out.println(obj2.getThingToPrint()+1.86);
		
		Printer<String> obj3 = new Printer<>("Sourabh");
		System.out.println(obj3.getThingToPrint()+" Gautam");

	}

}
