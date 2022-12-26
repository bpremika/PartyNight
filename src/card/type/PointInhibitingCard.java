package card.type;

import card.base.NerfCard;
import player.Player;

public class PointInhibitingCard extends NerfCard {

	public PointInhibitingCard(Player currentPlayer) {
		super("PointInhibitingCard", currentPlayer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		super.use();
		this.getCurrentPlayer().setReceivingState(false);
	}

}
