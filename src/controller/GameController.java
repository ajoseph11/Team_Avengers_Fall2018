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

		
		// System.out.println(ItemController.getItemW1().getItemID());
   //System.out.println(ItemController.getItemW1().getItemMap());
   //System.out.println(ItemController.getItemW2().getItemMap());
   //PuzzleController.setPuzzleFromText();
   //System.out.println(ItemController.itemW2);
   //System.out.println(ItemController.getItemk11());
   System.out.println(MonsterController.m4Monster);
   
  // System.out.println(Integer.parseInt(MonsterController.m3Monster.getMonsterMap().get("ValueLoss")) + 2);

	}

}
