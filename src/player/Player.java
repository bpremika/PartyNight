package player;

import board.Board;
import board.ChanceLocation;
import board.Location;
import board.ScoresLocation;
import card.base.Receivable;
import card.base.Skippable;
import deck.Deck;
import gui.PlayerPiece;
import gui.PlayerStatusPane;
import logic.GameLogic;

public class Player implements Skippable, Receivable {
	private String name;
	private final int playerID;
	private int hp;
	private int scores;
	private boolean inJail;
	private boolean canRoll;
	private Deck onhandDeck;
	private int position;
	private boolean receivingState;
	private boolean skipState;;
	private PlayerPiece playerPiece;

	public Player(String name, int playerID) {
		super();
		this.playerID = playerID;
		this.setName(name);
		this.setHp(100);
		this.setScores(0);
		this.inJail = false;
		this.canRoll = false;
		this.setOnhandDeck(new Deck() {});
		this.setPosition(0);
		this.receivingState = true;
		this.skipState = false;
		playerPiece = new PlayerPiece(this);
		GameLogic.playerPieces.add(playerPiece);
	}

	public void DieAndWalk() {
		System.out.println("total Die: " + GameLogic.totalDie);
		setPosition((position + GameLogic.totalDie) % 68);
		System.out.println(getPosition());
		System.out.println("walk");
		
		playerPiece.updatexPosition();
		playerPiece.updateyPosition();
		if (getPosition()-GameLogic.totalDie <= 51 && getPosition() > 51) {
			this.setScores(scores + 300);
			PlayerStatusPane.getPlayerStatus(playerID).updatePlayerScore();
		}
		System.out.println("x: " + playerPiece.getxPosition() + " y: " + playerPiece.getyPosition());
		eventHandler(Board.getLocation(position));
		GameLogic.getInstance().updateState();
	}

	public int getPlayerID() {
		return playerID;
	}

	public void eventHandler(Location location) {
		if (location instanceof ScoresLocation) {
			if(GameLogic.getInstance().getActivePlayer().isReceiving()) {
				ScoresLocation scoreLocation = (ScoresLocation) location;
				this.setScores(scores + scoreLocation.getScore());
				PlayerStatusPane.getPlayerStatus(playerID).updatePlayerScore();
			}
		} else if (location instanceof ChanceLocation) {
			GameLogic.stockPile.drawCard(GameLogic.getInstance().getActivePlayer());
		}
	}

	@Override
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		if (hp > 100) {
			this.hp = 100;
		} else if (hp < 0)
			this.hp = 0;
		else {
			this.hp = hp;

		}
	}

	public int getScores() {
		return scores;
	}

	public void setScores(int scores) {
		if(scores<0)scores=0;
		this.scores = scores;
	}

	public Deck getOnhandDeck() {
		return onhandDeck;
	}

	public void setOnhandDeck(Deck onhandDeck) {
		this.onhandDeck = onhandDeck;
	}

	public boolean isInJail() {
		return inJail;
	}

	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	public boolean isCanRoll() {
		return canRoll;
	}

	public void setCanRoll(boolean canRoll) {
		this.canRoll = canRoll;
	}

	public void setSkipState(boolean skipState) {
		this.skipState = skipState;
	}

	@Override
	public boolean isSkipped() {
		// TODO Auto-generated method stub
		return skipState;
	}


	public void setReceivingState(boolean receivingState) {
		this.receivingState = receivingState;
	}

	@Override
	public boolean isReceiving() {
		// TODO Auto-generated method stub
		return receivingState;
	}

	
}
