package game_object2;

import java.util.HashMap;
import java.util.Map;

//class to hold information about each room
public class Room {
    private String roomType;
    private String description;
    private String puzzle;

    //key: the direction of the exit
    //value: the room to go to
    private HashMap<String, String> exits;

    //setters & getters
    public void setRoomType(String rType) {
        roomType = rType;
    }

    public void setDescription(String desc) {
        description = desc;
    }

    public void setPuzzle(String puzz) {
        puzzle = puzz;
    }

    public String getDescription() {
        return description;
    }

    public void setExits(String exitStr) {
        exits = new HashMap<>();

        //split by - first
        String[] exitsText = exitStr.split("-");

        //each exit must be submitted to our hash map
        for (int i = 0; i < exitsText.length - 1; i++) {
            int lastSpace = exitsText[i].lastIndexOf(" ");
            String direction = exitsText[i];
            if (lastSpace >= 0) {
                direction = exitsText[i].substring(lastSpace).trim();
            }
            lastSpace = exitsText[i+1].lastIndexOf(" ");
            String room = exitsText[i+1];
            if (lastSpace >= 0) {
                room = exitsText[i + 1].substring(0, lastSpace).trim();
            }

            //key is first, value second
            exits.put(direction, room);
        }
    }

	public HashMap<String, String> getExits() {
		// TODO Auto-generated method stub
		return exits;
	}

   
}
