package gui;

import java.io.IOException;

import application.SceneController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import logic.GameLogic;
import sharedResource.ResourceLoader;

public class WinnerPopUp extends VBox {
	private Label winnerName;
	private Label score;
	private Button backToMainMenu;

	public WinnerPopUp() {
		setBackground(new Background(
				new BackgroundImage(ResourceLoader.winnerPopUp, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(346, 224, false, false, true, false))));
		setMaxWidth(346);
		setMaxHeight(224);
		winnerName = new Label(GameLogic.getInstance().getActivePlayer().getName() + " Win");
		winnerName.setStyle("-fx-font-family: 'Concert One', cursive; -fx-font-size: 25 ;-fx-text-fill: #C65515;");
		score = new Label("Scores : " + GameLogic.getInstance().getActivePlayer().getScores());
		score.setStyle("-fx-font-family: 'Concert One', cursive; -fx-font-size: 36 ;-fx-text-fill: #C65515;");
		backToMainMenu = new Button("");
		backToMainMenu.setPrefWidth(100);
		backToMainMenu.setPrefHeight(50);
		backToMainMenu.setCursor(Cursor.HAND);
		backToMainMenu.setBackground(new Background(
				new BackgroundImage(ResourceLoader.homeBtn, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(100, 50, false, false, true, false))));
		backToMainMenu.setOnMouseEntered(new EventHandler<Event>() {
			
			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				backToMainMenu.setBackground(new Background(
						new BackgroundImage(ResourceLoader.homeBtn_hover, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
								BackgroundPosition.CENTER, new BackgroundSize(100, 50, false, false, true, false))));
			}
		});
		backToMainMenu.setOnMouseExited(new EventHandler<Event>() {
			
			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				backToMainMenu.setBackground(new Background(
						new BackgroundImage(ResourceLoader.homeBtn, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
								BackgroundPosition.CENTER, new BackgroundSize(100, 50, false, false, true, false))));
			}
		});
		backToMainMenu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					SceneController.getInstance().switchToMainScene(arg0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		getChildren().addAll(winnerName, score, backToMainMenu);
		setSpacing(5);
		setPadding(new Insets(70, 0, 25, 0));
		setAlignment(Pos.CENTER);
	}

}
