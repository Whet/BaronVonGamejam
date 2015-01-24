package game;

import game.cards.Card;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

import watoydoEngine.designObjects.actions.MouseRespondable;
import watoydoEngine.designObjects.display.ButtonSingle;
import watoydoEngine.designObjects.display.Displayable;
import watoydoEngine.display.tweens.TweenDefinable;

public class CardViewer implements Displayable, MouseRespondable {

	private boolean visible;
	private int z;
	private boolean active;
	
	private Set<ButtonSingle> buttons;
	
	
	public CardViewer(ButtonSingle optionOne, ButtonSingle optionTwo, ButtonSingle optionThree) {
		this.visible= false;
		this.z = 0;
		this.active = false;
		
		buttons = new HashSet<>();
		buttons.add(optionOne);
		buttons.add(optionTwo);
		buttons.add(optionThree);
	}
	
	public void displayCard(Card card) {
		System.out.println("SHOW CARD");
		this.setVisible(true);
		this.setActive(true);
		disableOther();
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
		drawShape.setColor(Color.red);
		drawShape.fillRect(500, 500, 300, 300);
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
