package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import board.Board;
import gui.CardCollectionsPane;
import gui.DiePane;
import gui.MenuPopUp;
import gui.PlayerPiece;
import gui.PlayerStatusPane;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.Window;
import logic.GameLogic;
import player.Player;
import sharedResource.ResourceLoader;

public class GameScene extends Scene {

	public static StackPane root;
	private static PlayerStatusPane playerStatusPane;
	private static CardCollectionsPane cardCollectionPane;
	private static DiePane diePane;
	private static MenuPopUp menuPopUp;
	public static Pane pane;
	public static Player activePlayer;
	private static Label turnDisplay;
	public static AnimationTimer startSceneSong;
	private Board board;
	private boolean isPopUp;

	public GameScene() {
		super(new Pane());
		pane = new Pane();
		pane.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		isPopUp = false;
		ResourceLoader.mainmenu_music.stop();
		Main.mainSong.stop();
		startSceneSong = new AnimationTimer() {
			public void handle(long now) {
				if (!ResourceLoader.themeSong_music.isPlaying()) {
					ResourceLoader.themeSong_music.play(0.5);
				}
			}
		};
		startSceneSong.start();
		root = new StackPane();
		playerStatusPane = new PlayerStatusPane();

		board = new Board();
		activePlayer = GameLogic.getInstance().getActivePlayer();

		cardCollectionPane = new CardCollectionsPane();

		diePane = new DiePane();

		turnDisplay = new Label(activePlayer.getName() + "'s Turn");
		turnDisplay.setTextFill(Color.WHITE);
		turnDisplay.setFont(Font.font("Segoe UI Black", 20));

		root.getChildren().addAll(board, playerStatusPane, cardCollectionPane, turnDisplay);
		StackPane.setAlignment(playerStatusPane, Pos.TOP_LEFT);
		StackPane.setAlignment(cardCollectionPane, Pos.CENTER_RIGHT);
		;
		StackPane.setAlignment(diePane, Pos.BOTTOM_CENTER);
		StackPane.setAlignment(turnDisplay, Pos.BOTTOM_LEFT);

		for (PlayerPiece playerSprike : GameLogic.playerPieces) {
			root.getChildren().add(playerSprike);
			playerSprike.setTranslateX(playerSprike.getxPosition());
			playerSprike.setTranslateY(playerSprike.getyPosition());
		}
		
		root.getChildren().add(diePane);
		setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ESCAPE && !isPopUp) {
				menuPopUp = new MenuPopUp(e -> {
					root.getChildren().remove(root.getChildren().size() - 1);
					root.getChildren().remove(root.getChildren().size() - 1);
					ResourceLoader.buttonClicked.play();
					isPopUp = false;
				});
				root.getChildren().addAll(pane,menuPopUp);
				StackPane.setAlignment(menuPopUp, Pos.CENTER);
				isPopUp = true;

			}
		});
		setRoot(root);
	}

	public static CardCollectionsPane getCardCollectionPane() {
		return cardCollectionPane;
	}

	public static DiePane getDiePane() {
		return diePane;
	}

	public static PlayerStatusPane getPlayerStatusPane() {
		return playerStatusPane;
	}

	public static Label getTurnDisplay() {
		return turnDisplay;
	}

	public void switchToMainScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}