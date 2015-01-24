package game;

import game.cards.Card;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;

import watoydoEngine.designObjects.display.ButtonSingle;
import watoydoEngine.designObjects.display.Crowd;
import watoydoEngine.designObjects.display.Displayable;
import watoydoEngine.designObjects.display.ImageSingle;
import watoydoEngine.designObjects.display.Text;
import watoydoEngine.designObjects.display.TextButton;
import watoydoEngine.display.tweens.TweenDefinable;
import watoydoEngine.io.ReadWriter;
import watoydoEngine.workings.displayActivity.ActivePane;

public class CardViewer extends Crowd {

	private Set<ButtonSingle> buttons;
	
	private ImageSingle cardBack;
	private Card currentCard;
	private Text cardName;
	private Text cardDescription;
	
	public CardViewer(ButtonSingle optionOne, ButtonSingle optionTwo, ButtonSingle optionThree) {
		super(false);

		try {
			cardBack = new ImageSingle(ImageIO.read(ReadWriter.getResourceAsInputStream("cardBackPlaceholder.png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		buttons = new HashSet<>();
		buttons.add(optionOne);
		buttons.add(optionTwo);
		buttons.add(optionThree);
		
		int centreX = ActivePane.getInstance().getWidth() / 2;
		int centreY = ActivePane.getInstance().getHeight() / 2;
		
		this.cardBack.setLocation(centreX - cardBack.getSize()[0] / 2, centreY - cardBack.getSize()[1] / 2);

		cardName = new Text((int)(centreX - this.cardBack.getSize()[0] / 2 + 2), (int)(centreY - this.cardBack.getSize()[1] / 2 + 10));
		cardName.setColour(Color.black);
		
		cardDescription = new Text((int)(centreX - this.cardBack.getSize()[0] / 2 + 2), (int)(centreY - this.cardBack.getSize()[1] / 2 + 28));
		cardDescription.setColour(Color.black);
		
		this.cardName.setAlpha(1);
		this.cardDescription.setAlpha(1);
	}
	
	public void displayCard(Card card) {
		System.out.println("SHOW CARD");
		this.setVisible(true);
		this.setActive(true);
		disableOther();
		this.currentCard = card;
		
		int centreX = ActivePane.getInstance().getWidth() / 2;
		int centreY = ActivePane.getInstance().getHeight() / 2;
		
		this.getMouseActionList().clear();
		
		for(int i = 0; i < currentCard.getChoices().size(); i++) {
			currentCard.getChoices().get(i).setLocation((int)(centreX - this.cardBack.getSize()[0] / 2 + 2), (int)(centreY - this.cardBack.getSize()[1] / 2 + 58 + i * 20));
			this.addMouseActionItem(currentCard.getChoices().get(i));
		}
	}
	
	public void hideCard() {
		System.out.println("HIDE CARD");
		this.setVisible(false);
		this.setActive(false);
		enableOther();
	}

	private void disableOther() {
		for(ButtonSingle btn:buttons) {
			btn.setActive(false);
		}
	}
	
	private void enableOther() {
		for(ButtonSingle btn:buttons) {
			btn.setActive(true);
		}
	}

	@Override
	public void drawMethod(Graphics2D drawShape) {
		this.cardBack.drawMethod(drawShape);
		this.cardName.setText(currentCard.getNameText());
		this.cardName.drawMethod(drawShape);
		this.cardDescription.setText(currentCard.getDescriptionText());
		this.cardDescription.drawMethod(drawShape);
		
		for(TextButton choice:this.currentCard.getChoices()) {
			choice.drawMethod(drawShape);
		}
	}

}
