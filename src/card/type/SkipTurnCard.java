package card.type;

import card.base.AttackCard;
import player.Player;

public class SkipTurnCard extends AttackCard {

	public SkipTurnCard() {
		super("SkipTurnCard");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		super.use();
		this.getTargetPlayer().setSkipState(true);
	}
}
