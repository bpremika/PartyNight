package gui;

import java.util.Random;

import application.GameScene;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.Die;
import logic.GameLogic;
import logic.GameState;
import sharedResource.ResourceLoader;

public class DiePane extends VBox {
	private Die die;
	private ImageView die1;
	private ImageView die2;
	private ImageView rollBtn;
	private Random random = new Random();

	public DiePane() {
		die = new Die();
		setMaxWidth(100);
		setMaxHeight(100);
		HBox hbox = new HBox();
		die1 = new ImageView(new Image(ClassLoader.getSystemResource("images/dice1.png").toString()));
		die1.setFitWidth(50);
		die1.setFitHeight(50);
		die2 = new ImageView(new Image(ClassLoader.getSystemResource("images/dice2.png").toString()));
		die2.setFitWidth(50);
		die2.setFitHeight(50);
		rollBtn = new ImageView(ResourceLoader.rollBtn);
		rollBtn.setFitWidth(38);
		rollBtn.setFitHeight(28);
		rollBtn.setCursor(Cursor.HAND);
		rollBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				roll();
			}
		});
		rollBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rollBtn.setImage(ResourceLoader.rollBtn_hover);
			}
		});
		rollBtn.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rollBtn.setImage(ResourceLoader.rollBtn);
			}
		});
		hbox.getChildren().addAll(die1, die2);
		getChildren().addAll(hbox, rollBtn);
		setAlignment(Pos.CENTER);
		setSpacing(5);
	}

	public void roll() {
		rollBtn.setDisable(true);

		Thread t = new Thread(() -> {
			System.out.println("Thread running");
			try {
				if (!ResourceLoader.rollDice.isPlaying()) {
							ResourceLoader.rollDice.play();
					}
				for (int i = 0; i < 15; i++) {
					Image img1 = new Image(
							ClassLoader.getSystemResource("images/dice" + (random.nextInt(6) + 1) + ".png").toString());
					Image img2 = new Image(
							ClassLoader.getSystemResource("images/dice" + (random.nextInt(6) + 1) + ".png").toString());
					die1.setImage(img1);
					die2.setImage(img2);
					Thread.sleep(50);
				}
				GameLogic.totalDie = die.roll();
				System.out.println(GameLogic.totalDie);
				GameLogic.getInstance().getActivePlayer().DieAndWalk();
				Image img1 = new Image(
						ClassLoader.getSystemResource("images/dice" + die.getDieOneRoll() + ".png").toString());
				Image img2 = new Image(
						ClassLoader.getSystemResource("images/dice" + die.getDieTwoRoll() + ".png").toString());
				die1.setImage(img1);
				die2.setImage(img2);
				// this.setVisible(false);
				// rollBtn.setDisable(false);
				ResourceLoader.rollDice.stop();
				GameScene.getCardCollectionPane().updateEndTurnBtn();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		t.start();
	}

	public void updateRollBtn() {
		rollBtn.setDisable(false);
	}

}
