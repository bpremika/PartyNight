package card.base;

import player.Player;

public abstract class BuffCard extends Card {
	private Player currentPlayer;

	public BuffCard(String name, Player currentPlayer) {
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
