package board;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class ScoresLocation extends Location {
	private final int score;

	/**
	 * Creates a Scores location.
	 * 
	 * @param name   The name of this location.
	 * @param scores The value of the score plus at this location.
	 */
	public ScoresLocation(String name, int score, Point2D position) {
		super(name, position);
		this.score = score;
	}

	public int getScore() {
		return score;
	}

}
