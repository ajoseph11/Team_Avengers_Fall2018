package model;

public class Monster {
	private String name;
	private String roomLocation;
	private String itemDropChance;
	private String armor;
	private int healthPoint;
	private boolean canAttack;
	private boolean canDefend;
	private String specialMove;
	public Monster(String name, String roomLocation, String itemDropChance, String armor, int healthPoint,
			boolean canAttack, boolean canDefend, String specialMove) {
		super();
		this.name = name;
		this.roomLocation = roomLocation;
		this.itemDropChance = itemDropChance;
		this.armor = armor;
		this.healthPoint = healthPoint;
		this.canAttack = canAttack;
		this.canDefend = canDefend;
		this.specialMove = specialMove;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoomLocation() {
		return roomLocation;
	}
	public void setRoomLocation(String roomLocation) {
		this.roomLocation = roomLocation;
	}
	public String getItemDropChance() {
		return itemDropChance;
	}
	public void setItemDropChance(String itemDropChance) {
		this.itemDropChance = itemDropChance;
	}
	public String getArmor() {
		return armor;
	}
	public void setArmor(String armor) {
		this.armor = armor;
	}
	public int getHealthPoint() {
		return healthPoint;
	}
	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}
	public boolean isCanAttack() {
		return canAttack;
	}
	public void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
	}
	public boolean isCanDefend() {
		return canDefend;
	}
	public void setCanDefend(boolean canDefend) {
		this.canDefend = canDefend;
	}
	public String getSpecialMove() {
		return specialMove;
	}
	public void setSpecialMove(String specialMove) {
		this.specialMove = specialMove;
	}
	@Override
	public String toString() {
		return "Monster [name=" + name + ", roomLocation=" + roomLocation + ", itemDropChance=" + itemDropChance
				+ ", armor=" + armor + ", healthPoint=" + healthPoint + ", canAttack=" + canAttack + ", canDefend="
				+ canDefend + ", specialMove=" + specialMove + "]";
	}
	
	
	

}
