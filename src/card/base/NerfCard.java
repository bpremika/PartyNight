package card.base;

import player.Player;

public abstract class NerfCard extends Card {
	private Player currentPlayer;

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public NerfCard(String name, Player currentPlayer) {
		super(name);
		this.setCurrentPlayer(currentPlayer);
	}

}
