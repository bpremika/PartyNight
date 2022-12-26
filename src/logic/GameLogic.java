package logic;

import java.util.ArrayList;
import java.util.Random;

import application.GameScene;
import card.type.AngelCard;
import card.type.Bandage;
import card.type.Bomb;
import card.type.DamageByDiceRolls;
import card.type.DrawCard;
import card.type.FirstAidKit;
import card.type.JailCard;
import card.type.MirrorCard;
import card.type.Missile;
import card.type.OneBlock;
import card.type.PointInhibitingCard;
import card.type.Punch;
import card.type.SkipTurnCard;
import card.type.SwapPlaceCard;
import card.type.ThreeBlocks;
import card.type.TwoBlocks;
import deck.Deck;
import gui.PlayerPiece;
import gui.PlayerStatusPane;
import gui.WinnerPopUp;
import javafx.application.Platform;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import player.Player;
import sharedResource.ResourceLoader;

public class GameLogic {
	private static GameLogic instance = null;
	private boolean isGameEnd;
	public static int totalDie;
	public static int numberOfPlayers;
	public static ArrayList<Player> players = new ArrayList<Player>();
	public static ArrayList<PlayerPiece> playerPieces = new ArrayList<PlayerPiece>();
	public static int playerTurn;
	private static GameState state;
	private Pane pane;
	public static Deck stockPile = new Deck();
	private WinnerPopUp winnerPopUp;

	public void newGame() {
		state = GameState.START;
		players.clear();
		playerPieces.clear();
		PlayerStatusPane.playerStatusList.clear();
		playerTurn = 0;
		this.setGameEnd(false);
		initializeStockPile();

	}

	public static void initializeStockPile() {
		Random rd = new Random();
		stockPile.insertCard(new DrawCard(null));
		for (int i = 0; i < 500; i++) {
			int num = rd.nextInt(16);
//			int num = 13;
			
			switch (num) {
			case 0:
				stockPile.insertCard(new SkipTurnCard());
				break;
			case 1:
				stockPile.insertCard(new Bomb());
				break;
			case 2:
				stockPile.insertCard(new Punch());
				break;
			case 3:
				stockPile.insertCard(new Missile());
				break;
			case 4:
				stockPile.insertCard(new ThreeBlocks());
				break;
			case 5:
				stockPile.insertCard(new TwoBlocks());
				break;
			case 6:
				stockPile.insertCard(new OneBlock());
				break;
			case 7:
				stockPile.insertCard(new SwapPlaceCard(null));
				break;
			case 8:
				stockPile.insertCard(new AngelCard(null));
				break;
			case 9:
				stockPile.insertCard(new MirrorCard(null, null));
				break;
			case 10:
				stockPile.insertCard(new PointInhibitingCard(null));
				break;
			case 11:
				stockPile.insertCard(new Bandage(null));
				break;
			case 12:
				stockPile.insertCard(new DamageByDiceRolls(null));
				break;
			case 13:
				stockPile.insertCard(new JailCard(null));
				break;
			case 14:
				stockPile.insertCard(new DrawCard(null));
				break;
			case 15:
				stockPile.insertCard(new FirstAidKit(null));
				break;
			}
		}
		stockPile.insertCard(new SkipTurnCard());
	}

	public static GameLogic getInstance() {
		if (instance == null) {
			instance = new GameLogic();
		}
		return instance;
	}

	public Player getActivePlayer() {
		return players.get(playerTurn);
	}

	public static void setInstance(GameLogic instance) {
		GameLogic.instance = instance;
	}

	public boolean isGameEnd() {
		return isGameEnd;
	}

	public void setGameEnd(boolean isGameEnd) {
		this.isGameEnd = isGameEnd;
	}

	public void updateState() {
		checkGameEnd();
		if (isGameEnd) {
			winnerPopUp = new WinnerPopUp();
			Platform.runLater(() -> {
				pane = new Pane();
				pane.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
				GameScene.root.getChildren().addAll(pane,winnerPopUp);
				ResourceLoader.gameWin.play();
			});
		}
		System.out.println(getActivePlayer().isSkipped());

			switch (state) {
		case START:
			if(!getActivePlayer().isReceiving()) {
				getActivePlayer().setReceivingState(true);
			}
			state = GameState.END;
			System.out.println(state);
			break;
		case END:
			state = GameState.START;
			playerTurn = (playerTurn + 1) % numberOfPlayers;
			if(getActivePlayer().isSkipped()) {
				getActivePlayer().setSkipState(false);
				playerTurn = (playerTurn + 1) % numberOfPlayers;
			}
			Platform.runLater(() -> {
				GameScene.getTurnDisplay().setText(getActivePlayer().getName() + "'s Turn");
			});
			System.out.println(playerTurn);
			System.out.println(state);
			GameScene.getDiePane().updateRollBtn();
		default:
		}
	}

	public static GameState getState() {
		return state;
	}

	public void checkGameEnd() {
		if (players.get(playerTurn).getScores() >= 2400) {
			setGameEnd(true);
		}

	}
}