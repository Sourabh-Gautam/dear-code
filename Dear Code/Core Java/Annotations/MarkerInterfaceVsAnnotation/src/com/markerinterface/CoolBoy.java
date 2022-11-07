package com.markerinterface;

import java.util.ArrayList;

public class CoolBoy {

	public static void main(String[] args) {
		
		ArrayList<Object> routineList = Utility.getRoutineList();

		
		System.out.println("Mandatory Routines :");
		System.out.println("-------------------------------");
		for(Object obj : routineList) {
			if(obj instanceof MandatoryRoutine) {
				System.out.println(obj);
			}
		}
		
		System.out.println("\nNot Mandatory Routines :");
		System.out.println("-------------------------------");
		for(Object obj : routineList) {
			if(!(obj instanceof MandatoryRoutine)) {
				System.out.println(obj);
			}
		}
		
	}

}
