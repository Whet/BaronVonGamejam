package game.cards;

import game.CardViewer;
import game.PlayerCollection;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import watoydoEngine.designObjects.display.TextButton;

public abstract class Card {

	protected List<TextButton> choices;
	private String nameText;
	private String descriptionText;
	protected CardViewer cardViewer;
	
	public Card(CardViewer cardViewer, String name, String description) {
		this.nameText = name;
		this.descriptionText = description;
		this.choices = new ArrayList<TextButton>();
		this.cardViewer = cardViewer;
	}

	public String getNameText() {
		return nameText;
	}

	public String getDescriptionText() {
		return descriptionText;
	}
	
	public List<TextButton> getChoices() {
		return choices;
	}

	public void setNameText(String nameText) {
		this.nameText = nameText;
	}

	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}

	protected abstract void applyEffect(Object target);
	
	protected TextButton getPlayerButton(final int playerNumber) {
		return new TextButton(Color.black, Color.gray) {
			
			{
				this.setText(PlayerCollection.getInstance().getPlayer(playerNumber).getName());
				this.setDrawBox(false);
				this.setAlpha(1);
			}
			
			@Override
			public boolean mU(Point mousePosition, MouseEvent e) {
				applyEffect(playerNumber);
				return true;
			}
			
		};
	}
	
}
