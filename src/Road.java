
public class Road {
	private Junction start;
	private Junction end;

	public Road(Junction s, Junction e) {
		end = checkJuncs(s, e);
		start = s;

		if (this.getEnd() != e) {
			System.out.println("Road can not connect a junction to itself, the end junction has been replaced with "
					+ this.getEnd());
		}

		start.setExitingRoads(this);
		end.setEnteringRoads(this);

		System.out.printf("Creating " + this + ", length: %.2f", start.calcDistance(end));
		System.out.println();
	}

	public Junction checkJuncs(Junction s, Junction e) {
		if ((s.getX() == e.getX()) && (s.getY() == e.getY())) {
			return new Junction();
		} else {
			return e;
		}
	}

	public Junction getStart() {
		return start;
	}

	public void setStart(Junction start) {
		this.start = start;
	}

	public Junction getEnd() {
		return end;
	}

	public void setEnd(Junction end) {
		this.end = end;
	}

	public double getLength() {
		return (start.calcDistance(end));
	}

	@Override
	public String toString() {
		return "Road from " + start + " to " + end;
	}

}