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
	
	public static String errorMessage;

	public static Room_B roomA2;
	public static Room_B roomB1;
	public static Room_B roomB2;
	public static Room_B roomC1;
	public static Room_B roomC2;
	public static Room_B roomA3;
	public static Room_B roomA4;
	public static Room_B roomB3;





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
						if ((currentLine >= 1) && (currentLine <= 4)) {
								a2Map.put(key, value);
						}
						if ((currentLine >= 6) && (currentLine <= 9)) {
							b1Map.put(key, value);
					   }
						//set the current map as the value for each puzzle Map object
						
						roomA2.setRoomeMap(a2Map);
						
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
