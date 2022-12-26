package card.base;

import player.Player;

public abstract class AttackCard extends Card {
	private Player targetPlayer;

	public AttackCard(String name) {
		super(name);
		this.setTargetPlayer(null); // TODO set this to null at first
	}

	public Player getTargetPlayer() {
		return targetPlayer;
	}

	public void setTargetPlayer(Player targetPlayer) {
		this.targetPlayer = targetPlayer;
	}

}
