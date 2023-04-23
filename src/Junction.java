import java.util.ArrayList;

public class Junction extends Point {
	private static int counter = 1;
	private int id;
	private ArrayList<Road> enteringRoads = new ArrayList<Road>();
	private ArrayList<Road> exitingRoads = new ArrayList<Road>();
	private TrafficLights tl = null;

	public Junction() {
		super();
		id = counter++;
		System.out.printf("Creating " + this + " at Point (%.2f, %.2f)", super.getX(), super.getY());
		System.out.println();
	}

	public Junction(double x, double y) {
		super(x, y);
		id = counter++;
		System.out.printf("Creating " + this + " at Point (%.2f, %.2f)", super.getX(), super.getY());
		System.out.println();
	}

	public ArrayList<Road> getExitingRoads() {
		return exitingRoads;
	}

	public void setExitingRoads(Road exitRoad) {
		exitingRoads.add(exitRoad);
	}

	public ArrayList<Road> getEnteringRoads() {
		return enteringRoads;
	}

	public void setEnteringRoads(Road enterRoad) {
		enteringRoads.add(enterRoad);
	}

	public void setTl(TrafficLights tl) {
		this.tl = tl;
	}

	public TrafficLights getTl() {
		return tl;
	}

	@Override
	public String toString() {
		return "Junction " + id;
	}

}
