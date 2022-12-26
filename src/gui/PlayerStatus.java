package gui;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import player.Player;
import sharedResource.ResourceLoader;

public class PlayerStatus extends HBox {
	private ProgressBar healthBar;
	private Label playerName;
	private Player player;
	private Label playerScore;
	private ImageView profile;
	public static Image[] profileImages = {ResourceLoader.pilot_profile,ResourceLoader.dino_profile,
			ResourceLoader.duckboii_profile,ResourceLoader.captain_profile,ResourceLoader.mrCat_profile,
			ResourceLoader.penguin_profile};

	public PlayerStatus(Player player) {
		// TODO Auto-generated constructor stub
		this.setSpacing(5);
		this.setPadding(new Insets(5));
		this.setPlayer(player);

		profile = new ImageView();
		profile.setImage(profileImages[player.getPlayerID()]);
		profile.setFitWidth(50);
		profile.setFitHeight(50);

		VBox playerStatus = new VBox();
		playerName = new Label(player.getName());
		playerName.setFont(Font.font("Segoe UI Semibold", 15));
		playerName.setTextFill(Color.WHITE);

		healthBar = new ProgressBar();
		healthBar.setStyle("-fx-accent: #14C345;");
		healthBar.setProgress(this.player.getHp() / 100.0);
		healthBar.setPrefHeight(15);

		playerScore = new Label("Score : " + player.getScores());
		playerScore.setFont(Font.font("Segoe UI Semibold", 10));
		playerScore.setTextFill(Color.WHITE);

		playerStatus.getChildren().addAll(playerName, healthBar, playerScore);

		this.getChildren().addAll(profile, playerStatus);

	}

	public ProgressBar getHealthBar() {
		return healthBar;
	}

	public void setHealthBar(ProgressBar healthBar) {
		this.healthBar = healthBar;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void updateHealth() {
		Platform.runLater(() -> {
			healthBar.setProgress(this.player.getHp() / 100.0);
			System.out.println(this.player.getHp() / 100.0);
		});
	}

	public Label getPlayerScore() {
		return playerScore;
	}

	public void updatePlayerScore() {
		System.out.println("scores" + player.getScores());
		Platform.runLater(() -> {
			playerScore.setText("Score : " + player.getScores());
		});
	}

}
