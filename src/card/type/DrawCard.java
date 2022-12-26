package card.type;

import card.base.BuffCard;
import logic.GameLogic;
import player.Player;

public class DrawCard extends BuffCard {

	public DrawCard(Player currentPlayer) {
		super("DrawCard", currentPlayer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		super.use();
		GameLogic.stockPile.drawCard(getCurrentPlayer());
		GameLogic.stockPile.drawCard(getCurrentPlayer());
	}

}
