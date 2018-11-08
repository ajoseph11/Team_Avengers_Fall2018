package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Monster {
	private String monsterName;
	private String roomLocation;
	private String itemsDrop;
	private int valueGain;
	private String armor;
	private int monsterHealth;
	private boolean canAttack;
	private boolean canDefend;
	private int healthLoss;
	private int valueLoss;
	private String mosterDesc;
	
	private Map<String, String> mosterMap = new LinkedHashMap<>();

	public Monster() {
		super();
	}

	public Monster(String monsterName, String roomLocation, String itemsDrop, int valueGain, String armor,
			int monsterHealth, boolean canAttack, boolean canDefend, int healthLoss, int valueLoss, String mosterDesc) {
		super();
		this.monsterName = monsterName;
		this.roomLocation = roomLocation;
		this.itemsDrop = itemsDrop;
		this.valueGain = valueGain;
		this.armor = armor;
		this.monsterHealth = monsterHealth;
		this.canAttack = canAttack;
		this.canDefend = canDefend;
		this.healthLoss = healthLoss;
		this.valueLoss = valueLoss;
		this.mosterDesc = mosterDesc;
	}

	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

	public String getRoomLocation() {
		return roomLocation;
	}

	public void setRoomLocation(String roomLocation) {
		this.roomLocation = roomLocation;
	}

	public String getItemsDrop() {
		return itemsDrop;
	}

	public void setItemsDrop(String itemsDrop) {
		this.itemsDrop = itemsDrop;
	}

	public int getValueGain() {
		return valueGain;
	}

	public void setValueGain(int valueGain) {
		this.valueGain = valueGain;
	}

	public String getArmor() {
		return armor;
	}

	public void setArmor(String armor) {
		this.armor = armor;
	}

	public int getMonsterHealth() {
		return monsterHealth;
	}

	public void setMonsterHealth(int monsterHealth) {
		this.monsterHealth = monsterHealth;
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

	public int getHealthLoss() {
		return healthLoss;
	}

	public void setHealthLoss(int healthLoss) {
		this.healthLoss = healthLoss;
	}

	public int getValueLoss() {
		return valueLoss;
	}

	public void setValueLoss(int valueLoss) {
		this.valueLoss = valueLoss;
	}

	public String getMosterDesc() {
		return mosterDesc;
	}

	public void setMosterDesc(String mosterDesc) {
		this.mosterDesc = mosterDesc;
	}

	public Map<String, String> getMosterMap() {
		return mosterMap;
	}

	public void setMosterMap(Map<String, String> mosterMap) {
		this.mosterMap = mosterMap;
	}

	@Override
	public String toString() {
		return "Monster [monsterName=" + monsterName + ", roomLocation=" + roomLocation + ", itemsDrop=" + itemsDrop
				+ ", valueGain=" + valueGain + ", armor=" + armor + ", monsterHealth=" + monsterHealth + ", canAttack="
				+ canAttack + ", canDefend=" + canDefend + ", healthLoss=" + healthLoss + ", valueLoss=" + valueLoss
				+ ", mosterDesc=" + mosterDesc + "]";
	}

	
	

	
	

}
