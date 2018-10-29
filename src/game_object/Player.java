package game_object;

import java.util.Queue;
import java.util.Stack;

public class Player {
	
	Stack queue = new Stack<>();
 private String playerName;
 private int playerHealth;
 
 public Player(String playerName, int playerHealth) {
 this.playerName = playerName;
 this.playerHealth = playerHealth;
	 
	
}
 
 
 public Player() {//default constructor
	// TODO Auto-generated constructor stub
}


public void setPlayerName(String playerName) {
	 this.playerName = playerName;
 }
 
 public String getPlayerName() {
	 return this.playerName;
 }
 
 
 public void setPlayerHealth(int playerHealth) {
	 this.playerHealth = playerHealth;
 }
 
 public int getPlayerHealth() {
	 return this.playerHealth;
 }
 
 public String toString() {
		return "Player Object";
	}
}
