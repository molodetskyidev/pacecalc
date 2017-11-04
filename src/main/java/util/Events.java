package util;

public class Events {

	// method returns distance depends on event

	public int returnDistance(String evntName) {
		int evntDistance = 0;

		switch (evntName) {
		case "Marathon":
			evntDistance = 42195;
			break; // marathon event
		case "Halfmarathon":
			evntDistance = 21097;
			break; // halfmarathon event
		case "10k":
			evntDistance = 10000;
			break; // 10 000 m event
		default:
			evntDistance = 0;
			break; // if nothing return 0
		}

		return evntDistance;

	}
}
