package card.base;

import player.Player;

public abstract class ProtectedCard extends Card {

	private Player currentPlayer;

	public ProtectedCard(String name, Player currentPlayer) {
		super(name);
		this.setCurrentPlayer(currentPlayer);
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
}
