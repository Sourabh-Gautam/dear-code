package com.withoutgenerics;

public class Printer {

	Object thingToPrint;

	public Printer(Object thingToPrint) {
		super();
		this.thingToPrint = thingToPrint;
	}
	
	public Object getThingToPrint() {
		return thingToPrint;
	}
	
}
