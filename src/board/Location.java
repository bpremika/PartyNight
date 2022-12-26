package board;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public abstract class Location {

	private final String name;
	private final Point2D position;

	public Location(String name, Point2D position) {
		this.name = new String(name);
		this.position = position;
		
	}

	public String getName() {
		return name;
	}

	public Point2D getPosition() {
		return position;
	}

}