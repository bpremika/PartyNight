package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sharedResource.ResourceLoader;

public class SceneController  {
	public static SceneController instance = null;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public static SceneController getInstance() {
		if (instance == null) {
			instance = new SceneController();
		}
		return instance;
	}

	public static void setInstance(SceneController instance) {
		SceneController.instance = instance;
	}

	public void exitGame(ActionEvent event) throws IOException {
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		ResourceLoader.buttonClicked.play();
		stage.close();
	}

	public void switchToLobbyScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("LobbyRoom.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		ResourceLoader.buttonClicked.play();
		stage.show();
	}
	
	public void switchToGameScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("GameScene.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		ResourceLoader.buttonClicked.play();
		stage.show();
	}

	public void switchToRule(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Rule.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		ResourceLoader.buttonClicked.play();
		stage.show();
	}


	public void switchToMainScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		if (!ResourceLoader.mainmenu_music.isPlaying()) {
			ResourceLoader.mainmenu_music.play();
			Main.mainSong.start();
		}
		
		if (ResourceLoader.themeSong_music.isPlaying()) {
			ResourceLoader.themeSong_music.stop();
			GameScene.startSceneSong.stop();
		}
		if (ResourceLoader.gameWin.isPlaying()) {
			ResourceLoader.gameWin.stop();
		}
		ResourceLoader.buttonClicked.play();
	}
	
	public void switchToMainScene2(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		if (!ResourceLoader.mainmenu_music.isPlaying()) {
			ResourceLoader.mainmenu_music.play();
			Main.mainSong.start();
		}
		
		if (ResourceLoader.themeSong_music.isPlaying()) {
			ResourceLoader.themeSong_music.stop();
			GameScene.startSceneSong.stop();
		}
		if (ResourceLoader.gameWin.isPlaying()) {
			ResourceLoader.gameWin.stop();
		}
		ResourceLoader.buttonClicked.play();
	}

	
}
