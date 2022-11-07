package com.markerinterface.replaced;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		ArrayList<Object> li = getObjectList();

		for (Object obj : li) {
			if (obj.getClass().isAnnotationPresent(Urgent.class) ) {
				System.out.println(obj.getClass().getName());
			}
		}

	}

	private static ArrayList<Object> getObjectList() {
		ArrayList<Object> list = new ArrayList<>();
		list.add(new JobWork());
		list.add(new HomeWork());
		return list;
	}

}
