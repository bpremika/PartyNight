package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import logic.LocationPointGenerator;
import player.Player;
import sharedResource.ResourceLoader;

public class PlayerPiece extends ImageView {

	private Double xPosition;
	private Double yPosition;
	private Player player;
	public static Image[] playerImages = {ResourceLoader.pilot,ResourceLoader.dino,
			ResourceLoader.duckboii,ResourceLoader.captain,ResourceLoader.mrCat,
			ResourceLoader.penguin};

	public PlayerPiece(Player player) {
		this.player = player;
		setImage(playerImages[player.getPlayerID()]);
		setFitWidth(30);
		setPreserveRatio(true);
		xPosition = LocationPointGenerator.LOCATIONPOINTS[player.getPosition()].getX();
		yPosition = LocationPointGenerator.LOCATIONPOINTS[player.getPosition()].getY()-15;

	}

	public void updatexPosition() {
		System.out.println("Player position : " + player.getPosition());
		this.xPosition = LocationPointGenerator.LOCATIONPOINTS[player.getPosition()].getX();
		this.setTranslateX(xPosition);
	}

	public void updateyPosition() {
		this.yPosition = LocationPointGenerator.LOCATIONPOINTS[player.getPosition()].getY()-15;
		this.setTranslateY(yPosition);
	}

	public Double getxPosition() {
		return xPosition;
	}

	public Double getyPosition() {
		return yPosition;
	}

}
