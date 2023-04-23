import java.util.ArrayList;

public class DrivingGame {
	ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	int turnCounter = 1;
	Map map;
	int turns;

	public DrivingGame(int juncQty, int vehicleQty) {
		map = new Map(juncQty);
		for (int i = 0; i < vehicleQty; i++) {
			vehicles.add(new Vehicle(map));
		}
	}

	public void play(int turns) {
		this.turns = turns;
		for (int i = 0; i < turns; i++) {
			System.out.println("Turn " + turnCounter++);
			for (Vehicle v : vehicles) {
				v.move();
			}
			for (Junction j : this.map.junctions) {
				if (j.getTl() != null) {
					j.getTl().check();
				}
			}
		}
	}
}