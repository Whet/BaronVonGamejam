package game;

import java.util.Random;

public class Player {
	
	private int hp;
	private int mana;
	private int food;
	private int happiness;
	private int money;
	
	private int drainHp;
	private int drainMana;
	private int drainFood;
	private int drainHappiness;
	private int drainMoney;
	
	private int boostHp;
	private int boostMana;
	private int boostFood;
	private int boostHappiness;
	private int boostMoney;
	
	private String head, body;
	private String name;
	
	public Player(String head, String body) {
		Random random = new Random();
		
		this.name = randomName(random);
		
		this.hp = random.nextInt(25) + 76;
		this.mana = random.nextInt(25) + 76;
		this.food = random.nextInt(25) + 76;
		this.happiness = random.nextInt(25) + 76;
		this.money = random.nextInt(10);
		this.head = head;
		this.body = body;
		
		this.drainHp = 0;
		this.drainMana = 0;
		this.drainFood = random.nextInt(5);
		this.drainHappiness = random.nextInt(5);
		this.drainMoney = random.nextInt(5);
		
		this.boostHp = random.nextInt(5);
		this.boostMana = random.nextInt(5);
		this.boostFood = random.nextInt(10);
		this.boostHappiness = random.nextInt(10);
		this.boostMoney = random.nextInt(10);
	}

	private String randomName(Random random) {

		int randomInt = random.nextInt(10);
		
		switch(randomInt) {
			case 0:
			return "Barry";
			case 1:
			return "Sarah";
			case 2:
			return "Dave";
			case 3:
			return "Kate";
			case 4:
			return "Lewis";
			case 5:
			return "Hannah";
			case 6:
			return "Henry";
			case 7:
			return "Pete";
			case 8:
			return "Ben";
			case 9:
			return "Ibrahim";
		}
		return "Merry Fucker";
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

	public String getHead() {
		return this.head;
	}
	
	public String getBody() {
		return this.body;
	}
	
	public void doDraining() {
		this.hp -= drainHp;
		this.mana -= drainMana;
		this.food -= drainFood;
		this.happiness -= drainHappiness;
		this.money -= drainMoney;
	}

	public int getBoostHp() {
		return boostHp;
	}

	public int getBoostMana() {
		return boostMana;
	}

	public int getBoostFood() {
		return boostFood;
	}

	public int getBoostHappiness() {
		return boostHappiness;
	}

	public int getBoostMoney() {
		return boostMoney;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getName() {
		return this.name;
	}
	
	
}
