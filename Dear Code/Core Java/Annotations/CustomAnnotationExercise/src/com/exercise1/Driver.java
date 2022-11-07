package com.exercise1;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws Exception {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter Name : ");
		String name = kb.next();
		System.out.println("Enter Email : ");
		String email = kb.next();
		Person person = new Person();
		person.setName(name);
		person.setEmail(email);
		
		Field[] fields = person.getClass().getDeclaredFields();
		for(Field field : fields) {
			if(field.isAnnotationPresent(Capitalize.class)) {
				field.set(person, field.get(person).toString().toUpperCase());
			}
		}
		
		System.out.println(person.toString());
		kb.close();
	}
}
