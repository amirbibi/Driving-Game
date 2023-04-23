import java.util.Random;

public abstract class TrafficLights {
	private Random rand = new Random();
	private int delay;
	private Junction myJunction;
	private Road currentGreen;
	private int turns = 0;

	public TrafficLights(Junction j) {
		this.myJunction = j;
		this.delay = rand.nextInt(3) + 2;
		this.chooseCurrentGreen();
	}

	public abstract void chooseCurrentGreen();

	public Road getCurrentGreen() {
		return currentGreen;
	}

	public void check() {
		if (++turns % delay == 0) {
			chooseCurrentGreen();
		}
	}

	public int getDelay() {
		return delay;
	}

	public Junction getMyJunction() {
		return myJunction;
	}

	public void setCurrentGreen(Road currentGreen) {
		this.currentGreen = currentGreen;
	}

}
