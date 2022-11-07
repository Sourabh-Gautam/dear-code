package custom.type.multivalueannotation;

public class Bike {
	
	public void start() {
		System.out.println("Bike started");
	}
	
	@RunAfterStart( times=3, speed= {20, 40, 60})
	public void accelerate(int speed) {
		System.out.println("Bike accelerated - Current speed is "+speed);
	}
	
	public void stop() {
		System.out.println("Bike stopped");
	}
	
}
