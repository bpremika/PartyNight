package card.type;

import card.base.ProtectedCard;
import player.Player;

public class MirrorCard extends ProtectedCard {

	public MirrorCard(Player currentPlayer, Player attacker) {
		super("MirrorCard", currentPlayer);
	}

}
