package game;

import java.awt.Color;
import java.awt.Graphics2D;

import watoydoEngine.designObjects.display.Displayable;
import watoydoEngine.display.tweens.TweenDefinable;
import watoydoEngine.utils.GraphicsFunctions;

public class StatsUi implements Displayable {
	
	private Player player;
	private double location[];
	private boolean visible;
	private int z;
	private float alpha;
	
	public StatsUi() {
		this.location = new double[]{0,0};
		this.visible = true;
		this.z = 0;
		this.alpha = 1;
	}

	@Override
	public void move(double x, double y) {
		this.location[0] += x;
		this.location[1] += y;
	}

	@Override
	public void kickTween() {
		
	}

	@Override
	public void drawMethod(Graphics2D drawShape) {
		
		drawShape.setComposite(GraphicsFunctions.makeComposite(alpha));
		
		int hp = player.getHP();
		drawBar(drawShape, Color.RED, hp, this.location[0] + 5, this.location[1] + 5);
		
		int mana = player.getMana();
		drawBar(drawShape, Color.BLUE, mana, this.location[0] + 5, this.location[1] + 5 + 11*1);
		
		int food = player.getFood();
		drawBar(drawShape, Color.YELLOW.darker(), food, this.location[0] + 5, this.location[1] + 5 + 11*2);
		
		int happiness = player.getHappiness();
		drawBar(drawShape, Color.GREEN, happiness, this.location[0] + 5, this.location[1] + 5 + 11*3);
		
		int money = player.getMoney();
		drawBar(drawShape, Color.YELLOW, money, this.location[0] + 5, this.location[1] + 5 + 11*4);
		
		drawShape.setComposite(GraphicsFunctions.makeComposite(1));
	}
	
	private void drawBar(Graphics2D drawShape, Color colour, int value, double x, double y) {
		
		drawShape.setColor(Color.black);
		
		drawShape.fillRect((int)x, (int)y, 100, 11);
		
		drawShape.setColor(colour);
		
		drawShape.fillRect((int)x, (int)y + 3, value, 6);
		
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
		return this.location;
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
		if(otherDisplay.getZ() > this.getZ()){
			 return -1;
		}
		else if(otherDisplay.getZ() < this.getZ()){
			return 1;
		}
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
		this.location[0] = x;
		this.location[1] = y;
	}

	@Override
	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public void setTween(TweenDefinable tween) {
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
