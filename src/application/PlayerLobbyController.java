package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import gui.PlayerPiece;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.GameLogic;
import player.Player;
import sharedResource.ResourceLoader;

public class PlayerLobbyController implements Initializable {
	// private ArrayList<Player> players = new ArrayList<Player>();
	private int currentSubmitted;

	private Stage stage;
	private Scene scene;
	private Parent root;
	private GameScene gameScene;
	private Player player;
	// private PlayerSprike playerSprike;

	@FXML
	private Label playerIndex;
	@FXML
	private TextField playerName;
	@FXML
	private ImageView confirm;
	@FXML
	private ImageView backBtn;
	String name;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		GameLogic.getInstance().newGame();
		playerIndex.setStyle("-fx-font-family: 'Baloo 2', cursive; -fx-font-size: 48");
		playerName.setText("");
		playerName.setPromptText("Enter your name");
		playerIndex.setText("Player " + (currentSubmitted + 1));
		this.setCurrentSubmitted(currentSubmitted);
		System.out.println(GameLogic.numberOfPlayers);
		backBtn.setImage(ResourceLoader.backBtn);
		confirm.setImage(ResourceLoader.confirmBtn);
		backBtn.setCursor(Cursor.HAND);
		confirm.setCursor(Cursor.HAND);
	}

	public Label getPlayerIndex() {
		return playerIndex;
	}

	public void setPlayerIndex(Label playerIndex) {
		this.playerIndex = playerIndex;
	}

	public void confirm(MouseEvent event) {
		if (currentSubmitted != GameLogic.numberOfPlayers - 1) {
			ResourceLoader.buttonClicked.play();
			name = playerName.getText();
			System.out.println(name);
			// players.add(new Player(name));
			player = new Player(name, currentSubmitted);
			GameLogic.players.add(player);
			playerName.setText("");
			playerName.setPromptText("Enter your name");
			this.setCurrentSubmitted(currentSubmitted + 1);
			playerIndex.setText("Player " + (currentSubmitted + 1));
			System.out.println(currentSubmitted);
		} else {
			name = playerName.getText();
			// confirm.setText("start game");
			System.out.println(name);
			// players.add(new Player(name));
			player = new Player(name, currentSubmitted);
			GameLogic.players.add(player);
			try {
				switchToGameScene(event);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public void switchToMainScene(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		ResourceLoader.buttonClicked.play();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void switchToGameScene(MouseEvent event) throws IOException {
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		gameScene = new GameScene();
		ResourceLoader.buttonClicked.play();
		stage.setScene(gameScene);
		stage.show();
	}

	public int getCurrentSubmitted() {
		return currentSubmitted;
	}

	public void setCurrentSubmitted(int currentSubmitted) {
		this.currentSubmitted = currentSubmitted;
	}

}
