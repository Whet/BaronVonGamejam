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
		this.players = new Player[]{new Player("head1.png","body1.png"), new Player("head1.png","body1.png"), new Player("head1.png","body1.png"), new Player("head1.png","body1.png"), new Player("head1.png","body1.png")};
	}
	
	public Player getPlayer(int playerNumber) {
		return this.players[playerNumber];
	}
	
}
