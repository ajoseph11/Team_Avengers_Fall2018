package controller;



import java.io.File;
import java.io.IOException;

public class CitadelController extends RoomController{
	

	public CitadelController() {
     super();
}



    public void setAllRoomDetails() throws IOException {
		RoomController.setRoomFromText(); // This set the model Room ready with all the data needed on the GUI
  		PuzzleController.setPuzzleFromText(); // this sets the model Puzzle ready with all the data needed on the GUI
  		ItemController.setItemFromText(); // this sets the model Item readt for all the data needed for the GUI(view) to
  											// run
  		MonsterController.setMonsterFromText(); // this sets all the data needed for the model Monster
    	  
		
		RoomController.entranceChamberRoom.setId(entranceChamberRoom.getId());
		RoomController.entranceChamberRoom.setType(entranceChamberRoom.getType());
		RoomController.entranceChamberRoom.setItem(entranceChamberRoom.getItem());
		RoomController.entranceChamberRoom.setMonster(entranceChamberRoom.getMonster());
		RoomController.entranceChamberRoom.setPuzzle(entranceChamberRoom.getPuzzle());
		RoomController.entranceChamberRoom.setDescription(entranceChamberRoom.getDescription());
		RoomController.entranceChamberRoom.setExit(entranceChamberRoom.getExit());
		
		//connectingChamberRoom.setPuzzle(PuzzleController.r8Map.get("Answer"));




		}
	}
	
	
	


