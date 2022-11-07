package custom.type.markerannotation;

public class Bike {
	
	@RunImmediately
	public void start() {
		System.out.println("Bike started");
	}
	
	public void accelerate() {
		System.out.println("Bike accelerated");
	}
	
	public void stop() {
		System.out.println("Bike stopped");
	}
	
}
