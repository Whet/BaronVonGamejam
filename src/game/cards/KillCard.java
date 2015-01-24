package game.cards;

import game.CardViewer;
import game.PlayerCollection;

public class KillCard extends Card {

	public KillCard(CardViewer cardViewer, String name, String description) {
		super(cardViewer, name, description);
		this.choices.add(this.getPlayerButton(0));
		this.choices.add(this.getPlayerButton(1));
		this.choices.add(this.getPlayerButton(2));
		this.choices.add(this.getPlayerButton(3));
		this.choices.add(this.getPlayerButton(4));
	}

	@Override
	protected void applyEffect(Object target) {
		PlayerCollection.getInstance().getPlayer((Integer)target).setHp(0);
		cardViewer.hideCard();
	}

}
