package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Monster {
	private String monsterName;
	private String roomLocation;
	private String itemsDrop;
	private String valueGain;
	private String armor;
	private String monsterHealth;
	private boolean canAttack;
	private boolean canDefend;
	private String healthLoss;
	private String valueLoss;
	private String monsterDesc;
	//private String specialMove;

	private Map<String, String> monsterMap = new LinkedHashMap<>();

	public Monster(){

	}
	public Monster(String name, String roomLocation, String itemDropChance, String armor, int healthPoint,
			boolean canAttack, boolean canDefend, String specialMove) {

	}

	public Monster(String monsterName, String roomLocation, String itemsDrop, String valueGain, String armor,
			String monsterHealth, boolean canAttack, boolean canDefend, String healthLoss, String valueLoss, String monsterDesc) {

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
		this.monsterDesc = monsterDesc;
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

	public String getValueGain() {
		return valueGain;
	}

	public void setValueGain(String valueGain) {
		this.valueGain = valueGain;
	}

	public String getArmor() {
		return armor;
	}

	public void setArmor(String armor) {
		this.armor = armor;
	}

	public String getMonsterHealth() {
		return monsterHealth;
	}

	public void setMonsterHealth(String string) {
		this.monsterHealth = string;
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

	public String getHealthLoss() {
		return healthLoss;
	}

	public void setHealthLoss(String healthLoss) {
		this.healthLoss = healthLoss;
	}

	public String getValueLoss() {
		return valueLoss;
	}

	public void setValueLoss(String valueLoss) {
		this.valueLoss = valueLoss;
	}

	public String getMonsterDesc() {
		return monsterDesc;
	}

	public void setMonsterDesc(String monsterDesc) {
		this.monsterDesc = monsterDesc;
	}

	public Map<String, String> getMonsterMap() {
		return monsterMap;
	}

	public void setMonsterMap(Map<String, String> monsterMap) {
		this.monsterMap = monsterMap;
	}

	@Override
	public String toString() {
		return "Monster [monsterName=" + monsterName + ", roomLocation=" + roomLocation + ", itemsDrop=" + itemsDrop
				+ ", valueGain=" + valueGain + ", armor=" + armor + ", monsterHealth=" + monsterHealth + ", canAttack="
				+ canAttack + ", canDefend=" + canDefend + ", healthLoss=" + healthLoss + ", valueLoss=" + valueLoss
				+ ", monsterDesc=" + monsterDesc + "]";
	}

	
	

	
	

}
