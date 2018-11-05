package model;


public class Player {
	private String firstName;
	private String lastName;
	private String playerUserName;
	private String PlayerHP;
	
	
	
	public Player() {
		super();
	}
	public Player(String firstName, String lastName, String playerUserName, String playerHP) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.playerUserName = playerUserName;
		PlayerHP = playerHP;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPlayerUserName() {
		return playerUserName;
	}
	public void setPlayerUserName(String playerUserName) {
		this.playerUserName = playerUserName;
	}
	public String getPlayerHP() {
		return PlayerHP;
	}
	public void setPlayerHP(String playerHP) {
		PlayerHP = playerHP;
	}
	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", lastName=" + lastName + ", playerUserName=" + playerUserName
				+ ", PlayerHP=" + PlayerHP + "]";
	}

	
	

}
