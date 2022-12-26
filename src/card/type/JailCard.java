package card.type;

import card.base.NerfCard;
import logic.GameLogic;
import player.Player;

public class JailCard extends NerfCard {

	public JailCard(Player currentPlayer) {
		super("JailCard", currentPlayer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		super.use();
		this.getCurrentPlayer().setPosition(68);
		this.getCurrentPlayer().setSkipState(true);
		GameLogic.playerPieces.get(getCurrentPlayer().getPlayerID()).updatexPosition();
		GameLogic.playerPieces.get(getCurrentPlayer().getPlayerID()).updateyPosition();
		System.out.println(this.getCurrentPlayer().getPosition());
		this.getCurrentPlayer().setInJail(true);
	}
}