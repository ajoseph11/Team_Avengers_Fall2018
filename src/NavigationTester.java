import game_object.Navigation;
import game_object.Navigationn;
import game_object.Player;
import game_object.Room;
import game_object.Roomm;

public class NavigationTester {
	static Player player = new Player();
	public static void main(String [] args) {
		Navigationn navigationn = new Navigationn();
		Roomm roomm = new Roomm();
		player.setPlayerName("Elijah");
		player.setPlayerHealth(20);
		roomm.setRoomDesc("Description of room goes here");
		roomm.setAttackStat("being attakced...");
		roomm.setFloorTitle("Floor 1");
		roomm.setMonster("Very Big Monster");
		roomm.setRoomTitle("Room One");
		roomm.setTxtA("Text a goes here...");
		roomm.setRoomExits("Text b goes here...");
		roomm.setTxtC("Text c goes here...");
		
		
		
		navigationn.setRoomTitle(roomm.getRoomTitle());
		navigationn.setRoomm(roomm);
		navigationn.setFloorTitle(roomm.getFloorTitle());
		navigationn.setMonster(roomm.getMonster());
		navigationn.setPlayer(player);
		navigationn.setAttackStat(roomm.getAttackStat());
		navigationn.setPlayerHealth(player.getPlayerHealth());
		navigationn.setPlayerName(player.getPlayerName());
		navigationn.setRoomDesc(roomm.getRoomDesc());
	
	
	System.out.println(navigationn.toString());
	System.out.println(roomm.getRoomTitle());
	
}
	

	
}
