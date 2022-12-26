package card.type;

import card.base.BuffCard;
import gui.PlayerStatus;
import gui.PlayerStatusPane;
import player.Player;

public class HealingCard extends BuffCard {
	int addHp;

	public HealingCard(String name, Player currentPlayer, int addHp) {
		super(name, currentPlayer);
		this.setAddHp(addHp);
		;
	}

	public int getAddHp() {
		return addHp;
	}

	public void setAddHp(int addHp) {
		this.addHp = addHp;
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		super.use();
		this.getCurrentPlayer().setHp(getCurrentPlayer().getHp() + getAddHp());
		PlayerStatusPane.getPlayerStatus(getCurrentPlayer().getPlayerID()).updateHealth();
	}

}
