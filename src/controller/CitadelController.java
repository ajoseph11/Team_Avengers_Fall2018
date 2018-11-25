package controller;


public class CitadelController extends RoomController{
	@Override
	public String toString() {
		return "CitadelController [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

	public CitadelController() {
     super();
}
	
	public void setAllRoomDetails() {
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
