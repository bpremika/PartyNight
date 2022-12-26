package card.type;

import card.base.NerfCard;
import gui.PlayerStatusPane;
import logic.GameLogic;
import player.Player;

public class DamageByDiceRolls extends NerfCard {
	private int diceRolls;

	public DamageByDiceRolls(Player currentPlayer) {
		super("DamageByDiceRolls", currentPlayer);
	}

	public int getDiceRolls() {
		return diceRolls;
	}

	public void setDiceRolls(int diceRolls) {
		this.diceRolls = diceRolls;
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		super.use();
		getCurrentPlayer().setHp(getCurrentPlayer().getHp() - GameLogic.getInstance().totalDie);
		PlayerStatusPane.getPlayerStatus(getCurrentPlayer().getPlayerID()).updateHealth();
		if(getCurrentPlayer().getHp()==0) {
			getCurrentPlayer().setPosition(0);
			GameLogic.playerPieces.get(getCurrentPlayer().getPlayerID()).updatexPosition();
			GameLogic.playerPieces.get(getCurrentPlayer().getPlayerID()).updateyPosition();
			getCurrentPlayer().setHp(100);
			PlayerStatusPane.getPlayerStatus(getCurrentPlayer().getPlayerID()).updateHealth();
			getCurrentPlayer().setScores(getCurrentPlayer().getScores()-200);
			PlayerStatusPane.getPlayerStatus(getCurrentPlayer().getPlayerID()).updatePlayerScore();
		}
	}

}
