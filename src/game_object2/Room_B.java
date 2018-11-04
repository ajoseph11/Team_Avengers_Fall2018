package game_object2;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


public class Room_B {
	private String id;
	private String type;
	private String item;
	private String description;
	private String exit;
	
	
	
	
	private Map<String, String> roomMap = new LinkedHashMap<>();
	
	public Room_B (){
		
	}



	public Room_B(String id, String type, String item, String description, String exit) {
		super();
		this.id = id;
		this.type = type;
		this.item = item;
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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
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
		return "Room_B [id=" + id + ", type=" + type + ", item=" + item + ", description=" + description
				+ ", exit=" + exit + "]";
	}


	
	
	

	

}