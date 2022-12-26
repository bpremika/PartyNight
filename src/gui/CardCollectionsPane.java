package gui;

import java.util.ArrayList;

import card.base.AttackCard;
import card.base.BuffCard;
import card.base.Card;
import card.type.AngelCard;
import card.type.Bandage;
import card.type.Bomb;
import card.type.DamageByDiceRolls;
import card.type.DrawCard;
import card.type.FirstAidKit;
import card.type.JailCard;
import card.type.MirrorCard;
import card.type.Missile;
import card.type.OneBlock;
import card.type.PointInhibitingCard;
import card.type.Punch;
import card.type.SkipTurnCard;
import card.type.SwapPlaceCard;
import card.type.ThreeBlocks;
import card.type.TwoBlocks;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import logic.GameLogic;
import player.Player;
import sharedResource.ResourceLoader;

public class CardCollectionsPane extends VBox {
	private ImageView endTurnBtn;
	private ScrollPane cardCollection;
	private VBox image;

	public CardCollectionsPane() {
		// TODO Auto-generated constructor stub
		image = new VBox();
		setMaxWidth(150);
		cardCollection = new ScrollPane();
		cardCollection.setPrefHeight(450);
		cardCollection.setFitToHeight(true);
		cardCollection.setFitToWidth(true);
		cardCollection.setBackground(new Background(new BackgroundFill(Color.web("0C2149"), null, null)));
		image.setBackground(new Background(new BackgroundFill(Color.web("0C2149"), null, null)));
		image.setAlignment(Pos.CENTER);
		image.setSpacing(10);
		GameLogic.getInstance().getActivePlayer().getOnhandDeck().getDeckList()
				.add(new Bandage(GameLogic.getInstance().getActivePlayer()));
		GameLogic.getInstance().getActivePlayer().getOnhandDeck().getDeckList()
				.add(new AngelCard(GameLogic.getInstance().getActivePlayer()));
		// GameLogic.getInstance().getActivePlayer().getOnhandDeck().getDeckList().add(new
		// PointInhibitingCard(GameLogic.getInstance().getActivePlayer()));
//		GameLogic.getInstance().getActivePlayer().getOnhandDeck().getDeckList().add(new SwapPlaceCard(GameLogic.getInstance().getActivePlayer()));
		GameLogic.getInstance().getActivePlayer().getOnhandDeck().getDeckList().add(new Missile());
		GameLogic.getInstance().getActivePlayer().getOnhandDeck().getDeckList().add(new TwoBlocks());
		GameLogic.getInstance().getActivePlayer().getOnhandDeck().getDeckList().add(new Punch());
		System.out.println(GameLogic.getInstance().getActivePlayer().getOnhandDeck().getDeckList());

		updatePane();
		endTurnBtn = new ImageView(ResourceLoader.endTurnBtn);
		endTurnBtn.setDisable(true);
		endTurnBtn.setFitWidth(100.52);
		endTurnBtn.setFitHeight(42.95);
		endTurnBtn.setCursor(Cursor.HAND);
		endTurnBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				endTurnButtonHandler();
			}
		});
		endTurnBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				endTurnBtn.setImage(ResourceLoader.endTurn_hover);
			}
		});
		endTurnBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				endTurnBtn.setImage(ResourceLoader.endTurnBtn);
			}
		});
		cardCollection.setPrefWidth(50);
		setStyle("-fx-background-color: #0C2149;");
		getChildren().addAll(cardCollection, endTurnBtn);
		setSpacing(5);
		setAlignment(Pos.CENTER);

	}

	public void updatePane() {
		Player player = GameLogic.getInstance().getActivePlayer();
		ArrayList<ImageView> temp = new ArrayList<>();

		for (Card card : player.getOnhandDeck().getDeckList()) {
			System.out.println(card);
			if (player.getOnhandDeck() == null) {
				System.out.println("Please Draw Card");
			} else {
				System.out.println(card.getName());

				ImageView images = new ImageView();
				images.setFitWidth(102.7);
				images.setFitHeight(158.7);

				if (card instanceof SkipTurnCard)
					images.setImage(ResourceLoader.skipTurnCard);
				else if (card instanceof Bomb)
					images.setImage(ResourceLoader.bomb);
				else if (card instanceof Punch)
					images.setImage(ResourceLoader.punch);
				else if (card instanceof Missile)
					images.setImage(ResourceLoader.missile);
				else if (card instanceof ThreeBlocks)
					images.setImage(ResourceLoader.threeBlocks);
				else if (card instanceof TwoBlocks)
					images.setImage(ResourceLoader.twoBlocks);
				else if (card instanceof OneBlock)
					images.setImage(ResourceLoader.oneBlocks);
				else if (card instanceof SwapPlaceCard)
					images.setImage(ResourceLoader.swapPlaceCard);
				else if (card instanceof AngelCard)
					images.setImage(ResourceLoader.angelCard);
				else if (card instanceof MirrorCard)
					images.setImage(ResourceLoader.mirrorCard);
				else if (card instanceof PointInhibitingCard)
					images.setImage(ResourceLoader.pointInhibitingCard);
				else if (card instanceof DamageByDiceRolls)
					images.setImage(ResourceLoader.damageByDiceRolls);
				else if (card instanceof JailCard)
					images.setImage(ResourceLoader.jailCard);
				else if (card instanceof DrawCard)
					images.setImage(ResourceLoader.drawCard);
				else if (card instanceof FirstAidKit)
					images.setImage(ResourceLoader.firstAidKit);
				else if (card instanceof Bandage)
					images.setImage(ResourceLoader.bandage);

				images.setOnMouseEntered(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent arg0) {
						// TODO Auto-generated method stub
						image.setCursor(Cursor.HAND);
					}
				});
				if (card instanceof AttackCard) {
					AttackCard atCard = (AttackCard) card;
					images.setOnMouseEntered(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent arg0) {
							// TODO Auto-generated method stub
							image.setCursor(Cursor.HAND);
						}
					});

					images.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent arg0) {
							// TODO check for protectedcard
							ResourceLoader.useCard.play();
							ButtonType selectTarget = new ButtonType("Select Target", ButtonData.OK_DONE);
							Dialog<Player> dialog = new Dialog<>();
							dialog.setTitle("Select Target");
							dialog.setHeight(224);
							dialog.setWidth(224);
							dialog.getDialogPane().setStyle("-fx-background-color: #FFD231;");
							StackPane pane = new StackPane();
							Text text = new Text("Select target player to attack!!");
							text.setStyle("-fx-font-family: 'Concert One', cursive; -fx-font-size: 20 ;-fx-text-fill: #FFFFFF;");
							pane.setAlignment(Pos.TOP_CENTER);			
							pane.setPrefSize(224,224);
							pane.setPadding(new Insets(20));
							pane.setStyle("-fx-background-color: #FFD231;");
							ChoiceBox<Player> cb = new ChoiceBox<Player>();
							for (Player player : GameLogic.players) {
								if (player != GameLogic.getInstance().getActivePlayer()) {
									cb.getItems().add(player);
								}
							}
							pane.setMargin(cb, new Insets(40));
							pane.getChildren().add(cb);
							pane.getChildren().add(text);
							dialog.getDialogPane().setContent(pane);
							dialog.getDialogPane().getButtonTypes().add(selectTarget);
							boolean disabled = false; // computed based on content of text fields, for example
							dialog.getDialogPane().lookupButton(selectTarget).setDisable(disabled);
							dialog.showAndWait();
							atCard.setTargetPlayer(cb.getValue());
							if (cb.getValue() == null)
								return;

							boolean hasAngelCard = false;
							for (Card temp : atCard.getTargetPlayer().getOnhandDeck().getDeckList()) {
								if (temp instanceof MirrorCard) {
									atCard.getTargetPlayer().getOnhandDeck().removeCard(temp);
									atCard.setTargetPlayer(GameLogic.getInstance().getActivePlayer());
									player.getOnhandDeck().removeCard(card);
									Alert alert = new Alert(AlertType.INFORMATION, "Attack Failed!!! TargetPlayer has MirrorCard! ");
									alert.showAndWait();
									break;
								} else if (temp instanceof AngelCard) {
									atCard.getTargetPlayer().getOnhandDeck().removeCard(temp);
									hasAngelCard = true;
									player.getOnhandDeck().removeCard(card);
									Alert alert = new Alert(AlertType.INFORMATION, "TargetPlayer has AngelCard! ");
									alert.setHeaderText("Attack Failed!!!");
									alert.showAndWait();
									break;
								}
							}
							if (!hasAngelCard) {
								card.use();
								ResourceLoader.bombSound.play();
								player.getOnhandDeck().removeCard(card);
							}
						}
					});
				}

				else if (card instanceof BuffCard) {
					images.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent arg0) {
							// TODO Auto-generated method stub
							card.use();
							ResourceLoader.healSound.play();
							player.getOnhandDeck().removeCard(card);
						}
					});
				}

				temp.add(images);
			}
			;
		}
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				image.getChildren().setAll(temp);
			}
		});
		cardCollection.setMaxHeight(500);
		cardCollection.setContent(image);
	}

	public void endTurnButtonHandler() {
		GameLogic.getInstance().updateState();
		System.out.println(GameLogic.getInstance().getActivePlayer());
		updatePane();
		endTurnBtn.setDisable(true);
		if(!ResourceLoader.endTurn.isPlaying()) {
			ResourceLoader.endTurn.play();
			ResourceLoader.endTurn.setCycleCount(1);
			}
		}

	public void updateEndTurnBtn() {
//		Platform.runLater(()->{
//			CardImageRes.endTurn.stop();
//			endTurnSound.stop();
//		});
		endTurnBtn.setDisable(false);
	}
}
