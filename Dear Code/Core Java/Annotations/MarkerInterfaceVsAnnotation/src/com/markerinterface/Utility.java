package com.markerinterface;

import java.util.ArrayList;

public class Utility {
	public static ArrayList<Object> getRoutineList(){
		ArrayList<Object> routines = new ArrayList<>();
		routines.add(new GoToSchool());
		routines.add(new GoToTuition());
		routines.add(new PlayCricket());
		routines.add(new GoToMorningWalk());
		routines.add(new SelfStudy());
		routines.add(new TakeMedicine());
		return routines;
	}
}
