package com.practice2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();
		list.add("Sou");
		list.add("rabh");
		list.add("Div");
		list.add("yam");
		list.add("doot");
		
//		print(list, (x) ->  System.out.println(x));
		
		print(list, (x) -> System.out.println(x));

	}
	
	public static void print(List<String>  li, Consumer<String> consumer) {
		
		for(String str : li) {
			consumer.accept(str);
		}
		
	}
	
//	public static void print(ArrayList<String> list, PrintInteger pi) {
//		for(String str : list) {
//			pi.printInt(str);
//		}
//	}

}
