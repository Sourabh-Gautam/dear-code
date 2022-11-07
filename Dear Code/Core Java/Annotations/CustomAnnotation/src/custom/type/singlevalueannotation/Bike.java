package custom.type.singlevalueannotation;

public class Bike {
	
	public void start() {
		System.out.println("Bike started");
	}
	
	@RunAfterStart(times=3)
	public void accelerate() {
		System.out.println("Bike accelerated");
	}
	
	public void stop() {
		System.out.println("Bike started");
	}
	
}
