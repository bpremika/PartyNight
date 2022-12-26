package sharedResource;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

public class ResourceLoader {
	public static Image skipTurnCard;
	public static Image bomb;
	public static Image punch;
	public static Image missile;
	public static Image threeBlocks;
	public static Image twoBlocks;
	public static Image oneBlocks;
	public static Image swapPlaceCard;

	public static Image angelCard;
	public static Image mirrorCard;

	public static Image pointInhibitingCard;
	public static Image blockingEffectCard;
	public static Image damageByDiceRolls;
	public static Image jailCard;

	public static Image drawCard;
	public static Image firstAidKit;
	public static Image bandage;

	// location Image
	public static Image start;
	public static Image plus10;
	public static Image plus20;
	public static Image plus50;
	public static Image plus100;
	public static Image plus500;
	public static Image jail;
	public static Image chance;
	
	//logo
	public static Image logo;
	public static Image gametitle;
	public static Image lobbyTitle;
	// popup Image
	public static Image menuPopUp;
	public static Image winnerPopUp;
	public static Image resumeBtn;
	public static Image BacktoMainMenuBtn;
	public static Image exitGameBtn;
	public static Image homeBtn;
	public static Image backBtn;
	public static Image goBtn;
	public static Image confirmBtn;
	public static Image endTurnBtn;
	public static Image rollBtn;
	public static Image endTurn_hover;
	public static Image rollBtn_hover;
	public static Image homeBtn_hover;
	public static Image alertPopUp;
	public static Image selectTargetPopUp;
	
	//Charater
	public static Image character;
	public static Image duckboii;
	public static Image dino;
	public static Image captain;
	public static Image mrCat;
	public static Image penguin;
	public static Image pilot;
	public static Image duckboii_profile;
	public static Image dino_profile;
	public static Image captain_profile;
	public static Image mrCat_profile;
	public static Image penguin_profile;
	public static Image pilot_profile;
	
	// Audio
	public static AudioClip themeSong_music;
	public static AudioClip mainmenu_music;
	public static AudioClip rollDice;
	public static AudioClip endTurn;
	public static AudioClip buttonClicked;
	public static AudioClip gameWin;
	public static AudioClip gotCard;
	public static AudioClip useCard;
	public static AudioClip bombSound;
	public static AudioClip healSound;
	
	public static void loadResource() {
		String Image = "images/";
		// ImageView image = new
		// ImageView(ClassLoader.getSystemResource("images/SkipTurn.png").toString());
		skipTurnCard = new Image(ClassLoader.getSystemResource("images/SkipTurn.png").toString());
		bomb = new Image(ClassLoader.getSystemResource("images/Bomb.png").toString());
		punch = new Image(ClassLoader.getSystemResource("images/Punch.png").toString());
		missile = new Image(ClassLoader.getSystemResource("images/Missile.png").toString());
		threeBlocks = new Image(ClassLoader.getSystemResource("images/Back3.png").toString());
		twoBlocks = new Image(ClassLoader.getSystemResource("images/Back2.png").toString());
		oneBlocks = new Image(ClassLoader.getSystemResource("images/Back1.png").toString());
		swapPlaceCard = new Image(ClassLoader.getSystemResource("images/Swap.png").toString());
		angelCard = new Image(ClassLoader.getSystemResource("images/Angel.png").toString());
		mirrorCard = new Image(ClassLoader.getSystemResource("images/Mirror.png").toString());
		pointInhibitingCard = new Image(ClassLoader.getSystemResource("images/NoPoint.png").toString());
		blockingEffectCard = new Image(ClassLoader.getSystemResource("images/Block.png").toString());
		damageByDiceRolls = new Image(ClassLoader.getSystemResource("images/Damage.png").toString());
		jailCard = new Image(ClassLoader.getSystemResource("images/JailCard.png").toString());
		drawCard = new Image(ClassLoader.getSystemResource("images/DoubleRoll.png").toString());
		firstAidKit = new Image(ClassLoader.getSystemResource("images/FirstAidKit.png").toString());
		bandage = new Image(ClassLoader.getSystemResource("images/Bandage.png").toString());
		
		//logo
		logo = new Image(ClassLoader.getSystemResource("images/Logo.png").toString());
		gametitle = new Image(ClassLoader.getSystemResource("images/gamename.png").toString());
		lobbyTitle = new Image(ClassLoader.getSystemResource("images/Lobby.png").toString());
		
		// popup Image
		menuPopUp = new Image(ClassLoader.getSystemResource("images/menu.png").toString());
		winnerPopUp = new Image(ClassLoader.getSystemResource("images/winpopup.png").toString());
		resumeBtn = new Image(ClassLoader.getSystemResource("images/resume.png").toString());
		BacktoMainMenuBtn = new Image(ClassLoader.getSystemResource("images/backToMainMenu.png").toString());
		exitGameBtn = new Image(ClassLoader.getSystemResource("images/exitGame.png").toString());
		homeBtn = new Image(ClassLoader.getSystemResource("images/homeBtn.png").toString());
		backBtn = new Image(ClassLoader.getSystemResource("images/backBtn.png").toString());
		goBtn = new Image(ClassLoader.getSystemResource("images/Let'sGo.png").toString());
		confirmBtn = new Image(ClassLoader.getSystemResource("images/Confirm.png").toString());
		endTurnBtn = new Image(ClassLoader.getSystemResource("images/EndTurn.png").toString());
		rollBtn = new Image(ClassLoader.getSystemResource("images/Roll.png").toString());
		endTurn_hover = new Image(ClassLoader.getSystemResource("images/EndTurn_hover.png").toString());
		rollBtn_hover = new Image(ClassLoader.getSystemResource("images/Roll_hover.png").toString());
		homeBtn_hover = new Image(ClassLoader.getSystemResource("images/homeBtn_hover.png").toString());
		alertPopUp = new Image(ClassLoader.getSystemResource("images/AlertBox.png").toString());
		selectTargetPopUp = new Image(ClassLoader.getSystemResource("images/selectBox.png").toString());

		// location Image
		start = new Image(ClassLoader.getSystemResource("images/start.png").toString());
		plus10 = new Image(ClassLoader.getSystemResource("images/plus10.png").toString());
		plus20 = new Image(ClassLoader.getSystemResource("images/plus20.png").toString());
		plus50 = new Image(ClassLoader.getSystemResource("images/plus50.png").toString());
		plus100 = new Image(ClassLoader.getSystemResource("images/plus100.png").toString());
		plus500 = new Image(ClassLoader.getSystemResource("images/plus500.png").toString());
		jail = new Image(ClassLoader.getSystemResource("images/jail.png").toString());
		chance = new Image(ClassLoader.getSystemResource("images/chance.png").toString());
		
		//character
		character = new Image(ClassLoader.getSystemResource("images/character.png").toString());
		pilot =new Image(ClassLoader.getSystemResource("images/pilot.png").toString());
		duckboii = new Image(ClassLoader.getSystemResource("images/duckboii.png").toString());
		dino = new Image(ClassLoader.getSystemResource("images/dino.png").toString());
		captain = new Image(ClassLoader.getSystemResource("images/captain.png").toString());
		mrCat = new Image(ClassLoader.getSystemResource("images/mr.cat.png").toString());
		penguin = new Image(ClassLoader.getSystemResource("images/penguin.png").toString());
		pilot_profile = new Image(ClassLoader.getSystemResource("images/pilotProfile.png").toString());
		duckboii_profile = new Image(ClassLoader.getSystemResource("images/duckboiiProfile.png").toString());
		dino_profile = new Image(ClassLoader.getSystemResource("images/dinoProfile.png").toString());
		captain_profile = new Image(ClassLoader.getSystemResource("images/captainProfile.png").toString());
		mrCat_profile = new Image(ClassLoader.getSystemResource("images/mr.catProfile.png").toString());
		penguin_profile = new Image(ClassLoader.getSystemResource("images/penguinProfile.png").toString());
		
		// Audio Clip
		themeSong_music = new AudioClip(ClassLoader.getSystemResource("sounds/themeSong.mp3").toString());
		mainmenu_music = new AudioClip(ClassLoader.getSystemResource("sounds/mainmenu.mp3").toString());
		rollDice = new AudioClip(ClassLoader.getSystemResource("sounds/rollDice.mp3").toString());
		endTurn = new AudioClip(ClassLoader.getSystemResource("sounds/endTurn.wav").toString());
		buttonClicked = new AudioClip(ClassLoader.getSystemResource("sounds/buttonClicked.wav").toString());
		gameWin = new AudioClip(ClassLoader.getSystemResource("sounds/gameWin.wav").toString());
		gotCard = new AudioClip(ClassLoader.getSystemResource("sounds/gotItem.mp3").toString());
		useCard = new AudioClip(ClassLoader.getSystemResource("sounds/useItem.wav").toString());
		bombSound = new AudioClip(ClassLoader.getSystemResource("sounds/bomb.mp3").toString());
		healSound = new AudioClip(ClassLoader.getSystemResource("sounds/heal.mp3").toString());
	}

}
