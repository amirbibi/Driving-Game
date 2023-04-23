import java.util.Random;

public class Point {
	private final int X_MAX = 800;
	private final int Y_MAX = 600;
	private final int MIN_VAL = 0;
	private double x;
	private double y;
	Random rand = new Random();

	public Point() {
		x = (rand.nextInt(800) + rand.nextDouble());
		y = (rand.nextInt(600) + rand.nextDouble());

		if (!(this instanceof Junction)) {
			System.out.println("Creating " + this);
		}
	}

	public Point(double x, double y) {
		this.x = checkVal(x, MIN_VAL, X_MAX);
		this.y = checkVal(y, MIN_VAL, Y_MAX);

		if (this.x != x) {
			System.out.println(x + " is illegal value for x and has been replaced with " + this.x);
		}

		if (this.y != y) {
			System.out.println(y + " is illegal value for y and has been replaced with " + this.y);
		}

		if (!(this instanceof Junction)) {
			System.out.println("Creating " + this);
		}

	}

	public double checkVal(double num, int min, int max) {
		if ((num < min) || (num > max)) {
			num = rand.nextInt(max) + rand.nextDouble();
		}
		return num;
	}

	public double calcDistance(Point other) {
		return (Math.sqrt((Math.pow((other.getX() - x), 2) + Math.pow((other.getY() - y), 2))));
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return String.format("Point (%.2f, %.2f)", x, y);

	}

}
