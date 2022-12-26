package board;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.LocationPointGenerator;
import sharedResource.ResourceLoader;

public class Board extends StackPane {
	private static ArrayList<Location> boardLocations;
	private final String mapURL = "images/map.png";

	public Board() {
		boardLocations = new ArrayList<>();
		String image_path = ClassLoader.getSystemResource(this.mapURL).toString();
		ImageView mapIMG = new ImageView(new Image(image_path));
		mapIMG.setFitWidth(960);
		mapIMG.setFitHeight(540);
		getChildren().add(mapIMG);
		populateLocations();
		placeLocations();
	}

	private void populateLocations() {
		boardLocations.add(new StartLocation("start", LocationPointGenerator.LOCATIONPOINTS[0]));
		for (int i = 1; i < 68; i++) {
			if (i == 51) {
				boardLocations.add(new ScoresLocation("+500", 500, LocationPointGenerator.LOCATIONPOINTS[i]));
			} else if (i % 8 == 0) {
				boardLocations.add(new ScoresLocation("+100", 100, LocationPointGenerator.LOCATIONPOINTS[i]));
			} else if (i % 13 == 0) {
				boardLocations.add(new ScoresLocation("+50", 50, LocationPointGenerator.LOCATIONPOINTS[i]));
			} else if (i % 7 == 0) {
				boardLocations.add(new ScoresLocation("+20", 20, LocationPointGenerator.LOCATIONPOINTS[i]));
			} else if (i % 5 == 0) {
				boardLocations.add(new ChanceLocation("chance", LocationPointGenerator.LOCATIONPOINTS[i]));
			} else if (i % 2 == 0) {
				boardLocations.add(new ScoresLocation("+10", 10, LocationPointGenerator.LOCATIONPOINTS[i]));
			} else {
				boardLocations.add(new CommonLocation(String.valueOf(i), LocationPointGenerator.LOCATIONPOINTS[i]));
			}
		}
		boardLocations.add(new JailLocation("Jail", LocationPointGenerator.LOCATIONPOINTS[68]));

	}

	private void placeLocations() {
		for (var location : boardLocations) {
			Circle circle = new Circle(10);
			if (location instanceof ScoresLocation) {
				switch (((ScoresLocation) location).getScore()) {
				case 10:
					circle.setFill(new ImagePattern(ResourceLoader.plus10));
					break;
				case 20:
					circle.setFill(new ImagePattern(ResourceLoader.plus20));
					break;
				case 50:
					circle.setFill(new ImagePattern(ResourceLoader.plus50));
					break;
				case 100:
					circle.setFill(new ImagePattern(ResourceLoader.plus100));
					break;
				case 500:
					circle.setFill(new ImagePattern(ResourceLoader.plus500));
					break;
				}
			} else if (location instanceof ChanceLocation) {
				circle.setFill(new ImagePattern(ResourceLoader.chance));
			} else if (location instanceof JailLocation) {
				circle.setFill(new ImagePattern(ResourceLoader.jail));
			} else if (location instanceof StartLocation) {
				circle.setFill(new ImagePattern(ResourceLoader.start));
			} else {
				circle.setFill(Color.web("A1A1A1"));
			}
			getChildren().addAll(circle);
			circle.setTranslateX(location.getPosition().getX());
			circle.setTranslateY(location.getPosition().getY());
		}
	}

	public static Location getLocation(int position) {
		if (position >= 0 && position <= 68)
			return boardLocations.get(position);
		else
			return null;

	}

	public int getLocationPosition(Location location) {
		return boardLocations.indexOf(location);
	}

}
