package gui;

import java.util.ArrayList;

import javafx.scene.layout.VBox;
import logic.GameLogic;

public class PlayerStatusPane extends VBox {
	public static ArrayList<PlayerStatus> playerStatusList = new ArrayList<PlayerStatus>();
	private PlayerStatus playerStatus;

	public PlayerStatusPane() {
		setMaxWidth(400);
		for (var player : GameLogic.players) {
			System.out.println(player.getName());
			playerStatus = new PlayerStatus(player);
			playerStatusList.add(playerStatus);
			this.getChildren().add(playerStatus);
		}

	}

	public static PlayerStatus getPlayerStatus(int playerID) {
		return playerStatusList.get(playerID);
	}

}
