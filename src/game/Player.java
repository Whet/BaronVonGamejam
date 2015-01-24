package game;

import java.util.Random;

public class Player {
	
	private int hp;
	private int mana;
	private int food;
	private int happiness;
	private int money;
	
	public Player() {
		Random random = new Random();
		this.hp = random.nextInt(25) + 76;
		this.mana = random.nextInt(25) + 76;
		this.food = random.nextInt(25) + 76;
		this.happiness = random.nextInt(25) + 76;
		this.money = random.nextInt(10);
	}

	public int getHP() {
		return this.hp;
	}

	public int getMana() {
		return this.mana;
	}

	public int getFood() {
		return this.food;
	}

	public int getHappiness() {
		return this.happiness;
	}

	public int getMoney() {
		return this.money;
	}

}
