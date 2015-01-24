package game;

public class PlayerCollection {

	private static PlayerCollection instance;
	
	public static PlayerCollection getInstance() {
		if(instance == null) {
			instance = new PlayerCollection();
		}
		return instance;
	}

	public Player getPlayer(int playerNumber) {
		return null;
	}
	
}
