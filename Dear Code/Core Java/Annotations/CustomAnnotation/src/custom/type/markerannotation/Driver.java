package custom.type.markerannotation;

import java.lang.reflect.Method;

public class Driver {
	public static void main(String[] args) throws Exception {
		Bike bike = new Bike();
		Method[] methods = bike.getClass().getMethods();
		for(Method method : methods) {
			if(method.isAnnotationPresent(RunImmediately.class)) {
				method.invoke(bike);
			}
		}
	}
}
