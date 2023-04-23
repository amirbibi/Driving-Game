import java.util.ArrayList;
import java.util.Random;

public class Map {
	Random rand = new Random();
	ArrayList<Junction> junctions = new ArrayList<Junction>();
	ArrayList<Road> roads = new ArrayList<Road>();

	public Map(int junctionQty) {
		for (int i = 0; i < junctionQty; i++) {
			Junction j = new Junction();
			junctions.add(j);

		}
		createRoads();
		createTrafficLights();
	}

	public Map(ArrayList<Junction> junctions, ArrayList<Road> roads) {
		this.junctions = junctions;
		this.roads = roads;
		createTrafficLights();

	}

	public void createRoads() {
		for (Junction start : junctions) {
			for (Junction end : junctions) {
				if (start != end && rand.nextBoolean()) {
					Road newRoad = new Road(start, end);
					roads.add(newRoad);
					start.setExitingRoads(newRoad);
					end.setEnteringRoads(newRoad);
				}
			}
		}
	}

	public void createTrafficLights() {
		for (Junction junc : junctions) {
			if ((junc.getEnteringRoads().size() > 0) && (rand.nextBoolean() && rand.nextBoolean())) {
				if (rand.nextBoolean()) {
					junc.setTl(new RandomTrafficLights(junc));
				} else {
					junc.setTl(new SequentialTrafficLights(junc));
				}
			}
		}
	}

	public ArrayList<Road> getRandomPath() {
		ArrayList<Road> randomPath = new ArrayList<Road>();
		Junction randJunc;
		int randomIndex;
		int counter = 0;

		do {
			randJunc = junctions.get(rand.nextInt(junctions.size()));
		} while (randJunc.getExitingRoads().isEmpty());
		randomPath.add(randJunc.getExitingRoads().get(rand.nextInt(randJunc.getExitingRoads().size())));

		do {
			randomIndex = rand.nextInt(randomPath.get(counter).getEnd().getExitingRoads().size());
			randomPath.add(randomPath.get(counter).getEnd().getExitingRoads().get(randomIndex));
			counter++;
		} while ((!(randomPath.get(counter).getEnd().getExitingRoads().isEmpty())) && (counter < 3));

		return randomPath;

	}
}
