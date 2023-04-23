import java.util.ArrayList;
import java.util.Random;

public class Vehicle {
	Random rand = new Random();
	private static int counter = 1;
	int id;
	int speed;
	int currentRoadIndex;
	double distance;
	Map map;
	ArrayList<Road> randomPath = new ArrayList<Road>();
	Road currentRoad;

	public Vehicle(Map map) {
		this.map = map;
		id = counter++;
		currentRoadIndex = 0;
		randomPath = map.getRandomPath();
		speed = rand.nextInt(91) + 30;
		distance = randomPath.get(0).getLength();

		System.out.println("Creating " + this);

	}

	public void move() {
		distance -= speed;
		if (distance <= 0) {
			if ((currentRoadIndex + 1) >= randomPath.size()) {
				System.out.println(
						"Vehicle " + id + " arrived to it's destination: " + randomPath.get(currentRoadIndex).getEnd());
				return;
			} 
			else {
				distance = randomPath.get(++currentRoadIndex).getLength();
			}
		}
		System.out.println("Vehicle " + id + " is moving on the " + randomPath.get(currentRoadIndex));
	}

//	public void move() {
//		if (distance > 0) {
//			distance -= speed;
//			if (distance > 0) {
//				System.out.println("Vehicle " + id + " is moving on the " + randomPath.get(currentRoadIndex));
//			} 
//			else {
//				if ((currentRoadIndex + 1) < randomPath.size()) {
//					distance = randomPath.get(++currentRoadIndex).getLength();
//					System.out.println("Vehicle " + id + " is moving on the " + randomPath.get(currentRoadIndex));
//				} 
//				else {
//					System.out.println("Vehicle " + id + " arrived to it's destination: "
//							+ randomPath.get(currentRoadIndex).getEnd());
//				}
//			}
//		} 
//		else {
//			System.out.println(
//					"Vehicle " + id + " arrived to it's destination: " + randomPath.get(currentRoadIndex).getEnd());
//		}
//	}

	@Override
	public String toString() {
		return "Vehicle " + id + ",speed: " + speed + ", path: " + randomPath;
	}
}
