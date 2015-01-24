package game.cards;

import java.util.ArrayList;
import java.util.List;

import watoydoEngine.designObjects.display.ButtonSingle;
import watoydoEngine.designObjects.display.Text;
import watoydoEngine.workings.displayActivity.ActivePane;

public abstract class Card {

	private List<ButtonSingle> choices;
	private Text nameText;
	private Text descriptionText;
	
	public Card(String name, String description) {
		
		int width = ActivePane.getInstance().getWidth();
		int height = ActivePane.getInstance().getHeight();
		
		this.nameText = new Text(width / 2, height/4, name);
		this.descriptionText = new Text(width / 2, height/4 + 30, description);
		this.choices = new ArrayList<ButtonSingle>();
	}
	
	
	
}
