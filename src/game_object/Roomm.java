package game_object;


public class Roomm{
	protected String roomTitle;
	private String floorTitle;
	private String roomDesc;
	private String monster;
	private String attackStat;
	private String roomItem;
	private String roomExits;
	private String txtC;
	
	
	public Roomm() {
		
	}


	public Roomm(String roomTitle, String floorTitle, String roomDesc, String monster, String attackStat, String roomItem,
			String txtB, String txtC) {
		super();
		this.roomTitle = roomTitle;
		this.floorTitle = floorTitle;
		this.roomDesc = roomDesc;
		this.monster = monster;
		this.attackStat = attackStat;
		this.roomItem = roomItem;
		this.roomExits = txtB;
		this.txtC = txtC;
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


	public String getRoomItem() {
		return roomItem;
	}


	public void setRoomItem(String romItem) {
		this.roomItem = roomItem;
	}


	public String getRoomExits() {
		return roomExits;
	}


	public void setRoomExits(String txtB) {
		this.roomExits = txtB;
	}


	public String getTxtC() {
		return txtC;
	}


	public void setTxtC(String txtC) {
		this.txtC = txtC;
	}
	
	public String toString() {
		return "Room Object";
	}
	
}