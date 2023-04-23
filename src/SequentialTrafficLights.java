
public class SequentialTrafficLights extends TrafficLights {
	private int counter = 0;

	public SequentialTrafficLights(Junction j) {
		super(j);
	}

	@Override
	public void chooseCurrentGreen() {
		setCurrentGreen(this.getMyJunction().getEnteringRoads().get(counter));
		System.out.println(this);

	}

	@Override
	public String toString() {
		return "Sequential TrafficLights " + this.getMyJunction() + ", delay= " + this.getDelay() + ": "
				+ "green light on " + this.getCurrentGreen();
	}
}
