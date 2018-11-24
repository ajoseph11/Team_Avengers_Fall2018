package view;
import java.io.IOException;

import controller.*;

import controller.ItemController;
import controller.MonsterController;
import controller.PuzzleController;
import controller.RoomController;

public class GuiController  {
	
	
	
	GameGUI gameGUI = new GameGUI();
	public  void setGameData() throws IOException {
    RoomController.setRoomFromText();
    gameGUI.setRoomDesc(RoomController.roomA2.getDescription());
    gameGUI.setExit(RoomController.roomA2.getExit());
    gameGUI.setRiddle(PuzzleController.getPuzzleR8().getRiddle());
    gameGUI.setMonster(RoomController.getRoomA2().getMonster());
    gameGUI.setItems(RoomController.getRoomA2().getItem());
    gameGUI.setUserResponse("Ther is anerrir in ");
	}
	

}
