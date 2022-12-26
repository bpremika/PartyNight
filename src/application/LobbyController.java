package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.GameLogic;
import sharedResource.ResourceLoader;

public class LobbyController implements Initializable {
	private Stage stage;
	private Scene scene;
	private Parent root;

	private int numberOfPlayers;
	@FXML
	private ImageView lobbyTitle;
	@FXML
	private Label numberOfPlayer;
	@FXML
	private ImageView backBtn;
	@FXML
	private ImageView goBtn;
	@FXML
	private ImageView leftImage;
	@FXML
	private ChoiceBox<String> numberChoice;

	private String[] numberList = { "2", "3", "4", "5", "6" };

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		numberChoice.getItems().addAll(numberList);
		numberChoice.setOnAction(this::getNumber);
		numberOfPlayer.setStyle("-fx-font-family: 'Baloo 2', cursive; -fx-font-size: 18");
		lobbyTitle .setImage(ResourceLoader.lobbyTitle);
		goBtn.setImage(ResourceLoader.goBtn);
		backBtn.setImage(ResourceLoader.backBtn);
		goBtn.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				goBtn.setImage(ResourceLoader.goBtn);
			}
			
		});
		
		leftImage.setImage(ResourceLoader.character);
	}

	public void getNumber(ActionEvent event) {
		this.numberOfPlayers = Integer.parseInt(numberChoice.getValue());
		System.out.println(this.numberOfPlayers);
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	
	public void switchToPlayerLobby(MouseEvent event) throws IOException {
		GameLogic.numberOfPlayers = numberOfPlayers;
		root = FXMLLoader.load(getClass().getResource("PlayerLobby.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		ResourceLoader.buttonClicked.play();
		stage.show();
	}
	
	public void switchToMainScene(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		ResourceLoader.buttonClicked.play();
		stage.show();
	}

}
