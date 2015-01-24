package game.cards;

import java.util.ArrayList;
import java.util.List;

import watoydoEngine.designObjects.display.ButtonSingle;
import watoydoEngine.designObjects.display.Text;
import watoydoEngine.workings.displayActivity.ActivePane;

public abstract class Card {

	private List<ButtonSingle> choices;
	private String nameText;
	private String descriptionText;
	
	public Card(String name, String description) {
		
		int width = ActivePane.getInstance().getWidth();
		int height = ActivePane.getInstance().getHeight();
		
		this.nameText = name;
		this.descriptionText = description;
		this.choices = new ArrayList<ButtonSingle>();
	}

	public String getNameText() {
		return nameText;
	}

	public String getDescriptionText() {
		return descriptionText;
	}

	public void setNameText(String nameText) {
		this.nameText = nameText;
	}

	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}

}
