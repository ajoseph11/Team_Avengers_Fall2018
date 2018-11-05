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
	public static Map<String, String> e5Map = new LinkedHashMap<>(); //23

	
	
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
	public static Room_B roomA1, roomE1, roomA5, roomE5; // last 3 rgeular rooms making 27 regular rooms
	public static Room_B entranceChamberRoom, connectingChamberRoom, spiralStaircaseRoom, guardLockedDoorRoom, sorcererBossFightRoom, stairsB1FRoom, necromancerRoom; //7 special rooms

	//public static Room_B roomB1;
	//public static Room_B roomB2;
	//public static Room_B roomC1;
	//public static Room_B roomC2;
	//public static Room_B roomA3;
	//public static Room_B roomA4;
	//public static Room_B roomB3;
	
	





	public static void setRoomFromText() throws IOException {
		
		// track which line you are currently reading
				int currentLine = 0;
				String lineNumber = "";

				// concrete instantiation of maps to store information for each room
				/*a2Map = new LinkedHashMap<>();
				b1Map = new LinkedHashMap<>();
				b2Map = new LinkedHashMap<>();
				c1Map = new LinkedHashMap<>();
				c2Map = new LinkedHashMap<>();
				a3Map = new LinkedHashMap<>();
				a4Map = new LinkedHashMap<>();
				b3Map = new LinkedHashMap<>();
				b4Map = new LinkedHashMap<>();
				b5Map = new LinkedHashMap<>();*/
				
				

				// concrete instantiation of room object to store information for each room

				roomA2 = new Room_B();
				roomB1 = new Room_B();
				roomB2 = new Room_B();
				roomC1 = new Room_B();
				roomC2 = new Room_B();
				roomA3 = new Room_B();
				roomA4 = new Room_B();
				roomB3 = new Room_B();
				roomB4 = new Room_B();
				roomB5 = new Room_B();
				
				roomD2 = new Room_B();
				roomD1 = new Room_B();
				roomD3 = new Room_B();
				roomE2 = new Room_B();
				roomE3 = new Room_B();
				roomC4 = new Room_B();
				roomC5 = new Room_B();
				roomD4 = new Room_B();
				roomD5 = new Room_B();
				roomE4 = new Room_B();
				
				roomA1 = new Room_B();
				roomE1 = new Room_B();
				roomA5 = new Room_B();
				roomE5 = new Room_B();
				
				entranceChamberRoom = new Room_B();
				connectingChamberRoom = new Room_B();
				spiralStaircaseRoom = new Room_B();
				guardLockedDoorRoom = new Room_B();
				sorcererBossFightRoom = new Room_B();
				stairsB1FRoom = new Room_B();
				necromancerRoom = new Room_B();

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
						if ((currentLine >= 65) && (currentLine <= 71)) {
							b4Map.put(key, value);
					   }
						if ((currentLine >= 73) && (currentLine <= 79)) {
							b5Map.put(key, value);
					   }
						if ((currentLine >= 81) && (currentLine <= 87)) {
							d2Map.put(key, value);
					   }
						if ((currentLine >= 89) && (currentLine <= 95)) {
							d1Map.put(key, value);
					   }
						if ((currentLine >= 97) && (currentLine <= 103)) {
							d3Map.put(key, value);
					   }
						if ((currentLine >= 105) && (currentLine <= 111)) {
							e2Map.put(key, value);
					   }
						if ((currentLine >= 113) && (currentLine <= 119)) {
							e3Map.put(key, value);
					   }
						if ((currentLine >= 121) && (currentLine <= 127)) {
							c4Map.put(key, value);
					   }
						if ((currentLine >= 129) && (currentLine <= 135)) {
							c5Map.put(key, value);
					   }
						if ((currentLine >=137) && (currentLine <= 143)) {
							d4Map.put(key, value);
					   }
						if ((currentLine >= 145) && (currentLine <= 151)) {
							d5Map.put(key, value);
					   }
						if ((currentLine >= 153) && (currentLine <= 160)) {
							e4Map.put(key, value);
					   }
						if ((currentLine >= 162) && (currentLine <= 168)) {
							a1Map.put(key, value);
					   }
						if ((currentLine >= 170) && (currentLine <= 176)) {
							e1Map.put(key, value);
					   }
						if ((currentLine >= 178) && (currentLine <= 184)) {
							a5Map.put(key, value);
					   }
						if ((currentLine >= 186) && (currentLine <= 192)) {
							e5Map.put(key, value);
					   }
						if ((currentLine >= 194) && (currentLine <= 200)) {
							entranceChamberMap.put(key, value);
					   }
						if ((currentLine >= 202) && (currentLine <= 208)) {
							connectingChamberMap.put(key, value);
					   }
						if ((currentLine >= 210) && (currentLine <= 216)) {
							spiralStaircaseMap.put(key, value);
					   }
						if ((currentLine >= 218) && (currentLine <= 224)) {
							guardLockedDoorMap.put(key, value);
					   }
						if ((currentLine >= 226) && (currentLine <= 232)) {
							sorcererBossFightRoomMap.put(key, value);
					   }
						if ((currentLine >= 234) && (currentLine <= 240)) {
							stairsB1FMap.put(key, value);
					   }
						if ((currentLine >= 242) && (currentLine <= 248)) {
							necromancerRoomMap.put(key, value);
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
					    roomE4.setRoomMap(e4Map);//20
					    roomA1.setRoomMap(a1Map);
					    roomE1.setRoomMap(e1Map);
					    roomA5.setRoomMap(a5Map);
					    roomE5.setRoomMap(e5Map);//4
					    
						//Speacial 7 ROoms
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
						roomA1, roomE1, roomA5, roomE5,
						entranceChamberRoom, connectingChamberRoom, spiralStaircaseRoom, guardLockedDoorRoom, sorcererBossFightRoom, stairsB1FRoom, necromancerRoom
				};
				// Create an array of puzzle linked hash map objects from which you are calling
				// values for the fields of the hashmap above
				Map[] roomLinkedhashMapObjects = { 
						//roomA2.getRoomMap(), roomB1.getRoomMap(), roomB2.getRoomMap(),
						//roomC1.getRoomMap(), roomC2.getRoomMap(), roomA3.getRoomMap(), roomA4.getRoomMap(),
						//roomB3.getRoomMap() 
						roomA2.getRoomMap(), roomB1.getRoomMap(), roomB2.getRoomMap(), roomC1.getRoomMap(), roomC2.getRoomMap(), roomA3.getRoomMap(), roomA4.getRoomMap(),roomB3.getRoomMap(), roomB4.getRoomMap(), roomB5.getRoomMap(), //10
						roomD2.getRoomMap(), roomD1.getRoomMap(), roomD3.getRoomMap(), roomE2.getRoomMap(), roomE3.getRoomMap(), roomC4.getRoomMap(), roomC5.getRoomMap(),roomD4.getRoomMap(), roomD5.getRoomMap(), roomE4.getRoomMap(),//10
						roomA1.getRoomMap(), roomE1.getRoomMap(), roomA5.getRoomMap(), roomE5.getRoomMap(),//4
						entranceChamberRoom.getRoomMap(), connectingChamberRoom.getRoomMap(), spiralStaircaseRoom.getRoomMap(), guardLockedDoorRoom.getRoomMap(), sorcererBossFightRoom.getRoomMap(), stairsB1FRoom.getRoomMap(), necromancerRoom.getRoomMap()//7
				
				};
				
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

	public static Map<String, String> getSpiralStaircaseMap() {
		return spiralStaircaseMap;
	}

	public static void setSpiralStaircaseMap(Map<String, String> spiralStaircaseMap) {
		RoomController.spiralStaircaseMap = spiralStaircaseMap;
	}

	public static Map<String, String> getSorcererBossFightRoomMap() {
		return sorcererBossFightRoomMap;
	}

	public static void setSorcererBossFightRoomMap(Map<String, String> sorcererBossFightRoomMap) {
		RoomController.sorcererBossFightRoomMap = sorcererBossFightRoomMap;
	}

	public static Map<String, String> getStairsB1FMap() {
		return stairsB1FMap;
	}

	public static void setStairsB1FMap(Map<String, String> stairsB1FMap) {
		RoomController.stairsB1FMap = stairsB1FMap;
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

	public static Room_B getRoomB4() {
		return roomB4;
	}

	public static void setRoomB4(Room_B roomB4) {
		RoomController.roomB4 = roomB4;
	}

	public static Room_B getRoomB5() {
		return roomB5;
	}

	public static void setRoomB5(Room_B roomB5) {
		RoomController.roomB5 = roomB5;
	}

	public static Room_B getRoomD2() {
		return roomD2;
	}

	public static void setRoomD2(Room_B roomD2) {
		RoomController.roomD2 = roomD2;
	}

	public static Room_B getRoomD1() {
		return roomD1;
	}

	public static void setRoomD1(Room_B roomD1) {
		RoomController.roomD1 = roomD1;
	}

	public static Room_B getRoomD3() {
		return roomD3;
	}

	public static void setRoomD3(Room_B roomD3) {
		RoomController.roomD3 = roomD3;
	}

	public static Room_B getRoomE2() {
		return roomE2;
	}

	public static void setRoomE2(Room_B roomE2) {
		RoomController.roomE2 = roomE2;
	}

	public static Room_B getRoomE3() {
		return roomE3;
	}

	public static void setRoomE3(Room_B roomE3) {
		RoomController.roomE3 = roomE3;
	}

	public static Room_B getRoomC4() {
		return roomC4;
	}

	public static void setRoomC4(Room_B roomC4) {
		RoomController.roomC4 = roomC4;
	}

	public static Room_B getRoomC5() {
		return roomC5;
	}

	public static void setRoomC5(Room_B roomC5) {
		RoomController.roomC5 = roomC5;
	}

	public static Room_B getRoomD4() {
		return roomD4;
	}

	public static void setRoomD4(Room_B roomD4) {
		RoomController.roomD4 = roomD4;
	}

	public static Room_B getRoomD5() {
		return roomD5;
	}

	public static void setRoomD5(Room_B roomD5) {
		RoomController.roomD5 = roomD5;
	}

	public static Room_B getRoomE4() {
		return roomE4;
	}

	public static void setRoomE4(Room_B roomE4) {
		RoomController.roomE4 = roomE4;
	}

	public static Room_B getRoomA1() {
		return roomA1;
	}

	public static void setRoomA1(Room_B roomA1) {
		RoomController.roomA1 = roomA1;
	}

	public static Room_B getRoomE1() {
		return roomE1;
	}

	public static void setRoomE1(Room_B roomE1) {
		RoomController.roomE1 = roomE1;
	}

	public static Room_B getRoomA5() {
		return roomA5;
	}

	public static void setRoomA5(Room_B roomA5) {
		RoomController.roomA5 = roomA5;
	}

	public static Room_B getConnectingChamberRoom() {
		return connectingChamberRoom;
	}

	public static void setConnectingChamberRoom(Room_B connectingChamberRoom) {
		RoomController.connectingChamberRoom = connectingChamberRoom;
	}

	public static Room_B getSpiralStaircaseRoom() {
		return spiralStaircaseRoom;
	}

	public static void setSpiralStaircaseRoom(Room_B spiralStaircaseRoom) {
		RoomController.spiralStaircaseRoom = spiralStaircaseRoom;
	}

	public static Room_B getSorcererBossFightRoom() {
		return sorcererBossFightRoom;
	}

	public static void setSorcererBossFightRoom(Room_B sorcererBossFightRoom) {
		RoomController.sorcererBossFightRoom = sorcererBossFightRoom;
	}
    
	
	public static Room_B getRoomE5() {
		return roomE5;
	}

	public static void setRoomE5(Room_B roomE5) {
		RoomController.roomE5 = roomE5;
	}

	public static Room_B getEntranceChamberRoom() {
		return entranceChamberRoom;
	}

	public static void setEntranceChamberRoom(Room_B entranceChamberRoom) {
		RoomController.entranceChamberRoom = entranceChamberRoom;
	}

	public static Room_B getGuardLockedDoorRoom() {
		return guardLockedDoorRoom;
	}

	public static void setGuardLockedDoorRoom(Room_B guardLockedDoorRoom) {
		RoomController.guardLockedDoorRoom = guardLockedDoorRoom;
	}

	public static Room_B getNecromancerRoom() {
		return necromancerRoom;
	}

	public static void setNecromancerRoom(Room_B necromancerRoom) {
		RoomController.necromancerRoom = necromancerRoom;
	}

	public static Room_B getStairsB1FRoom() {
		return stairsB1FRoom;
	}
     
	public static void setStairsB1FRoom(Room_B stairsB1FRoom) {
		RoomController.stairsB1FRoom = stairsB1FRoom;
	}

	
	public String toString() {
		return "RoomController [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


	
	
   
}
