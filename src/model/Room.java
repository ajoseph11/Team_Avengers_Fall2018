package model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


public class Room {
	private String id;
	private String type;
	private String item;
	private String monster;
	private String puzzle;
	private String description;
	private String exit;
	
	
	
	
	private Map<String, String> roomMap = new LinkedHashMap<>();
	
	public Room (){
		
	}



	public Room(String id, String type,  String item, String monster, String puzzle,String description, String exit) {
		super();
		this.id = id;
		this.type = type;
		this.item = item;
		this.monster = monster;
		this.puzzle = puzzle;
		this.description = description;
		this.exit = exit;
	}

	public Map<String, String> getRoomMap() {
		return roomMap;
	}

	public void setRoomMap(Map<String, String> roomMap) {
		this.roomMap = roomMap;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
   
	
	public String getPuzzle() {
		return puzzle;
	}



	public void setPuzzle(String puzzle) {
		this.puzzle = puzzle;
	}



	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
    
	
	public String getMonster() {
		return monster;
	}



	public void setMonster(String monster) {
		this.monster = monster;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExit() {
		return exit;
	}

	public void setExit(String exit) {
		this.exit = exit;
	}



	@Override
	public String toString() {
		return "Room_B [id=" + id + ", type=" + type + ", item=" + item + ", monster=" + monster + ", puzzle=" + puzzle
				+ ", description=" + description + ", exit=" + exit + "]";
	}    

	

	





	





	
	
	

	

}
