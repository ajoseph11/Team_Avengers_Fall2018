package game_object2;

import javafx.scene.control.Button;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameGUI extends Application {
	GuiController guiController;
	BorderPane mainPane;
	VBox leftPane, centerPane, rightPane;
	HBox topPane, bottomPane, hbUserInput;
	
	final private int guiHeight = 700; 
	final private int guiWidth = 1000; 

	
	private Label lbTop, lbRmDesc, lbUserResponse, lbHp, lbGem, lbWeapon, lbDirection, lbExit, lbIsPuzzle, lbIsMonster, LbIsItem, lbRiddle;
	private static TextField txtUserInput;
	private static Button btSubmitUserInput;
	
	private static String roomDesc;
	
	private String hP = "";
	private String gem = " ";
	private String weapon = " ";
	private static String direction, exits, errorMessage, userResponse,riddle, item, monster, userInput;
	private static boolean isPuzzle, isMonster, isItem;
    

	@Override
	public void start(Stage stage) throws Exception {
		txtUserInput = new TextField();

		
		btSubmitUserInput = new Button("Submit"); // submit button
		hbUserInput = new HBox(); // this Horizontal box houses the user input and the submit button associate with it
		guiController = new GuiController();
		guiController.referenceAllControllers();
		guiController.referenceDataFromGameGui();
		
	    //guiController.setSpecificDataAccordingToRoom();
		//guiController.linkDataBackToGui();// this has to be last method called . This happen when the data has been received upon button clicked.

		
		
		mainPane = new BorderPane();
		leftPane = new VBox();
		centerPane = new VBox();
		rightPane = new VBox();
		topPane = new HBox();
		bottomPane = new HBox();
		
		lbTop  = new Label("CITADEL OF STORMS");
		topPane.setAlignment(Pos.BASELINE_CENTER);
		topPane.getChildren().add(lbTop);
		
		
		
		
		//txtUserInput.setPrefRowCount(1);
		
		hbUserInput.getChildren().addAll(txtUserInput, btSubmitUserInput); // add useINput textfiled and its submit button to this hbox so you can display them together
		//HBox.setMargin(txtUserInput, new Insets(10));
		//HBox.setMargin(btSubmitUserInput, new Insets(10));
		hbUserInput.setSpacing(20);
		hbUserInput.setAlignment(Pos.BASELINE_LEFT);
		
		
		//exits = " ";
		//roomDesc = "hhhh";
		lbRmDesc = new Label("                                                 ROOM DESCRIPTION \n" + roomDesc);
		lbDirection = new Label("DIRECTION: Choose and type ONLY N, E, S, or W from the available room exits.");
		lbExit = new Label("Possible Exits: "  + exits);
		lbDirection.setWrapText(true);
		lbRmDesc.setMaxWidth(guiWidth - 200);
		lbRmDesc.setMinHeight(100);
		lbRmDesc.setWrapText(true);
		
		
		lbIsPuzzle = new Label("Puzzle? "+ isPuzzle);
		lbIsPuzzle.setMaxWidth(guiWidth - 200);
		//lbIsPuzzle.setMinHeight(100);
		lbIsPuzzle.setWrapText(true);
		lbIsMonster = new Label("Monster? "+ isMonster);
		lbIsMonster.setMaxWidth(guiWidth - 200);
		//lbIsMonster.setMinHeight(100);
		lbIsMonster.setWrapText(true);
		LbIsItem = new Label("Items? "+ isItem);
		LbIsItem.setMaxWidth(guiWidth - 200);
		//LbIsItem.setMinHeight(100);
		LbIsItem.setWrapText(true);
		centerPane.getChildren().addAll(lbRmDesc, lbExit, lbIsPuzzle, lbIsMonster, LbIsItem, lbDirection, hbUserInput);
		VBox.setMargin(lbRmDesc, new Insets(5));
		VBox.setMargin(lbExit, new Insets(5));
		VBox.setMargin(lbDirection, new Insets(5));
		VBox.setMargin(txtUserInput, new Insets(5));
		VBox.setMargin(lbIsMonster, new Insets(5));
		VBox.setMargin(lbIsPuzzle, new Insets(5));
		VBox.setMargin(LbIsItem, new Insets(5));
		
		//centerPane.setAlignment(Pos.BASELINE_CENTER);
		lbRiddle = new Label("Puzzle,Monster or Item"+ "\n" + riddle + monster + item );
		lbRiddle.setMaxWidth(guiWidth - 200);
		//lbRiddle.setMinHeight(100);
		lbRiddle.setWrapText(true);
		
		lbUserResponse = new Label("MESSAGE:" + "\n" + userResponse);
		lbUserResponse.setMaxWidth(guiWidth - 200);
		lbUserResponse.setMinHeight(100);
		lbUserResponse.setWrapText(true);
		bottomPane.getChildren().addAll(lbUserResponse);
		bottomPane.setAlignment(Pos.BASELINE_CENTER);
		BorderPane.setMargin(topPane, new Insets(10));
		BorderPane.setMargin(rightPane, new Insets(10));

		BorderPane.setMargin(bottomPane, new Insets(10));
		BorderPane.setMargin(leftPane, new Insets(10));
		BorderPane.setMargin(centerPane, new Insets(10));


   //Left Pane of the border Pane
		lbHp = new Label("HP:" + "\n" + hP);
		lbGem = new Label("GEM:" + "\n" + gem);
		lbWeapon = new Label("WEAPON:" + "\n" + weapon);
		leftPane.getChildren().addAll(lbHp, lbGem, lbWeapon);
		leftPane.setAlignment(Pos.BASELINE_CENTER);
		
		
		// These lines must come last
		mainPane.setTop(topPane);
		mainPane.setRight(rightPane);
		mainPane.setBottom(bottomPane);
		mainPane.setLeft(leftPane);
		mainPane.setCenter(centerPane);
		
		Scene scene = new Scene(mainPane, guiWidth, guiHeight);
		stage.setTitle("Citadel_of_Storms");
		stage.setScene(scene);

	   
		stage.show();


		
		
	}
	

	public static void main(String [] args) {
		Application.launch(args);
	}




	public BorderPane getMainPane() {
		return mainPane;
	}


	public void setMainPane(BorderPane mainPane) {
		this.mainPane = mainPane;
	}


	public VBox getLeftPane() {
		return leftPane;
	}


	public void setLeftPane(VBox leftPane) {
		this.leftPane = leftPane;
	}


	public VBox getCenterPane() {
		return centerPane;
	}


	public void setCenterPane(VBox centerPane) {
		this.centerPane = centerPane;
	}


	public VBox getRightPane() {
		return rightPane;
	}


	public void setRightPane(VBox rightPane) {
		this.rightPane = rightPane;
	}


	public HBox getTopPane() {
		return topPane;
	}


	public void setTopPane(HBox topPane) {
		this.topPane = topPane;
	}


	public HBox getBottomPane() {
		return bottomPane;
	}


	public void setBottomPane(HBox bottomPane) {
		this.bottomPane = bottomPane;
	}


	public HBox getHbUserInput() {
		return hbUserInput;
	}


	public void setHbUserInput(HBox hbUserInput) {
		this.hbUserInput = hbUserInput;
	}


	public Label getLbTop() {
		return lbTop;
	}


	public void setLbTop(Label lbTop) {
		this.lbTop = lbTop;
	}


	public Label getLbRmDesc() {
		return lbRmDesc;
	}


	public void setLbRmDesc(Label lbRmDesc) {
		this.lbRmDesc = lbRmDesc;
	}


	public Label getLbUserResponse() {
		return lbUserResponse;
	}


	public void setLbUserResponse(Label lbUserResponse) {
		this.lbUserResponse = lbUserResponse;
	}


	public Label getLbHp() {
		return lbHp;
	}


	public void setLbHp(Label lbHp) {
		this.lbHp = lbHp;
	}


	public Label getLbGem() {
		return lbGem;
	}


	public void setLbGem(Label lbGem) {
		this.lbGem = lbGem;
	}


	public Label getLbWeapon() {
		return lbWeapon;
	}


	public void setLbWeapon(Label lbWeapon) {
		this.lbWeapon = lbWeapon;
	}


	public Label getLbDirection() {
		return lbDirection;
	}


	public void setLbDirection(Label lbDirection) {
		this.lbDirection = lbDirection;
	}


	public Label getLbExit() {
		return lbExit;
	}


	public void setLbExit(Label lbExit) {
		this.lbExit = lbExit;
	}


	public Label getLbIsPuzzle() {
		return lbIsPuzzle;
	}


	public void setLbIsPuzzle(Label lbIsPuzzle) {
		this.lbIsPuzzle = lbIsPuzzle;
	}


	public Label getLbIsMonster() {
		return lbIsMonster;
	}


	public void setLbIsMonster(Label lbIsMonster) {
		this.lbIsMonster = lbIsMonster;
	}


	public Label getLbIsItem() {
		return LbIsItem;
	}


	public void setLbIsItem(Label lbIsItem) {
		LbIsItem = lbIsItem;
	}


	public Label getLbRiddle() {
		return lbRiddle;
	}


	public void setLbRiddle(Label lbRiddle) {
		this.lbRiddle = lbRiddle;
	}


	public static TextField getTxtUserInput() {
		return txtUserInput;
	}


	public void setTxtUserInput(TextField txtUserInput) {
		GameGUI.txtUserInput = txtUserInput;
	}


	public static Button getBtSubmitUserInput() {
		return btSubmitUserInput;
	}


	public void setBtSubmitUserInput(Button btSubmitUserInput) {
		GameGUI.btSubmitUserInput = btSubmitUserInput;
	}


	public static String getRoomDesc() {
		return roomDesc;
	}


	public void setRoomDesc(String roomDesc) {
		GameGUI.roomDesc = roomDesc;
	}


	public String gethP() {
		return hP;
	}


	public void sethP(String hP) {
		this.hP = hP;
	}


	public String getGem() {
		return gem;
	}


	public void setGem(String gem) {
		this.gem = gem;
	}


	public String getWeapon() {
		return weapon;
	}


	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}


	public static String getDirection() {
		return direction;
	}


	public static void setDirection(String direction) {
		GameGUI.direction = direction;
	}


	public static String getExits() {
		return exits;
	}


	public void setExits(String exits) {
		GameGUI.exits = exits;
	}


	public static String getErrorMessage() {
		return errorMessage;
	}


	public static void setErrorMessage(String errorMessage) {
		GameGUI.errorMessage = errorMessage;
	}


	public static String getUserResponse() {
		return userResponse;
	}


	public void setUserResponse(String userResponse) {
		GameGUI.userResponse = userResponse;
	}


	public static String getRiddle() {
		return riddle;
	}


	public static void setRiddle(String riddle) {
		GameGUI.riddle = riddle;
	}


	public static String getItem() {
		return item;
	}


	public static void setItem(String item) {
		GameGUI.item = item;
	}


	public static String getMonster() {
		return monster;
	}


	public static void setMonster(String monster) {
		GameGUI.monster = monster;
	}


	public static String getUserInput() {
		return userInput;
	}


	public static void setUserInput(String userInput) {
		GameGUI.userInput = userInput;
	}


	public static boolean isPuzzle() {
		return isPuzzle;
	}


	public static void setPuzzle(boolean isPuzzle) {
		GameGUI.isPuzzle = isPuzzle;
	}


	public static boolean isMonster() {
		return isMonster;
	}


	public static void setMonster(boolean isMonster) {
		GameGUI.isMonster = isMonster;
	}


	public static boolean isItem() {
		return isItem;
	}


	public static void setItem(boolean isItem) {
		GameGUI.isItem = isItem;
	}


	public int getGuiHeight() {
		return guiHeight;
	}


	public int getGuiWidth() {
		return guiWidth;
	}





	//Setters and getters for all GUI fields.
	
	
}
