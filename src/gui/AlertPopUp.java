package gui;

import card.base.Card;
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
import sharedResource.ResourceLoader;

public class AlertPopUp extends VBox {
	private Card card;
	private Label cardName;
	private Button confirm;

	public AlertPopUp(EventHandler<ActionEvent> e,Card card) {
		setBackground(new Background(
				new BackgroundImage(ResourceLoader.alertPopUp, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(346, 224, false, false, true, false))));
		setMaxWidth(346);
		setMaxHeight(224);
		cardName = new Label("You have recieved " + card.getName() + "");
		cardName.setStyle("-fx-font-family: 'Concert One', cursive; -fx-font-size: 20 ;-fx-text-fill: #FFFFFF;");
//		score = new Label("Scores : " + GameLogic.getInstance().getActivePlayer().getScores());
//		score.setStyle("-fx-font-family: 'Concert One', cursive; -fx-font-size: 36 ;-fx-text-fill: #C65515;");
		confirm = new Button("");
		confirm.setPrefWidth(100);
		confirm.setPrefHeight(50);
		confirm.setCursor(Cursor.HAND);
		confirm.setBackground(new Background(
				new BackgroundImage(ResourceLoader.confirmBtn, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(100, 50, false, false, true, false))));
		confirm.setOnMouseEntered(new EventHandler<Event>() {
			
			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				confirm.setBackground(new Background(
						new BackgroundImage(ResourceLoader.confirmBtn, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
								BackgroundPosition.CENTER, new BackgroundSize(100, 50, false, false, true, false))));
			}
		});
		confirm.setOnMouseExited(new EventHandler<Event>() {
			
			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				confirm.setBackground(new Background(
						new BackgroundImage(ResourceLoader.confirmBtn, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
								BackgroundPosition.CENTER, new BackgroundSize(100, 50, false, false, true, false))));
			}
		});
		confirm.setOnAction(e);

		getChildren().addAll(cardName,confirm);
		setSpacing(5);
		setPadding(new Insets(70, 0, 25, 0));
		setAlignment(Pos.CENTER);
	}

}
