import java.util.Random;

public class RandomTrafficLights extends TrafficLights {

	public RandomTrafficLights(Junction j) {
		super(j);
	}

	@Override
	public void chooseCurrentGreen() {
		Random rand = new Random();
		setCurrentGreen(this.getMyJunction().getEnteringRoads()
				.get(rand.nextInt(this.getMyJunction().getEnteringRoads().size())));
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Random TrafficLights " + this.getMyJunction() + ", delay= " + this.getDelay() + ": " + "green light on "
				+ this.getCurrentGreen();
	}
}
