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

import watoydoEngine.designObjects.actions.MouseRespondable;
import watoydoEngine.designObjects.display.ButtonSingle;
import watoydoEngine.designObjects.display.Displayable;
import watoydoEngine.designObjects.display.ImageSingle;
import watoydoEngine.designObjects.display.Text;
import watoydoEngine.display.tweens.TweenDefinable;
import watoydoEngine.io.ReadWriter;
import watoydoEngine.workings.displayActivity.ActivePane;

public class CardViewer implements Displayable, MouseRespondable {

	private boolean visible;
	private int z;
	private boolean active;
	
	private Set<ButtonSingle> buttons;
	
	private ImageSingle cardBack;
	private Card currentCard;
	private Text cardName;
	private Text cardDescription;
	
	public CardViewer(ButtonSingle optionOne, ButtonSingle optionTwo, ButtonSingle optionThree) {
		this.visible= false;
		this.z = 0;
		this.active = false;
		
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
		cardDescription = new Text((int)(centreX - this.cardBack.getSize()[0] / 2 + 2), (int)(centreY - this.cardBack.getSize()[1] / 2 + 28));
		
		this.cardName.setAlpha(1);
		this.cardDescription.setAlpha(1);
	}
	
	public void displayCard(Card card) {
		System.out.println("SHOW CARD");
		this.setVisible(true);
		this.setActive(true);
		disableOther();
		this.currentCard = card;
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
	public void move(double x, double y) {
	}

	@Override
	public void kickTween() {
	}

	@Override
	public void drawMethod(Graphics2D drawShape) {
		this.cardBack.drawMethod(drawShape);
		this.cardName.setText(currentCard.getNameText());
		this.cardName.drawMethod(drawShape);
		this.cardDescription.setText(currentCard.getDescriptionText());
		this.cardDescription.drawMethod(drawShape);
	}

	@Override
	public boolean isVisible() {
		return this.visible;
	}

	@Override
	public double getScale() {
		return 1;
	}

	@Override
	public double[] getLocation() {
		return null;
	}

	@Override
	public int getZ() {
		return this.z;
	}

	@Override
	public double[] getSize() {
		return null;
	}

	@Override
	public int compareTo(Displayable otherDisplay) {
		return 0;
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public void setScale(double scale) {
		
	}

	@Override
	public void setLocation(double x, double y) {
		
	}

	@Override
	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public void setTween(TweenDefinable tween) {
	}

	@Override
	public boolean mD(Point mousePosition, MouseEvent e) {
		return false;
	}

	@Override
	public boolean mU(Point mousePosition, MouseEvent e) {
		
		this.hideCard();
		
		return true;
	}

	@Override
	public boolean mC(Point mousePosition, MouseEvent e) {
		return false;
	}

	@Override
	public boolean rMD(Point mousePosition, MouseEvent e) {
		return false;
	}

	@Override
	public boolean rMU(Point mousePosition, MouseEvent e) {
		return false;
	}

	@Override
	public boolean rMC(Point mousePosition, MouseEvent e) {
		return false;
	}

	@Override
	public boolean mMC(Point mousePosition, MouseEvent e) {
		return false;
	}

	@Override
	public void mI(Point mousePosition) {
		
	}

	@Override
	public void mO(Point mousePosition) {
		
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public boolean isInBounds(double x, double y) {
		return true;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int getActionZ() {
		return 0;
	}

	@Override
	public void setActionZ(int actionZ) {
	}

}
