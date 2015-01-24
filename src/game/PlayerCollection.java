package game;

public class PlayerCollection {

	private static PlayerCollection instance;
	
	public static PlayerCollection getInstance() {
		if(instance == null) {
			instance = new PlayerCollection();
		}
		return instance;
	}

	private Player[] players;
	
	private PlayerCollection() {
		this.players = new Player[]{new Player(), new Player(), new Player(), new Player(), new Player()};
	}
	
	public Player getPlayer(int playerNumber) {
		return this.players[playerNumber];
	}
	
}
