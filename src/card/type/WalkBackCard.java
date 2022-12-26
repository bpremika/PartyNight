package card.type;

import card.base.AttackCard;
import gui.PlayerPiece;
import logic.GameLogic;
import player.Player;

public class WalkBackCard extends AttackCard {

	int minusPosition;

	public WalkBackCard(String name, int minusPosition) {
		super(name);
		this.setMinusPosition(minusPosition);
	}

	public void changePosition() {
		getTargetPlayer().setPosition((getTargetPlayer().getPosition() - getMinusPosition()) % 68);
	}

	public int getMinusPosition() {
		return minusPosition;
	}

	public void setMinusPosition(int minusPosition) {
		this.minusPosition = minusPosition;
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		super.use();
		getTargetPlayer().setPosition((getTargetPlayer().getPosition() - minusPosition) % 68);
		GameLogic.playerPieces.get(getTargetPlayer().getPlayerID()).updatexPosition();
		GameLogic.playerPieces.get(getTargetPlayer().getPlayerID()).updateyPosition();
	}

}
