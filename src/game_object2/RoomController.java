package game_object2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;



public class RoomController {
	
	public static Map<String, String> a2Map = new LinkedHashMap<>();
	public static Map<String, String> b1Map = new LinkedHashMap<>();
	public static Map<String, String> b2Map = new LinkedHashMap<>();
	public static Map<String, String> c1Map = new LinkedHashMap<>();
	public static Map<String, String> c2Map = new LinkedHashMap<>();
	public static Map<String, String> a3Map = new LinkedHashMap<>();
	public static Map<String, String> a4Map = new LinkedHashMap<>();
	public static Map<String, String> b3Map = new LinkedHashMap<>();
	public static Map<String, String> b4Map = new LinkedHashMap<>();
	public static Map<String, String> b5Map = new LinkedHashMap<>();//10
	
	public static Map<String, String> d2Map = new LinkedHashMap<>();
	public static Map<String, String> d1Map = new LinkedHashMap<>();
	public static Map<String, String> d3Map = new LinkedHashMap<>();
	public static Map<String, String> e2Map = new LinkedHashMap<>();
	public static Map<String, String> e3Map = new LinkedHashMap<>();
	public static Map<String, String> c4Map = new LinkedHashMap<>();
	public static Map<String, String> c5Map = new LinkedHashMap<>();
	public static Map<String, String> d4Map = new LinkedHashMap<>();
	public static Map<String, String> d5Map = new LinkedHashMap<>();
	public static Map<String, String> e4Map = new LinkedHashMap<>();//20
	
	public static Map<String, String> a1Map = new LinkedHashMap<>();
	public static Map<String, String> e1Map = new LinkedHashMap<>();
	public static Map<String, String> a5Map = new LinkedHashMap<>(); //23
	
	
	public static Map<String, String> entranceChamberMap = new LinkedHashMap<>();
	public static Map<String, String> connectingChamberMap = new LinkedHashMap<>();
	public static Map<String, String> spiralStaircaseMap = new LinkedHashMap<>();
	public static Map<String, String> guardLockedDoorMap = new LinkedHashMap<>();
	public static Map<String, String> sorcererBossFightRoomMap = new LinkedHashMap<>();
	public static Map<String, String> stairsB1FMap = new LinkedHashMap<>();
	public static Map<String, String> necromancerRoomMap = new LinkedHashMap<>(); //30
	
	

	public static String errorMessage;

	public static Room_B roomA2, roomB1, roomB2, roomC1, roomC2, roomA3, roomA4,roomB3, roomB4, roomB5; // First 10 rooms
	public static Room_B roomD2, roomD1, roomD3, roomE2, roomE3, roomC4, roomC5,roomD4, roomD5, roomE4; // Second 10 rooms making 20
	public static Room_B roomA1, roomE1, roomA5; // last 3 reular rooms making 27 regular rooms
	public static Room_B entranceChamberRoom, connectingChamberRoom, spiralStaircaseRoom, guardLockedDoorRoom, sorcererBossFightRoom, stairsB1FRoom, necromancerRoom; //7 special rooms

	//public static Room_B roomB1;
	//public static Room_B roomB2;
	//public static Room_B roomC1;
	//public static Room_B roomC2;
	//public static Room_B roomA3;
	//public static Room_B roomA4;
	//public static Room_B roomB3;
	
	





	public static void setPuzzleFromText() throws IOException {
		
		// track which line you are currently reading
				int currentLine = 0;
				String lineNumber = "";

				// concrete instantiation of maps to store information for each room
				a2Map = new LinkedHashMap<>();
				b1Map = new LinkedHashMap<>();
				b2Map = new LinkedHashMap<>();
				c1Map = new LinkedHashMap<>();
				c2Map = new LinkedHashMap<>();
				a3Map = new LinkedHashMap<>();
				a4Map = new LinkedHashMap<>();
				b3Map = new LinkedHashMap<>();

				// concrete instantiation of room object to store information for each room

				roomA2 = new Room_B();
				roomB1 = new Room_B();
				roomB2 = new Room_B();
				roomC1 = new Room_B();
				roomC2 = new Room_B();
				roomA3 = new Room_B();
				roomA4 = new Room_B();
				roomB3 = new Room_B();

				String roomFile = "Room.txt";
				String line;
				BufferedReader reader = new BufferedReader(new FileReader(roomFile));
				while((line = reader.readLine()) != null) {
					currentLine++;
					String [] lineContent = line.split(":", 2);
				//print the key and value as a set
					try {
					if (lineContent.length >= 2) {
						lineNumber = String.valueOf(currentLine);
						String key = lineContent[0];
						String value = lineContent[1];
						if ((currentLine >= 1) && (currentLine <= 7)) {
								a2Map.put(key, value);
						}
						if ((currentLine >= 9) && (currentLine <= 15)) {
							b1Map.put(key, value);
					   }
						if ((currentLine >= 17) && (currentLine <= 23)) {
							b2Map.put(key, value);
					   }
						if ((currentLine >= 25) && (currentLine <= 31)) {
							c1Map.put(key, value);
					   }
						if ((currentLine >= 33) && (currentLine <= 39)) {
							c2Map.put(key, value);
					   }
						if ((currentLine >= 41) && (currentLine <= 47)) {
							a3Map.put(key, value);
					   }
						if ((currentLine >= 49) && (currentLine <= 55)) {
							a4Map.put(key, value);
					   }
						if ((currentLine >= 57) && (currentLine <= 63)) {
							b3Map.put(key, value);
					   }
						
						//set the current map as the value for each puzzle Map object
						
						roomA2.setRoomMap(a2Map);
						roomB1.setRoomMap(b1Map);
						roomB2.setRoomMap(b2Map);
						roomC1.setRoomMap(c1Map);
						roomC2.setRoomMap(c2Map);
						roomA3.setRoomMap(a3Map);
						roomA4.setRoomMap(a4Map);
						roomB3.setRoomMap(b3Map);
					    roomB4.setRoomMap(b4Map); 
					    roomB5.setRoomMap(b5Map);
					    roomD2.setRoomMap(d2Map);
					    roomD1.setRoomMap(d1Map);
					    roomD3.setRoomMap(d3Map);
					    roomE2.setRoomMap(e2Map);
					    roomE3.setRoomMap(e3Map);
					    roomC4.setRoomMap(c4Map);
					    roomC5.setRoomMap(c5Map);
					    roomD4.setRoomMap(d4Map);
					    roomD5.setRoomMap(d5Map);
					    roomE4.setRoomMap(e4Map);
						//Speacial ROoms
					    entranceChamberRoom.setRoomMap(entranceChamberMap);
					    connectingChamberRoom.setRoomMap(connectingChamberMap);
					    spiralStaircaseRoom.setRoomMap(spiralStaircaseMap);
					    guardLockedDoorRoom.setRoomMap(guardLockedDoorMap);
					    sorcererBossFightRoom.setRoomMap(sorcererBossFightRoomMap);
					    stairsB1FRoom.setRoomMap(stairsB1FMap);
					    necromancerRoom.setRoomMap(necromancerRoomMap);
					}
					else {
						errorMessage = "Room_B Class :: Program Beginning.....";
						System.out.println(errorMessage);
					}
						
					}
				
				catch (Exception e) {
					errorMessage = 	"One or more line may be empty and giving null String:: Please check";
					
					e.printStackTrace();
				System.out.println(errorMessage);
				}
				}
				// Create an array of puzzle objects
				Room_B[] roomObjects = { roomA2, roomB1, roomB2, roomC1, roomC2, roomA3, roomA4,roomB3, roomB4, roomB5, 
						roomD2, roomD1, roomD3, roomE2, roomE3, roomC4, roomC5,roomD4, roomD5, roomE4,
						entranceChamberRoom, connectingChamberRoom, spiralStaircaseRoom, guardLockedDoorRoom, sorcererBossFightRoom, stairsB1FRoom, necromancerRoom
				};
				// Create an array of puzzle linked hash map objects from which you are calling
				// values for the fields of the hashmap above
				Map[] roomLinkedhashMapObjects = { roomA2.getRoomMap(), roomB1.getRoomMap(), roomB2.getRoomMap(),
						roomC1.getRoomMap(), roomC2.getRoomMap(), roomA3.getRoomMap(), roomA4.getRoomMap(),
						roomB3.getRoomMap() };
				
				// print key and value side by side as seperate entities
				for (int i = 0; i < roomObjects.length; i++) {
					for (String keyItem : roomObjects[i].getRoomMap().keySet()) {

						String key = keyItem.toString();
						String value = roomObjects[i].getRoomMap().get(keyItem).toString();
						//System.out.println( key + " " + value);
						// System.out.println("");

					}
				}
				
				try {
					for (int i = 0; i < roomLinkedhashMapObjects.length; i++) {
					    roomObjects[i].setId(roomLinkedhashMapObjects[i].get("ID").toString());
						roomObjects[i].setType(roomLinkedhashMapObjects[i].get("RoomType").toString());
						roomObjects[i].setItem(roomLinkedhashMapObjects[i].get("Item").toString());
						roomObjects[i].setMonster(roomLinkedhashMapObjects[i].get("Monster").toString());
						roomObjects[i].setPuzzle(roomLinkedhashMapObjects[i].get("Puzzle").toString());
						roomObjects[i].setDescription(roomLinkedhashMapObjects[i].get("Desc").toString());
						roomObjects[i].setExit(roomLinkedhashMapObjects[i].get("Exits").toString());
						// System.out.println(puzzleObjects[i].toString());
					}
				} catch (Exception e) {
					errorMessage = "One or more lines is/are null/empty:: please check";
					e.printStackTrace();
					System.out.println(errorMessage + " " + e);
				}
	}


	public static Room_B getRoomA2() {
		return roomA2;
	}


	public static void setRoomA2(Room_B roomA2) {
		RoomController.roomA2 = roomA2;
	}


	public static Room_B getRoomB1() {
		return roomB1;
	}


	public static void setRoomB1(Room_B roomB1) {
		RoomController.roomB1 = roomB1;
	}


	public static Room_B getRoomB2() {
		return roomB2;
	}


	public static void setRoomB2(Room_B roomB2) {
		RoomController.roomB2 = roomB2;
	}


	public static Room_B getRoomC1() {
		return roomC1;
	}


	public static void setRoomC1(Room_B roomC1) {
		RoomController.roomC1 = roomC1;
	}


	public static Room_B getRoomC2() {
		return roomC2;
	}


	public static void setRoomC2(Room_B roomC2) {
		RoomController.roomC2 = roomC2;
	}


	public static Room_B getRoomA3() {
		return roomA3;
	}


	public static void setRoomA3(Room_B roomA3) {
		RoomController.roomA3 = roomA3;
	}


	public static Room_B getRoomA4() {
		return roomA4;
	}


	public static void setRoomA4(Room_B roomA4) {
		RoomController.roomA4 = roomA4;
	}
	
	public static Room_B getRoomB3() {
		return roomB3;
	}


	public static void setRoomB3(Room_B roomB3) {
		RoomController.roomB3 = roomB3;
	}

}
