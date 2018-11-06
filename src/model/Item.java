package model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


public class Item extends Room{
	private String itemCategory;
	private String itemName;
	private String itemID;
	private String itemDescription;
	private String itemRoomID;
	private String characterCompatibiltiy;
	private int gemValue;
	private boolean stackable;

	private Map<String, String> itemMap = new LinkedHashMap<>();
	public Item(){

    }

	public Item(String itemCategory, String itemName, String itemID, String itemDescription, String itemRoomID,
				String characterCompatibiltiy, int gemValue, boolean stackable) {
		super();
		this.itemCategory = itemCategory;
		this.itemName = itemName;
		this.itemID = itemID;
		this.itemDescription = itemDescription;
		this.itemRoomID = itemRoomID;
		this.characterCompatibiltiy = characterCompatibiltiy;
		this.gemValue = gemValue;
		this.stackable = stackable;


	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getItemRoomID() {
		return itemRoomID;
	}
	public void setItemRoomID(String itemRoomID) {
		this.itemRoomID = itemRoomID;
	}
	public String getCharacterCompatibiltiy() {
		return characterCompatibiltiy;
	}
	public void setCharacterCompatibiltiy(String characterCompatibiltiy) {
		this.characterCompatibiltiy = characterCompatibiltiy;
	}
	public int getGemValue() {
		return gemValue;
	}
	public void setGemValue(int gemValue) {
		this.gemValue = gemValue;
	}
	public boolean isStackable() {
		return stackable;
	}
	public void setStackable(boolean stackable) {
		this.stackable = stackable;
	}

    public Map<String, String> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<String, String> itemMap) {
        this.itemMap = itemMap;
    }


    @Override
	public String toString() {
		return "Item [itemCategory=" + itemCategory + ", itemName=" + itemName + ", itemID=" + itemID
				+ ", itemDescription=" + itemDescription + ", itemRoomID=" + itemRoomID + ", characterCompatibiltiy="
				+ characterCompatibiltiy + ", gemValue=" + gemValue + ", stackable=" + stackable + "]";
	}
	
	
	
}
