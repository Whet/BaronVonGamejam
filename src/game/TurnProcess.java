package game;

import game.cards.Card;
import game.cards.KillCard;

public class TurnProcess {
	
	public TurnProcess() {
	}

	public Card getCard(CardViewer cardViewer) {
		return new KillCard(cardViewer, "DOOM", "Choose someone to die");
	}

}
