package deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.GameScene;
import card.base.AttackCard;
import card.base.BuffCard;
import card.base.Card;
import card.base.NerfCard;
import card.base.ProtectedCard;
import card.type.DamageByDiceRolls;
import card.type.DrawCard;
import card.type.HealingCard;
import card.type.PointInhibitingCard;
import card.type.SwapPlaceCard;
import gui.AlertPopUp;
import gui.CardCollectionsPane;
import gui.WinnerPopUp;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GameLogic;
import player.Player;
import sharedResource.ResourceLoader;

public class Deck {
	private String name;
	private int deckSize;
	private ArrayList<Card> deckList;

	public Deck() {
		this.deckList = new ArrayList<>();
		this.deckSize = deckList.size();
		this.setName("");
	}

	public int insertCard(Card card) {
		this.deckList.add(card);
		this.deckSize++;
		return this.deckSize;
	}

	public Card removeCard(Card card) {
		deckList.remove(card);
		GameScene.getCardCollectionPane().updatePane();
		deckSize--;
		return card;
	}

	public Card drawCard(Player player) {
		Card card = this.getDeckList().get(0);
		System.out.println(GameLogic.stockPile.deckSize);
		this.removeCard(card);
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ResourceLoader.gotCard.play();
				AlertPopUp alert = new AlertPopUp(e -> {
					GameScene.root.getChildren().remove(GameScene.root.getChildren().size()-1);
				}, card);
				GameScene.root.getChildren().addAll(alert);
				if (card instanceof AttackCard) {
					if(card instanceof SwapPlaceCard) {
						((SwapPlaceCard) card).setCurrentPlayer(player);
					}
					player.getOnhandDeck().insertCard(card);
				} else if (card instanceof ProtectedCard) {
					((ProtectedCard) card).setCurrentPlayer(player);
					player.getOnhandDeck().insertCard(card);
				} else if (card instanceof DrawCard) {
					((DrawCard) card).setCurrentPlayer(player);
					card.use();
				} else if (card instanceof HealingCard) {
					((HealingCard)card).setCurrentPlayer(player);
					player.getOnhandDeck().insertCard(card);
				} else if (card instanceof NerfCard) {
					((NerfCard) card).setCurrentPlayer(player);
					card.use();
				}
			}
		});
		
		

		// TODO change state something

		return card;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeckSize() {
		return deckSize;
	}

	public void setDeckSize(int deckSize) {
		this.deckSize = deckSize;
	}

	public ArrayList<Card> getDeckList() {
		return deckList;
	}

	public void setDeckList(ArrayList<Card> deckList) {
		this.deckList = deckList;
	}

}
