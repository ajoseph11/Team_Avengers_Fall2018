package game_object;

public class Navigationn extends Roomm {
	private String roomTitle,  floorTitle,  roomDesc,  monster,  attackStat, txtA, txtB,  txtC;
	private String playerName;
	private int playerHealth;
	private Roomm roomm = new Roomm(roomTitle, floorTitle, roomDesc, monster, attackStat, txtA, txtB, txtC);
    private Player player = new Player(playerName, playerHealth);


	
	
	
	public Navigationn() {
		
	}

	public Navigationn(Roomm roomm, Player player, String roomTitle, String floorTitle, String roomDesc, String monster,
			String attackStat, String txtA, String txtB, String txtC, String playerName, int playerHealth) {
		super();
		this.roomm = roomm;
		this.player = player;
		roomm.roomTitle = roomTitle;
		this.floorTitle = floorTitle;
		this.roomDesc = roomDesc;
		this.monster = monster;
		this.attackStat = attackStat;
		this.txtA = txtA;
		this.txtB = txtB;
		this.txtC = txtC;
		this.playerName = playerName;
		this.playerHealth = playerHealth;
	}

	public Roomm getRoomm() {
		return roomm;
	}

	public void setRoomm(Roomm roomm) {
		this.roomm = roomm;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getRoomTitle() {
		return roomTitle;
	}

	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}

	public String getFloorTitle() {
		return floorTitle;
	}

	public void setFloorTitle(String floorTitle) {
		this.floorTitle = floorTitle;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public String getMonster() {
		return monster;
	}

	public void setMonster(String monster) {
		this.monster = monster;
	}

	public String getAttackStat() {
		return attackStat;
	}

	public void setAttackStat(String attackStat) {
		this.attackStat = attackStat;
	}

	public String getTxtA() {
		return txtA;
	}

	public void setTxtA(String txtA) {
		this.txtA = txtA;
	}

	public String getTxtB() {
		return txtB;
	}

	public void setTxtB(String txtB) {
		this.txtB = txtB;
	}

	public String getTxtC() {
		return txtC;
	}

	public void setTxtC(String txtC) {
		this.txtC = txtC;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerHealth() {
		return playerHealth;
	}

	public void setPlayerHealth(int playerHealth) {
		this.playerHealth = playerHealth;
	}

	@Override
	public String toString() {
		return "Navigationn [roomTitle=" + roomTitle + ", floorTitle=" + floorTitle + ", roomDesc=" + roomDesc
				+ ", monster=" + monster + ", attackStat=" + attackStat + ", txtA=" + txtA + ", txtB=" + txtB
				+ ", txtC=" + txtC + ", playerName=" + playerName + ", playerHealth=" + playerHealth + ", roomm="
				+ roomm + ", player=" + player + "]";
	}
	
	
	
	

	
	
	

	
	
	
}
