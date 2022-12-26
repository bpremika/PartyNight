package card.type;

import card.base.AttackCard;
import logic.GameLogic;
import player.Player;

public class SwapPlaceCard extends AttackCard {

	private Player currentPlayer;

	public SwapPlaceCard(Player currentPlayer) {
		super("SwapPlaceCard");
		this.setCurrentPlayer(currentPlayer);
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		super.use();
		int temp = getCurrentPlayer().getPosition();
		getCurrentPlayer().setPosition(getTargetPlayer().getPosition());
		getTargetPlayer().setPosition(temp);
		GameLogic.playerPieces.get(getCurrentPlayer().getPlayerID()).updatexPosition();
		GameLogic.playerPieces.get(getCurrentPlayer().getPlayerID()).updateyPosition();
		GameLogic.playerPieces.get(getTargetPlayer().getPlayerID()).updatexPosition();
		GameLogic.playerPieces.get(getTargetPlayer().getPlayerID()).updateyPosition();
	}

}
