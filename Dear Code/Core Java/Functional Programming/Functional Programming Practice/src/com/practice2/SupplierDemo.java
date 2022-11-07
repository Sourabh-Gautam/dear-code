package com.practice2;

import java.text.DecimalFormat;
import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {
		double r = random(() -> (Math.random()));
		System.out.println(r);
		DecimalFormat df = new DecimalFormat("########.#######");
		String str = df.format(r);
		System.out.println(str);
	}
	
	public static double random(Supplier<Double> supplier) {
		return supplier.get();
	}

}



