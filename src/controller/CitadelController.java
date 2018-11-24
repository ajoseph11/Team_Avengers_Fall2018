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
		entranceChamberRoom.setId(entranceChamberRoom.getId());
		entranceChamberRoom.setType(entranceChamberRoom.getType());
		entranceChamberRoom.setItem(entranceChamberRoom.getItem());
		entranceChamberRoom.setMonster(entranceChamberRoom.getMonster());
		entranceChamberRoom.setPuzzle(entranceChamberRoom.getPuzzle());
		entranceChamberRoom.setDescription(entranceChamberRoom.getDescription());
		entranceChamberRoom.setExit(entranceChamberRoom.getExit());
		
		//connectingChamberRoom.setPuzzle(PuzzleController.r8Map.get("Answer"));
	
	}
	
	
	

	
	
}
