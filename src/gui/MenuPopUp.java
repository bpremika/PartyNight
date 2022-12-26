package gui;

import java.io.IOException;

import application.SceneController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import logic.GameLogic;
import sharedResource.ResourceLoader;

public class MenuPopUp extends VBox {
	private Button resume;
	private Button exitToMainMenu;
	private Button exitGame;

	public MenuPopUp(EventHandler<ActionEvent> e) {

		setBackground(new Background(
				new BackgroundImage(ResourceLoader.menuPopUp, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(222, 276, false, false, true, false))));
		setMaxWidth(222);
		setMaxHeight(276);
		resume = new Button("");
		resume.setPrefWidth(100);
		resume.setPrefHeight(50);
		resume.setCursor(Cursor.HAND);
		resume.setBackground(new Background(
				new BackgroundImage(ResourceLoader.resumeBtn, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(100, 50, false, false, true, false))));
		exitToMainMenu = new Button("");
		exitToMainMenu.setPrefWidth(100);
		exitToMainMenu.setPrefHeight(50);
		exitToMainMenu.setCursor(Cursor.HAND);
		exitToMainMenu.setBackground(new Background(new BackgroundImage(ResourceLoader.BacktoMainMenuBtn,
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(100, 50, false, false, true, false))));
		exitGame = new Button("");
		exitGame.setPrefWidth(100);
		exitGame.setPrefHeight(50);
		exitGame.setCursor(Cursor.HAND);
		exitGame.setBackground(new Background(
				new BackgroundImage(ResourceLoader.exitGameBtn, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(100, 50, false, false, true, false))));

		// handler
		resume.setOnAction(e);

		exitToMainMenu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					SceneController.getInstance().switchToMainScene(arg0);
					GameLogic.getInstance().newGame();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		exitGame.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					SceneController.getInstance().exitGame(arg0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		this.getChildren().addAll(resume, exitToMainMenu, exitGame);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(0);
		this.setPadding(new Insets(0, 0, 30, 0));
	}

}
