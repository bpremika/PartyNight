package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sharedResource.ResourceLoader;

public class Main extends Application {
	public static AnimationTimer mainSong;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

		Scene scene = new Scene(root);
		scene.getStylesheets()
				.add("https://fonts.googleapis.com/css2?family=Baloo+2:wght@700&family=Concert+One&display=swap");
//		String icon_path = ClassLoader.getSystemResource("images/icon.png").toString();
//		Image icon = new Image(icon_path);


		primaryStage.setTitle("Party Night");

		ResourceLoader.loadResource();
		mainSong = new AnimationTimer() {
			public void handle(long now) {
				if (!ResourceLoader.mainmenu_music.isPlaying()) {
					ResourceLoader.mainmenu_music.play(0.5);
				}
			}
		};
		
		primaryStage.getIcons().add(ResourceLoader.logo);
		mainSong.start();
		
		primaryStage.setResizable(false);
		// primaryStage.setFullScreen(true);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
