package game_object2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class Runner {

 

    public static void main(String [] args){
	
    
	
	
	//test Puzzle object andn values from PuzzleController class.
	try {
		PuzzleController.setPuzzleFromText();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		String errorMessage = "Error writing from file : Puzzle.txt";
		e.printStackTrace();
		System.out.println(errorMessage);
		
	}
	System.out.println("From: " + PuzzleController.class.getName());
	System.out.println(PuzzleController.getPuzzleR8().getPuzzleMap().get("Riddle"));
	System.out.println(PuzzleController.getPuzzleR1().getPuzzleMap());
    
	

	//test Room object andn values from PuzzleController class.
	try {
		RoomController.setPuzzleFromText();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		String errorMessage = "Error writing from file : Puzzle.txt";
		e.printStackTrace();
		System.out.println(errorMessage);
		
	}
	System.out.println("From: " + RoomController.class.getName());
	//System.out.println(RoomController.getRoomB3().getRoomMap().get("Riddle"));
	//System.out.println(RoomController.getRoomB3().getRoomMap());
	//System.out.println(RoomController.getRoomA2().toString());
	System.out.println(RoomController.a2Map);
	System.out.println(RoomController.b1Map);

		
	
	
    }
	
}




