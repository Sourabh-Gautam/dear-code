package com.withgenerics;

public class Printer<T> {

	T thingToPrint;

	public Printer(T thingToPrint) {
		super();
		this.thingToPrint = thingToPrint;
	}
	
	public T getThingToPrint() {
		return thingToPrint;
	}
	
}
