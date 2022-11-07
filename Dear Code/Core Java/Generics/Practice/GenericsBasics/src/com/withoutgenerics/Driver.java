package com.withoutgenerics;

public class Driver {

	public static void main(String[] args) {
		
//		IntegerPrinter obj = new IntegerPrinter(21);
//		System.out.println(obj.getThingToPrint());
		
		Printer printer1 = new Printer(21);
		System.out.println((Integer)printer1.getThingToPrint() + 10);
		
		Printer printer2 = new Printer(3.14);
		System.out.println(printer2.getThingToPrint());
		
		Printer printer3 = new Printer("Sourabh");
		System.out.println(printer3.getThingToPrint());
		

	}

}


