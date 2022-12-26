package card.type;

import card.base.AttackCard;
import gui.PlayerStatusPane;
import logic.GameLogic;
import player.Player;

public class DamageCard extends AttackCard {

	private int damage;

	public DamageCard(String name, int damage) {
		super(name);
		this.setDamage(damage);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		super.use();
		getTargetPlayer().setHp(getTargetPlayer().getHp() - damage);
		PlayerStatusPane.getPlayerStatus(getTargetPlayer().getPlayerID()).updateHealth();
		if(getTargetPlayer().getHp()==0) {
			getTargetPlayer().setPosition(0);
			GameLogic.playerPieces.get(getTargetPlayer().getPlayerID()).updatexPosition();
			GameLogic.playerPieces.get(getTargetPlayer().getPlayerID()).updateyPosition();
			getTargetPlayer().setHp(100);
			PlayerStatusPane.getPlayerStatus(getTargetPlayer().getPlayerID()).updateHealth();
			getTargetPlayer().setScores(getTargetPlayer().getScores()-200);
			PlayerStatusPane.getPlayerStatus(getTargetPlayer().getPlayerID()).updatePlayerScore();
		}
	}
}
