package controller;

import java.io.IOException;

import model.Monster;
/*This used to be the Ruuner class*/
public class GameController {

	public static void main(String[] args) throws Exception { //throw Exception incase something goes wrong while reading from file.
		// TODO Auto-generated method stub
		ItemController.setItemFromText();//This gets item from text, store in map and relates to item object
		RoomController.setRoomFromText();//This gets rooms from text, store in map and relates to rooms object
		PuzzleController.setPuzzleFromText();//This gets puzzles  from text, store in map and relates to puzzle object
		MonsterController.setMonsterFromText();//This gets monsters  from text, store in map and relates to monster object

		
		// STesting all the Controller classes to make sure the text hava been properly passd and read
   System.out.println(ItemController.itema4);
   System.out.println(RoomController.roomA5);
   System.out.println(PuzzleController.puzzleR7);
  
   System.out.println(MonsterController.m4Monster);
   
  // System.out.println(Integer.parseInt(MonsterController.m3Monster.getMonsterMap().get("ValueLoss")) + 2);

	}

}
