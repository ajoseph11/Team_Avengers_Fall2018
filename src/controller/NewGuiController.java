package controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;

import org.omg.PortableServer.POAPackage.WrongAdapter;

import com.sun.corba.se.impl.orb.ParserTable.TestAcceptor1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.stage.Stage;
import view.NewGui;

public class NewGuiController {
	//
	CitadelController citadelController; //Master controller for the game
	
	//Selections for users to interact with the game
	String [] userOptions = {"N", "E", "S", "W", "I", "P", "M", "U", "D", "H", "PK", "F", "SV"};
	int iUserOption = -1;// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 12; for each of  the above values we are adding 1 to their index
	private ArrayList< String> inventory;

	
   private int currentRoom;
   private Stage stage; //create a stage that references the gui stage when the game is run
   private Scene gameScene; //create a scene that references the GUI scene whenever the game is run.
	
	
	//set all variables for the instance of GUi inside the controller
	private int guiHeight;
	private int guiWidth;

	private BorderPane borderPane;
	private VBox leftPane, centerPane, rightPane;
	private HBox topPane, bottomPane, hbUserInput;
	//other modes in the gui

	private Label lbTop, lbRmDesc, lbUserResponse, lbHp, lbGem, lbWeapon, lbInstruction, lbDirection, lbExit, lbIsPuzzle, lbIsMonster, LbIsItem, lbRiddle, lbPuzzle, lbMonster, lbItem;
	private TextField txtUserInput;
	private  Button btSubmitUserInput;
	
	private  String roomDesc;
	
	private int hP;
	private int gem;
	private String weapon = " ";
	private String exits,  passwordError, userNameError,  userName, password, userResponse,riddle, item, monster, userInput, riddleAnswer, hint, instruction;
	private boolean isPuzzle, isMonster, isItem;

	protected Node hbBottom;

	private Label lbHint;

	private Button btInstructions;

	private Button btCloseInstruction;

	private Button btMap;

	private Button btCloseMap;

	private Button btnLogin;

	private Button btnNewUser;

	private TextField tfUserName;

	private PasswordField tfPassword;

	private Label lblMessages;

	private GridPane gridPane;

	private Label lblPassword;

	private Label lblMessage;

	private Label lblUserName;

	private Label lbInventory;
	
	
	public NewGuiController() {
		citadelController = new CitadelController(); //master controller for the game
		
		stage = NewGui.getStage(); //static getter reference to the GUI
		gameScene = NewGui.getScene(); //static getter reference to the GUI
		
		userResponse = ""; //empty message at the beginning of game
		
		
		guiHeight = 800;
		guiWidth = 1000;
		
		borderPane = new BorderPane();
		leftPane = new VBox();
	
		leftPane.getStyleClass().add("vbox");//apply style from css to this vbox
		centerPane = new VBox();
		centerPane.getStyleClass().add("vbox");
		centerPane.getStyleClass().add("gamePane");
		rightPane = new VBox();
		rightPane.getStyleClass().add("rightPane");
		rightPane.getStyleClass().add("vbox");
		topPane = new HBox();
		topPane.getStyleClass().add("topPane");
		topPane.getStyleClass().add("hbox");
		hbUserInput = new HBox();
		bottomPane = new HBox();
		bottomPane.getStyleClass().addAll("hbox", "bottomPane");
		// set the right node into the borderPane
		borderPane.setTop(topPane);
		borderPane.setRight(rightPane);
		borderPane.setBottom(bottomPane);
		borderPane.setLeft(leftPane);
		borderPane.setCenter(centerPane);
		
		//Align nodes
		BorderPane.setMargin(topPane, new Insets(5));
		BorderPane.setMargin(rightPane, new Insets(5));

		BorderPane.setMargin(bottomPane, new Insets(5));
		BorderPane.setMargin(leftPane, new Insets(5));
		BorderPane.setMargin(centerPane, new Insets(5));

	}
	
	public void setNodesForGui() {
		
		
	  //  guiInstance.setTitle("ttttt");
		
		
		
	}
	
	public void setSceneAndStageForGUI() {
	
		
		setRoomDetails();
		setLeftPane();
		setTopPane();
		setCenterPane();
	
		setRightPane();
		setBottomPane();
		
		
		gameScene = new Scene(borderPane, guiWidth, guiHeight);
		gameScene.getStylesheets().addAll("css/gameControllerStyle.css", "css/loginStyle.css");
		stage.setTitle("Citadel--Of--Storms");
		stage.setResizable(false);
		if (iUserOption == -1 ) { //initial value is -1 so run login scene first and so  somrthing when button is clicked
			stage.setScene(getLoginScene()); // return login scene and change state to show new scene after clickinglogin
			btnLogin.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					userName = tfUserName.getText();
					password = tfPassword.getText();
					//check for username and password match
					if (userName.equals("player") && password.equals("game")) {
					iUserOption = 0; // get room 1 details ready
					setRoomDetails();
					leftPane.getChildren().clear();
					rightPane.getChildren().clear();
					centerPane.getChildren().clear();
					bottomPane.getChildren().clear();topPane.getChildren().clear();
					setLeftPane();
					setTopPane();
					setCenterPane();
					setRightPane();
					setBottomPane();
					stage.setScene(gameScene); // set game scene starting with room 1 details
					getUserInputFromTextField();
					}
	else {
					
		if (isWrongPassword() || isWrongUserName()) {
			passwordError = "";
			userNameError  = "Wrong details";
			tfUserName.setText(userNameError);
			tfPassword.setText(passwordError);
            getUserInputFromTextField();
		}
		
		
	                 //   setSceneAndStageForGUI();
					}
				
					
					
					
				}
			});
			
			btnNewUser.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					
				}
			});
		}
	
	
		
	}
	
	public void setRightPane() {
		Label lbMap = new Label(" CLICK BELOW TO VIEW GAME");
		
		instruction = 
				"1.*ENTER YOUR INPUT CHOICE AND SUBMIT*\n"
				+ "2.Type only one charater for NAVIGATION\n"
				+ "N = North, E = East, S = South , W = West\n"
				+ "U = Up, D = Down, P = Puzzle, H = Hint\n"
				+ "I = Item, L = Monster\n, PK = Pick Item"
				+ "3.Multiple characters are allowed when\n"
				+ "dealing with PUZZLE, MONSTER, or ITEMS\n"
				
				;
		
		
		HBox hbMapPane = new HBox();
		btMap = new Button("View-Map");
		btCloseMap = new Button("X");
		hbMapPane.getChildren().addAll(btMap, btCloseMap);
		lbInstruction = new Label("GAME INSTRUCTIONS: \n" + instruction);
		lbDirection.setWrapText(true);
		lbInstruction.setMaxWidth(600);
		
		lbInstruction.setPadding(new Insets(5));
		rightPane.getChildren().addAll(lbMap, hbMapPane, lbInstruction);
		showAndHideMap(); //collapse right pane and show map instead
		
	}
	
	public void showAndHideMap() {
		btMap.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				leftPane.getChildren().clear();
				
				Image mapImage = new Image(getClass().getResourceAsStream("../image/map.jpeg")); //  get map image and display accordingly
				ScrollPane spMapPane = new ScrollPane();
				spMapPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
				spMapPane.setMinWidth(500);
				spMapPane.setContent(new ImageView(mapImage));
				
				leftPane.getChildren().clear();
				leftPane.getChildren().add(spMapPane);
				
			}
		});
		
		btCloseMap.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				leftPane.getChildren().clear();
				//leftPane.getChildren().addAll(lbHp, lbGem, lbWeapon);
				
				setLeftPane();
				
			}
		});
	}
	
	public void showOrCloseInstructions() {
		rightPane.getChildren().clear(); // CLEAR THE INSTRUCTION INITIALLY BUT OPENIT IF USER WANTS TO.

		btInstructions.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				rightPane.getChildren().clear(); // CLEAR THE INSTRUCTION INITIALLY BUT OPENIT IF USER WANTS TO.

				setRightPane();
				
			}
		});
		
		btCloseInstruction.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				rightPane.getChildren().clear();
				
			}
		});
	}
	
    
	public void setCenterPane() {
		setUserInputPane();
		lbRmDesc = new Label("ROOM DESCRIPTION \n" + roomDesc);
		lbDirection = new Label("DIRECTION: Choose and type ONLY one character. Example: N, E, S, or W from the available room exits. Otherwise, only the first character will be considered!!!\nNOTE: When any of item, puzzle, or monster is true(present), multiple characters are acceptable.");
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
		
		
		
		
		
		//MArgin around children items
		VBox.setMargin(lbRmDesc, new Insets(5));
		VBox.setMargin(lbExit, new Insets(5));
		VBox.setMargin(lbDirection, new Insets(5));
		VBox.setMargin(txtUserInput, new Insets(5));
		VBox.setMargin(lbIsMonster, new Insets(5));
		VBox.setMargin(lbIsPuzzle, new Insets(5));
		VBox.setMargin(LbIsItem, new Insets(5));
	}
	public void setLeftPane() {
		hP = 20;
		gem = 50;
		weapon  = "";
		//inventory.add("");
		lbHp = new Label("HP: " + hP);
		lbGem = new Label("GEM:" + gem);
		lbWeapon = new Label("WEAPON:"  + weapon);
		lbInventory = new Label("INVENTORY:" + inventory  );
				

		leftPane.getChildren().addAll(lbHp, lbGem, lbWeapon, lbInventory);
		leftPane.setAlignment(Pos.BASELINE_LEFT);
		VBox.setMargin(lbHp, new Insets(5));
		VBox.setMargin(lbGem, new Insets(5));
		VBox.setMargin(lbWeapon, new Insets(5));
		VBox.setMargin(lbInventory, new Insets(5));
		
		
}
	
	public void setTopPane() {
		lbTop  = new Label("CITADEL OF STORMS");
		topPane.setAlignment(Pos.BASELINE_CENTER);
		topPane.getChildren().add(lbTop);
	}
	
	public void setBottomPane() {
		Button btSave = new Button("Save-Game");
		//Button btPause = new Button("Pause-Game");
		Button btResume = new Button("Resume-Game");
		
		
		VBox  vbInteract = new VBox();
		//////vbInteract.setSpacing(10);
		vbInteract.getChildren().addAll(btSave, btResume);
		vbInteract.setAlignment(Pos.BASELINE_LEFT);
		
		VBox.setMargin(btSave, new Insets(0, 0, 10, 0));
		//VBox.setMargin(btPause, new Insets(0, 0, 10, 0));
		VBox.setMargin(btResume, new Insets(0, 0, 10, 0));
		
		btInstructions = new Button("Instructions");
		btCloseInstruction = new Button("X");
		btInstructions.getStyleClass().add("buttonB");
		btCloseInstruction.getStyleClass().add("buttonB");
		
		//userResponse = "";
		lbUserResponse = new Label("GAME-MESSAGE" + "\n" + userResponse);
		//lbUserResponse.setMaxWidth(guiWidth - 200);
		//lbUserResponse.setMinHeight(50);
		lbUserResponse.setWrapText(true);
		lbUserResponse.setAlignment(Pos.BASELINE_LEFT);
		HBox hbBottom = new HBox();
		hbBottom.setAlignment(Pos.BASELINE_RIGHT);
		hbBottom.setSpacing(10);
		hbBottom.getChildren().addAll(vbInteract ,lbUserResponse, btInstructions, btCloseInstruction);
		bottomPane.getChildren().addAll(hbBottom);
		bottomPane.setAlignment(Pos.BASELINE_CENTER);
		bottomPane.setMinHeight(165);
		HBox.setMargin(lbUserResponse, new Insets(0, 10, 0, 0));
		HBox.setMargin(hbBottom, new Insets(0, 0, 0, 10));
		showOrCloseInstructions(); //CHECK TO SEE IF THEY WANT TO VIEW INSTRUCTIONS OR NOT;
	}
	
	public void setUserInputPane() {
		txtUserInput = new TextField();
		txtUserInput.setMaxWidth(5000);
		txtUserInput.setPromptText("Your Choice");
		btSubmitUserInput = new Button("Submit"); // submit button
		hbUserInput = new HBox(); // this Horizontal box houses the user input and the submit button associate with it
		hbUserInput.getChildren().addAll(txtUserInput, btSubmitUserInput); // add useINput textfiled and its submit button to this hbox so you can display them together
		
		hbUserInput.setSpacing(20);
		hbUserInput.setAlignment(Pos.BASELINE_LEFT);
		
		
		
	}
	
	public void addMonsterDetails() {
		lbMonster = new Label("MONSTER:" + "\n" + monster);
		centerPane.getChildren().clear();
		centerPane.getChildren().addAll(lbRmDesc, lbExit, lbIsPuzzle, lbIsMonster, LbIsItem, lbDirection, hbUserInput, lbMonster);

	}
	public void addItemDetails() {
		lbItem = new Label("ITEM:" + "\n" + item);
		lbItem.setWrapText(true);
		centerPane.getChildren().clear();
		centerPane.getChildren().addAll(lbRmDesc, lbExit, lbIsPuzzle, lbIsMonster, LbIsItem, lbDirection, hbUserInput, lbItem);

	}
	
	public void addPuzzleDetails() {
		lbPuzzle = new Label("PUZZLE:" + "\n" + riddle);
		lbPuzzle.setWrapText(true);
		centerPane.getChildren().clear();
		centerPane.getChildren().addAll(lbRmDesc, lbExit, lbIsPuzzle, lbIsMonster, LbIsItem, lbDirection, hbUserInput, lbPuzzle);

	}
	
	public void addPuzzleHint() {
		lbHint = new Label("HINT:" + "\n" + hint);
		lbHint.setWrapText(true);
		centerPane.getChildren().clear();
		centerPane.getChildren().addAll(lbRmDesc, lbExit, lbIsPuzzle, lbIsMonster, LbIsItem, lbDirection, hbUserInput, lbHint);

	}
   
   
      public void validateUserInput() {
    	 
		
		
			if (userInput.equals("N")) {

				iUserOption = 1;
				
			}
			if (userInput.equals("E")) {

				iUserOption = 2;
			}
			if (userInput.equals("S")) {

				iUserOption = 3;
			}
			if (userInput.equals("W")) {

				iUserOption = 4;
			}
			if (userInput.equals("I")) {

				iUserOption = 5;
			}
			if (userInput.equals("P")) {

				iUserOption = 6;
			}
			if (userInput.equals("M")) {

				iUserOption = 7;
			}
			if (userInput.equals("U")) {

				iUserOption = 8;
			}
			if (userInput.equals("D")) {

				iUserOption = 9;
			}
			if (userInput.equals("H")) {

				iUserOption = 10;
			}
			if (userInput.equals("PK")) {

				iUserOption = 11;
			}
			if (userInput.equals("FI")) {

				iUserOption = 12;
			}
			if (userInput.equals("SV")) {
				iUserOption = 13;
			}
		
		
		
	}
      
      public void getUserInputFromTextField() {
  		
    		 btSubmitUserInput.setOnAction(new EventHandler<ActionEvent>() {
    			 
    	@Override
    	    public void handle(ActionEvent e) {
    	        if ((txtUserInput.getText() != null && !txtUserInput.getText().isEmpty())) {
    	        	
    	           userInput = txtUserInput.getText().toUpperCase();
    	           if (userInput.length() > 1 && (!isItem && !isPuzzle && !isMonster)) { //cut the user input back to 1 if more than one
    	        	   userInput = userInput.substring(0, 1);
    	        	   
    	        	
    	        	 
    	           }
    	           else {
        	           userInput = txtUserInput.getText().toUpperCase();

    	           }
    	           validateUserInput();//check what they entered
    	            txtUserInput.setText(userInput); //print it back to them on the textfield
    	           
    	            setRoomDetails(); // set new room details
    	            //checkPuzzleAnswers();//check answer and give response back
    	    	           
    	        } else {
    	        	userInput = "No input";
    	        	userResponse = userInput;
    	        	bottomPane.getChildren().clear();
    	        	
    	        	setBottomPane();
    	        
    	        }
    	        
    	        System.out.println(userInput);
    			System.out.println(userInput + " is user input & " + iUserOption + " is button clicked value");
    			txtUserInput.setText(userInput);
    			showItemPuzzleMonster();
    	      
    	     }

    	 });
    		 

    		
    			
    		}
      
      public void showItemPuzzleMonster() {
    		
    		if (iUserOption == 5 && isItem != false) { //add Item if I is entered
				addItemDetails();
				leftPane.getChildren().clear();
			}
    		if (iUserOption == 5 && isItem == false){
    			bottomPane.getChildren().clear();
    			userResponse = "There are no items in this room";
    			
    			setBottomPane();
    		}
			if (iUserOption == 6 && isPuzzle != false) { //add puzzle if P is entered
				addPuzzleDetails();
				checkPuzzleAnswers();
			}
			if (iUserOption == 6 && isPuzzle == false)  {
				bottomPane.getChildren().clear();
				userResponse = "There are no puzzles in this room";

				setBottomPane();
			}
	        if (iUserOption == 7 && isMonster != false) { // add moster if M is entered
	        	addMonsterDetails();
	     	        }
	        if (iUserOption == 7 && isMonster == false)  {
	        	bottomPane.getChildren().clear();
	        	userResponse = "There are no monsters in this room";
	        	setBottomPane();
	        }
	        if (iUserOption == 10 && isPuzzle != false)  {
	        	addPuzzleHint();
	        	checkPuzzleAnswers();
	        }
      }
      
      public void referenceAllControllers() throws IOException {
  		citadelController.setAllRoomDetails();
  	}
      
      public void setRoomDetails() {
    	  try {
			referenceAllControllers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 //i copied from  here
    		   switch (iUserOption) {
    		  
			case 0: // beginning room for the game
				
				centerPane.getChildren().clear();
				leftPane.getChildren().clear();
				bottomPane.getChildren().clear();
				roomDesc = RoomController.entranceChamberRoom.getDescription();
	  			allocateRoomNUmber();//allocate number as you print details;
	  			exits = RoomController.entranceChamberRoom.getExit();
	  			setCenterPane();
	  			
	  			
				userResponse =  "Room Name: " + RoomController.entranceChamberRoom.getId();
				setBottomPane();
				setLeftPane();
				getUserInputFromTextField();
				break;
				case 1://North
					if (roomDesc.equals(RoomController.roomA2.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomA1.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomA1.getExit();
						isPuzzle = false;
						isMonster = true;
						isItem = true;
						item = ItemController.getItemk11().getItemName();
						monster = MonsterController.getM8Monster().getMonsterName()+ "; Health:"+ MonsterController.getM8Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM8Monster().getArmor();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomA1.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}


					else if (roomDesc.equals(RoomController.roomB2.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomB1.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomB1.getExit();
						isPuzzle = false;
						isMonster = true;
                        monster = MonsterController.getM4Monster().getMonsterName()+ "; Health:"+ MonsterController.getM4Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM4Monster().getArmor();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomB1.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}
					else if (roomDesc.equals(RoomController.roomC2.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomC1.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomC1.getExit();
						riddle = PuzzleController.getPuzzleR8().getRiddle();
						isPuzzle = true;
						isMonster= true;
						hint =PuzzleController.getPuzzleR1().getHint();
                        monster = MonsterController.getM4Monster().getMonsterName()+ "; Health:"+ MonsterController.getM4Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM4Monster().getArmor();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomC1.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}
					else if (roomDesc.equals(RoomController.roomA4.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomA3.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomA3.getExit();
						riddle = PuzzleController.getPuzzleR2().getRiddle();
						isPuzzle = true;
						isMonster = true;
						hint =PuzzleController.getPuzzleR2().getHint();
                        monster = MonsterController.getM7Monster().getMonsterName()+ "; Health:"+ MonsterController.getM7Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM7Monster().getArmor();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomA3.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}

					else if (roomDesc.equals(RoomController.roomB3.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomB2.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomB2.getExit();
						riddle = PuzzleController.getPuzzleR6().getRiddle();
						isPuzzle = true;
						isMonster = true;
						hint =PuzzleController.getPuzzleR6().getHint();
                        monster = MonsterController.getM4Monster().getMonsterName()+ "; Health:"+ MonsterController.getM4Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM4Monster().getArmor();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomB2.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}
					else if (roomDesc.equals(RoomController.roomB4.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomB3.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomB3.getExit();
						isMonster=true;
                        monster = MonsterController.getM7Monster().getMonsterName()+ "; Health:"+ MonsterController.getM7Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM7Monster().getArmor();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomB3.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}
					else if (roomDesc.equals(RoomController.roomB5.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomB4.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomB4.getExit();
						riddle = PuzzleController.getPuzzleR7().getRiddle();
						isPuzzle = true;
						isMonster = true;
						hint =PuzzleController.getPuzzleR7().getHint();
                        monster = MonsterController.getM7Monster().getMonsterName()+ "; Health:"+ MonsterController.getM7Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM7Monster().getArmor();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomB4.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}
					else if (roomDesc.equals(RoomController.roomD2.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomD1.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomD1.getExit();
						isMonster= true;
                        monster = MonsterController.getM5Monster().getMonsterName()+ "; Health:"+ MonsterController.getM5Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM5Monster().getArmor();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomD1.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}
					else if (roomDesc.equals(RoomController.roomD3.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomD2.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomD2.getExit();
						riddle = PuzzleController.getPuzzleR5().getRiddle();
						isPuzzle = true;
						isMonster = true;
						hint =PuzzleController.getPuzzleR5().getHint();
                        monster = MonsterController.getM5Monster().getMonsterName()+ "; Health:"+ MonsterController.getM5Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM5Monster().getArmor();

						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomD2.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}
					else if (roomDesc.equals(RoomController.roomE2.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomE1.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomE1.getExit();
						//riddle = PuzzleController.getPuzzleR6().getRiddle();
						isItem = true;
						isMonster = true;
						//isPuzzle = true;
						//hint =PuzzleController.getPuzzleR6().getHint();
						monster = MonsterController.getM8Monster().getMonsterName()+ "; Health:"+ MonsterController.getM8Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM8Monster().getArmor();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomE1.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}
					else if (roomDesc.equals(RoomController.roomE3.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomE2.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomE2.getExit();
						isMonster = true;
                        monster = MonsterController.getM5Monster().getMonsterName()+ "; Health:"+ MonsterController.getM5Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM5Monster().getArmor();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomE2.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}
					else if (roomDesc.equals(RoomController.roomC4.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.stairsB1FRoom.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.stairsB1FRoom.getExit();
						//riddle = PuzzleController.getPuzzleR6().getRiddle();
						//isPuzzle = true;
						//hint =PuzzleController.getPuzzleR6().getHint();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.stairsB1FRoom.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}
					else if (roomDesc.equals(RoomController.roomC5.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomC4.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomC4.getExit();
						isMonster=true;
                        monster = MonsterController.getM6Monster().getMonsterName()+ "; Health:"+ MonsterController.getM6Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM6Monster().getArmor();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomC4.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}
					else if (roomDesc.equals(RoomController.roomD4.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomD3.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomD3.getExit();
						isMonster=true;
                        monster = MonsterController.getM5Monster().getMonsterName()+ "; Health:"+ MonsterController.getM5Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM5Monster().getArmor();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomD3.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}
					else if (roomDesc.equals(RoomController.roomD5.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomD4.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomD4.getExit();
						riddle = PuzzleController.getPuzzleR8().getRiddle();
						isPuzzle = true;
						isMonster = true;
						hint =PuzzleController.getPuzzleR8().getHint();
                        monster = MonsterController.getM6Monster().getMonsterName()+ "; Health:"+ MonsterController.getM6Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM6Monster().getArmor();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomD4.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}
					else if (roomDesc.equals(RoomController.roomA5.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomA4.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomA4.getExit();
						isMonster = true;
                        monster = MonsterController.getM7Monster().getMonsterName()+ "; Health:"+ MonsterController.getM7Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM7Monster().getArmor();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomA4.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}
					else if (roomDesc.equals(RoomController.roomE5.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomE4.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomE4.getExit();
						isMonster = true;
                        monster = MonsterController.getM6Monster().getMonsterName()+ "; Health:"+ MonsterController.getM6Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM6Monster().getArmor();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomE4.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}
					else if (roomDesc.equals(RoomController.stairsB1FRoom.getDescription())) {
						centerPane.getChildren().clear();
						leftPane.getChildren().clear();
						bottomPane.getChildren().clear();
						roomDesc = RoomController.roomC2.getDescription();
						allocateRoomNUmber();//allocate number as you print details;
						exits = RoomController.roomC2.getExit();
						//riddle = PuzzleController.getPuzzleR6().getRiddle();
						isMonster = true;
                        monster = MonsterController.getM4Monster().getMonsterName()+ "; Health:"+ MonsterController.getM4Monster().getMonsterHealth() +
                                "; Armor:" + MonsterController.getM4Monster().getArmor();
						//hint =PuzzleController.getPuzzleR6().getHint();
						setCenterPane();


						userResponse =  "Room Name: " + RoomController.roomC2.getId();
						setBottomPane();
						setLeftPane();
						getUserInputFromTextField();
					}
					break;

			case 2: //East
				if (roomDesc.equals(RoomController.entranceChamberRoom.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.connectingChamberRoom.getDescription();
		  			allocateRoomNUmber();//allocate number as you print details;
		  			exits = RoomController.connectingChamberRoom.getExit();
		  			riddle = PuzzleController.getPuzzleR8().getRiddle();
		  			isPuzzle = true;
		  			isMonster = true;
		  			hint = PuzzleController.getPuzzleR8().getHint();
<<<<<<< HEAD
		  			monster = MonsterController.getM3Monster().getMonsterName()+ "; Health:"+ MonsterController.getM3Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM3Monster().getArmor();
=======
		  			monster = MonsterController.getM3Monster().getMonsterName();
		  		
>>>>>>> 6544a903eed4c43d173bf6f4f00e9be6b6b7dde5
		  			// showItemPuzzleMonster();
		  			
		  			
		  			//if (userInput.equals(arg0))
		  			setCenterPane();
		  			
		  			
					userResponse =  "Room Name: " + RoomController.connectingChamberRoom.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				
				
				else if (roomDesc.equals(RoomController.connectingChamberRoom.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.spiralStaircaseRoom.getDescription();
		  			allocateRoomNUmber();//allocate number as you print details;
		  			exits = RoomController.spiralStaircaseRoom.getExit();
		  			isPuzzle = false;
		  			isMonster = false;
		  			setCenterPane();
		  			
		  			
					userResponse =  "Room Name: " + RoomController.spiralStaircaseRoom.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.stairsB1FRoom.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomD3.getDescription();
		  			allocateRoomNUmber();//allocate number as you print details;
		  			exits = RoomController.roomD3.getExit();
		  			isMonster = true;
                    monster = MonsterController.getM5Monster().getMonsterName()+ "; Health:"+ MonsterController.getM5Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM5Monster().getArmor();
		  			
		  			setCenterPane();
		  			
		  			
					userResponse =  "Room Name: " + RoomController.roomD3.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomA2.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomB2.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomB2.getExit();
					riddle = PuzzleController.getPuzzleR6().getRiddle();
					isPuzzle = true;
					isMonster = true;
					hint = PuzzleController.getPuzzleR6().getHint();
                    monster = MonsterController.getM4Monster().getMonsterName()+ "; Health:"+ MonsterController.getM4Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM4Monster().getArmor();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.roomB2.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomB1.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomC1.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomC1.getExit();
					riddle = PuzzleController.getPuzzleR1().getRiddle();
					isPuzzle = true;
					isMonster = true;
					hint = PuzzleController.getPuzzleR1().getHint();
                    monster = MonsterController.getM4Monster().getMonsterName()+ "; Health:"+ MonsterController.getM4Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM4Monster().getArmor();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.roomC1.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomB2.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomC2.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomC2.getExit();
					//riddle = PuzzleController.getPuzzleR6().getRiddle();
					isMonster = true;
                    monster = MonsterController.getM4Monster().getMonsterName()+ "; Health:"+ MonsterController.getM4Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM4Monster().getArmor();
					//hint = PuzzleController.getPuzzleR6().getHint();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.roomC2.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomC2.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomD2.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomD2.getExit();
					riddle = PuzzleController.getPuzzleR5().getRiddle();
					isPuzzle = true;
					isMonster= true;
					hint = PuzzleController.getPuzzleR5().getHint();
                    monster = MonsterController.getM5Monster().getMonsterName()+ "; Health:"+ MonsterController.getM5Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM5Monster().getArmor();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.roomD2.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomA3.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomB3.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomB3.getExit();
					isMonster = true;
                    monster = MonsterController.getM7Monster().getMonsterName()+ "; Health:"+ MonsterController.getM7Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM7Monster().getArmor();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.roomB3.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomA4.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomB4.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomB4.getExit();
					riddle = PuzzleController.getPuzzleR7().getRiddle();
					isPuzzle = true;
					isMonster = true;
					hint = PuzzleController.getPuzzleR7().getHint();
                    monster = MonsterController.getM7Monster().getMonsterName()+ "; Health:"+ MonsterController.getM7Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM7Monster().getArmor();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.roomB4.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomB3.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.stairsB1FRoom.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.stairsB1FRoom.getExit();
					//riddle = PuzzleController.getPuzzleR6().getRiddle();
					//isPuzzle = true;
					//hint = PuzzleController.getPuzzleR6().getHint();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.stairsB1FRoom.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomB4.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomC4.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomC4.getExit();
					isMonster = true;
                    monster = MonsterController.getM6Monster().getMonsterName()+ "; Health:"+ MonsterController.getM6Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM6Monster().getArmor();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.roomC4.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomD1.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomE1.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomE1.getExit();
					isMonster= true;
					isItem = true;
					item = ItemController.getItemk11().getItemName();
					//if (!inventory.contains(item)) {
					//	inventory.add(item);
					//}
					//monster = MonsterController.getM8Monster().getMonsterName();
					monster = MonsterController.getM8Monster().getMonsterName() + "; Health:"+ MonsterController.getM8Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM8Monster().getArmor();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.roomE1.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomD2.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomE2.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomE2.getExit();
					//riddle = PuzzleController.getPuzzleR6().getRiddle();
					isMonster = true;
                    monster = MonsterController.getM5Monster().getMonsterName()+ "; Health:"+ MonsterController.getM5Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM5Monster().getArmor();
					///hint = PuzzleController.getPuzzleR6().getHint();
					setCenterPane();
					userResponse =  "Room Name: " + RoomController.roomE2.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomD3.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomE3.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomE3.getExit();
					riddle = PuzzleController.getPuzzleR4().getRiddle();
					isPuzzle = true;
					hint = PuzzleController.getPuzzleR4().getHint();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.roomE3.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomC4.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomD4.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomD4.getExit();
					riddle = PuzzleController.getPuzzleR8().getRiddle();
					isPuzzle = true;
					isMonster= true;
					hint = PuzzleController.getPuzzleR8().getHint();
                    monster = MonsterController.getM6Monster().getMonsterName()+ "; Health:"+ MonsterController.getM6Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM6Monster().getArmor();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.roomD4.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomC5.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomD5.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomD5.getExit();
					isMonster = true;
                    monster = MonsterController.getM6Monster().getMonsterName()+ "; Health:"+ MonsterController.getM6Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM6Monster().getArmor();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.roomD5.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomD4.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomE4.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomE4.getExit();
					isMonster = true;
                    monster = MonsterController.getM6Monster().getMonsterName()+ "; Health:"+ MonsterController.getM6Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM6Monster().getArmor();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.roomE4.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomD5.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomE5.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomE5.getExit();
					isMonster = true;
					isItem = true;
					item = ItemController.getItemk11().getItemName();
					inventory.add(item);
					monster = MonsterController.getM8Monster().getMonsterName()+ "; Health:"+ MonsterController.getM8Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM8Monster().getArmor();
					hint = PuzzleController.getPuzzleR6().getHint();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.roomE5.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomD5.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomE5.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomE5.getExit();
					isMonster = true;
					isItem = true;
					item = ItemController.getItemk11().getItemName();
					weapon = item;
					monster = MonsterController.getM8Monster().getMonsterName()+ "; Health:"+ MonsterController.getM8Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM8Monster().getArmor();
					setCenterPane();
					setLeftPane();


					userResponse =  "Room Name: " + RoomController.roomE5.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomE4.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomE5.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomE5.getExit();
					isMonster = true;
					isItem = true;
					item = ItemController.getItemk11().getItemName();
					inventory.add(item);
					monster = MonsterController.getM8Monster().getMonsterName()+ "; Health:"+ MonsterController.getM8Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM8Monster().getArmor();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.roomE5.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomA1.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomB1.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomB1.getExit();
					//riddle = PuzzleController.getPuzzleR6().getRiddle();
					//isPuzzle = true;
					isMonster = true;
                    monster = MonsterController.getM4Monster().getMonsterName()+ "; Health:"+ MonsterController.getM4Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM4Monster().getArmor();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.roomB1.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}
				else if (roomDesc.equals(RoomController.roomA5.getDescription())) {
					centerPane.getChildren().clear();
					leftPane.getChildren().clear();
					bottomPane.getChildren().clear();
					roomDesc = RoomController.roomB5.getDescription();
					allocateRoomNUmber();//allocate number as you print details;
					exits = RoomController.roomB5.getExit();
					isMonster = true;
                    monster = MonsterController.getM7Monster().getMonsterName()+ "; Health:"+ MonsterController.getM7Monster().getMonsterHealth() +
                            "; Armor:" + MonsterController.getM7Monster().getArmor();
					setCenterPane();


					userResponse =  "Room Name: " + RoomController.roomB5.getId();
					setBottomPane();
					setLeftPane();
					getUserInputFromTextField();
				}

				break;
				   case 3://South
					   if (roomDesc.equals(RoomController.roomB1.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomB2.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomB2.getExit();
						   riddle = PuzzleController.getPuzzleR6().getRiddle();
						   isPuzzle = true;
						   isMonster = true;
						   //isItem = true;
						   hint = PuzzleController.getPuzzleR8().getHint();
						   //item = ItemController.getItemW2().getItemName();
                           monster = MonsterController.getM4Monster().getMonsterName()+ "; Health:"+ MonsterController.getM4Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM4Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomB2.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }


					   else if (roomDesc.equals(RoomController.roomB2.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomB3.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomB3.getExit();
						   isPuzzle = false;
						   isMonster = true;
                           monster = MonsterController.getM7Monster().getMonsterName()+ "; Health:"+ MonsterController.getM7Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM7Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomB3.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomC1.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomC2.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomC2.getExit();
						   isPuzzle = false;
						   isMonster = true;
                           monster = MonsterController.getM4Monster().getMonsterName()+ "; Health:"+ MonsterController.getM4Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM4Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomC2.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomC2.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.stairsB1FRoom.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.stairsB1FRoom.getExit();
						   isPuzzle = false;
						   isMonster = false;
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.stairsB1FRoom.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomA3.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomA4.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomA4.getExit();
						   isPuzzle = false;
						   isMonster = true;
                           monster = MonsterController.getM7Monster().getMonsterName()+ "; Health:"+ MonsterController.getM7Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM7Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomA4.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomA4.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomA5.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomA5.getExit();
						   isMonster = true;
						   isItem = true;
						   item = ItemController.getItemk11().getItemName();
						   inventory.add(item);
						   monster = MonsterController.getM8Monster().getMonsterName() + "; Health:"+ MonsterController.getM8Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM8Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomA5.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomB3.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomB4.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomB4.getExit();
						   riddle = PuzzleController.getPuzzleR7().getRiddle();
						   isPuzzle = true;
						   isMonster = true;
						   hint = PuzzleController.getPuzzleR7().getHint();
                           monster = MonsterController.getM7Monster().getMonsterName()+ "; Health:"+ MonsterController.getM7Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM7Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomB4.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomB4.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomB5.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomB5.getExit();
						   isPuzzle = false;
						   isMonster = true;
                           monster = MonsterController.getM7Monster().getMonsterName()+ "; Health:"+ MonsterController.getM7Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM7Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomB5.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomD1.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomD2.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomD2.getExit();
						   riddle = PuzzleController.getPuzzleR5().getRiddle();
						   isPuzzle = true;
						   isMonster = true;
						   hint = PuzzleController.getPuzzleR5().getHint();
                           monster = MonsterController.getM5Monster().getMonsterName()+ "; Health:"+ MonsterController.getM5Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM5Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomD2.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomD2.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomD3.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomD3.getExit();
						   isPuzzle = false;
						   isMonster = true;
                           monster = MonsterController.getM5Monster().getMonsterName()+ "; Health:"+ MonsterController.getM5Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM5Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomD3.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomD3.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomD4.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomD4.getExit();
						   riddle = PuzzleController.getPuzzleR8().getRiddle();
						   isPuzzle = true;
						   isMonster = true;
						   hint = PuzzleController.getPuzzleR8().getHint();
                           monster = MonsterController.getM6Monster().getMonsterName()+ "; Health:"+ MonsterController.getM6Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM6Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomD4.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomE2.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomE3.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomE3.getExit();
						   riddle = PuzzleController.getPuzzleR4().getRiddle();
						   isPuzzle = true;
						   isMonster = false;
						   hint = PuzzleController.getPuzzleR4().getHint();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomE3.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomC4.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomC5.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomC5.getExit();
						   riddle = PuzzleController.getPuzzleR3().getRiddle();
						   isPuzzle = true;
						   isMonster = true;
						   hint = PuzzleController.getPuzzleR3().getHint();
                           monster = MonsterController.getM6Monster().getMonsterName()+ "; Health:"+ MonsterController.getM6Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM6Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomC5.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomD4.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomD5.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomD5.getExit();
						   //riddle = PuzzleController.getPuzzleR8().getRiddle();
						   isPuzzle = false;
						   isMonster = true;
						  // hint = PuzzleController.getPuzzleR8().getHint();
                           monster = MonsterController.getM6Monster().getMonsterName()+ "; Health:"+ MonsterController.getM6Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM6Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomD5.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomA1.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomA2.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomA2.getExit();
						   isMonster=true;
                           monster = MonsterController.getM4Monster().getMonsterName()+ "; Health:"+ MonsterController.getM4Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM4Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomA2.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomE1.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomE2.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomE2.getExit();
						   isMonster= true;
                           monster = MonsterController.getM5Monster().getMonsterName()+ "; Health:"+ MonsterController.getM5Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM5Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomE2.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.stairsB1FRoom.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomC4.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomC4.getExit();
						   isMonster= true;
                           monster = MonsterController.getM6Monster().getMonsterName()+ "; Health:"+ MonsterController.getM6Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM6Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomC4.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   break;
				   case 4://west
					   if (roomDesc.equals(RoomController.roomB1.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomA1.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomA1.getExit();
						   isMonster = true;
						   isItem = true;
						   item = ItemController.getItemk11().getItemName();
						   monster = MonsterController.getM8Monster().getMonsterName()+ "; Health:"+ MonsterController.getM8Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM8Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomA1.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }

					   else if (roomDesc.equals(RoomController.roomB2.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomA2.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomA2.getExit();
						   isPuzzle = false;
						   isMonster = true;
                           monster = MonsterController.getM4Monster().getMonsterName()+ "; Health:"+ MonsterController.getM4Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM4Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomA2.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomC1.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomB1.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomB1.getExit();
						   isPuzzle = false;
						   isMonster = true;
                           monster = MonsterController.getM4Monster().getMonsterName()+ "; Health:"+ MonsterController.getM4Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM4Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomB1.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomC2.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomB2.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomB2.getExit();
						   riddle = PuzzleController.getPuzzleR6().getRiddle();
						   isPuzzle = true;
						   isMonster = true;
						   hint = PuzzleController.getPuzzleR6().getHint();
                           monster = MonsterController.getM4Monster().getMonsterName()+ "; Health:"+ MonsterController.getM4Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM4Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomB2.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomB3.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomA3.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomA3.getExit();
						   riddle = PuzzleController.getPuzzleR2().getRiddle();
						   isPuzzle = true;
						   isMonster = true;
						   hint = PuzzleController.getPuzzleR2().getHint();
                           monster = MonsterController.getM7Monster().getMonsterName()+ "; Health:"+ MonsterController.getM7Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM7Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomA3.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomB4.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomA4.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomA4.getExit();
						   isPuzzle = false;
						   isMonster = true;
                           monster = MonsterController.getM7Monster().getMonsterName()+ "; Health:"+ MonsterController.getM7Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM7Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomA4.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomB5.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomA5.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomA5.getExit();
						   isPuzzle = false;
						   isMonster = true;
						   isItem = true;
						   item = ItemController.getItemk11().getItemName();
						   inventory.add(item);
						   monster = MonsterController.getM8Monster().getMonsterName()+ "; Health:"+ MonsterController.getM8Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM8Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomA5.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomD2.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomC2.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomC2.getExit();
						   isPuzzle = false;
						   isMonster = true;
                           monster = MonsterController.getM4Monster().getMonsterName()+ "; Health:"+ MonsterController.getM4Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM4Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomC2.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomD3.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.stairsB1FRoom.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.stairsB1FRoom.getExit();
						   isPuzzle = false;
						   isMonster = false;
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.stairsB1FRoom.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomE2.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomD2.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomD2.getExit();
						   riddle = PuzzleController.getPuzzleR5().getRiddle();
						   isPuzzle = true;
						   isMonster = true;
						   hint = PuzzleController.getPuzzleR5().getHint();
                           monster = MonsterController.getM5Monster().getMonsterName()+ "; Health:"+ MonsterController.getM5Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM5Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomD2.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomE3.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomD3.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomD3.getExit();
						   isPuzzle = false;
						   isMonster = true;
                           monster = MonsterController.getM5Monster().getMonsterName()+ "; Health:"+ MonsterController.getM5Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM5Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomD3.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomC4.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomB4.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomB4.getExit();
						   riddle= PuzzleController.getPuzzleR7().getRiddle();
						   isPuzzle = true;
						   isMonster = true;
						   hint = PuzzleController.getPuzzleR7().getHint();
                           monster = MonsterController.getM7Monster().getMonsterName()+ "; Health:"+ MonsterController.getM7Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM7Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomB4.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomD4.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomC4.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomC4.getExit();
						   isPuzzle = false;
						   isMonster = true;
                           monster = MonsterController.getM6Monster().getMonsterName()+ "; Health:"+ MonsterController.getM6Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM6Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomC4.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomD5.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomC5.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomC5.getExit();
						   riddle = PuzzleController.getPuzzleR3().getRiddle();
						   isPuzzle = true;
						   isMonster = true;
						   hint = PuzzleController.getPuzzleR3().getHint();
                           monster = MonsterController.getM6Monster().getMonsterName()+ "; Health:"+ MonsterController.getM6Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM6Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomC5.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomE4.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomD4.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomD4.getExit();
						   riddle = PuzzleController.getPuzzleR8().getRiddle();
						   isPuzzle = true;
						   isMonster = true;
						   hint= PuzzleController.getPuzzleR8().getHint();
                           monster = MonsterController.getM6Monster().getMonsterName()+ "; Health:"+ MonsterController.getM6Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM6Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomD4.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomE1.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomD1.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomD1.getExit();
						   isPuzzle = false;
						   isMonster = true;
                           monster = MonsterController.getM5Monster().getMonsterName()+ "; Health:"+ MonsterController.getM5Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM5Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomD1.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.roomE5.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomD5.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomD5.getExit();
						   isPuzzle = false;
						   isMonster = true;
                           monster = MonsterController.getM6Monster().getMonsterName()+ "; Health:"+ MonsterController.getM6Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM6Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomD5.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.connectingChamberRoom.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						 //  rightPane.getChildren().clear();
						  
						   roomDesc = RoomController.entranceChamberRoom.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.entranceChamberRoom.getExit();
						   isPuzzle = false;
						   isMonster = false;
						   setCenterPane();
						   setLeftPane();


						   userResponse =  "Room Name: " + RoomController.entranceChamberRoom.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.stairsB1FRoom.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomB3.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomB3.getExit();
						   isPuzzle = false;
						   isMonster = true;
                           monster = MonsterController.getM7Monster().getMonsterName()+ "; Health:"+ MonsterController.getM7Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM7Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.roomB3.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
				   		break;
				   case 8: //up
					   if (roomDesc.equals(RoomController.spiralStaircaseRoom.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.guardLockedDoorRoom.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.guardLockedDoorRoom.getExit();
						   //riddle = PuzzleController.getPuzzleR6().getRiddle();
						   isMonster = true;
						   monster = MonsterController.getM8Monster().getMonsterName()+ "; Health:"+ MonsterController.getM8Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM8Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.guardLockedDoorRoom.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.guardLockedDoorRoom.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.sorcererBossFightRoom.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.sorcererBossFightRoom.getExit();
						   isPuzzle = false;
						   isMonster = true;
						   monster = MonsterController.getM2Monster().getMonsterName()+ "; Health:"+ MonsterController.getM2Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM2Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.sorcererBossFightRoom.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.necromancerRoom.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.stairsB1FRoom.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.stairsB1FRoom.getExit();
						   isPuzzle = false;
						   isMonster = false;
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.stairsB1FRoom.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   break;
				   case 9://down
					   if (roomDesc.equals(RoomController.spiralStaircaseRoom.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.stairsB1FRoom.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.stairsB1FRoom.getExit();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.stairsB1FRoom.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   else if (roomDesc.equals(RoomController.sorcererBossFightRoom.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.guardLockedDoorRoom.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.guardLockedDoorRoom.getExit();
						   isPuzzle = false;
						   isMonster = true;
						   monster = MonsterController.getM8Monster().getMonsterName()+ "; Health:"+ MonsterController.getM8Monster().getMonsterHealth() +
                                   "; Armor:" + MonsterController.getM8Monster().getArmor();
						   setCenterPane();


						   userResponse =  "Room Name: " + RoomController.guardLockedDoorRoom.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   break;
<<<<<<< HEAD
                   case 11://Pickup
                       leftPane.getChildren().clear();
                       inventory.add(MonsterController.getM3Monster().getItemsDrop());
                       setLeftPane();
                       break;
                   case 12://Fight
                      //hp = hp-5;
                     break;

=======
				   case 13:
					   
					   checkPuzzleAnswers();
				  			
				  		
				   break;
>>>>>>> 6544a903eed4c43d173bf6f4f00e9be6b6b7dde5
				
			default:
				break;
			} 		    	
    		    		    	
      }	
    	 
   // i ended here..
       	
      
    	
    	
    	
   	  
    	public void allocateRoomNUmber() {
    		if (roomDesc.equals(RoomController.entranceChamberRoom.getDescription())) {
    			currentRoom = 1;
    		}
    		if (roomDesc.equals(RoomController.connectingChamberRoom.getDescription())) {
    			currentRoom = 2;
    		}
    		if (roomDesc.equals(RoomController.spiralStaircaseRoom.getDescription())) {
    			currentRoom = 3;
    		}
    		System.out.println("Current Room: "+currentRoom);
    	}
      
    
 
	
      public void clearTextField() {
      } 
    
      public void checkPuzzleAnswers() {
    	
    	  if (riddle.equals(PuzzleController.puzzleR1.getRiddle())) {
     		 
    		  riddleAnswer = PuzzleController.puzzleR1.getAnswer().toUpperCase();}
    	   if (riddle.equals(PuzzleController.puzzleR2.getRiddle())) {
    	    		 
        		  riddleAnswer = PuzzleController.puzzleR2.getAnswer().toUpperCase();}
    	   if (riddle.equals(PuzzleController.puzzleR3.getRiddle())) {
        	    		 
            		  riddleAnswer = PuzzleController.puzzleR3.getAnswer().toUpperCase();}
    	  if (riddle.equals(PuzzleController.puzzleR4.getRiddle())) {
            	    		 
                		  riddleAnswer = PuzzleController.puzzleR4.getAnswer().toUpperCase();}
    	   if (riddle.equals(PuzzleController.puzzleR5.getRiddle())) {
                	    		 
                    		  riddleAnswer = PuzzleController.puzzleR5.getAnswer().toUpperCase();}
    	  if (riddle.equals(PuzzleController.puzzleR6.getRiddle())) {
                    	    		 
                        		  riddleAnswer = PuzzleController.puzzleR6.getAnswer().toUpperCase();}
    	 if (riddle.equals(PuzzleController.puzzleR7.getRiddle())) {
                        	    		 
                            		  riddleAnswer = PuzzleController.puzzleR7.getAnswer().toUpperCase();}
    	  	if (riddle.equals(PuzzleController.puzzleR8.getRiddle())) {
    		 
           riddleAnswer = PuzzleController.puzzleR8.getAnswer().toUpperCase();
        
                System.out.println(riddleAnswer + "answer");            		  		
    	  	}
                            		  		
    	    getUserInputFromTextField();
            if (userInput.equalsIgnoreCase(riddleAnswer)) {
         	  // System.out.println("still working...");
         	   bottomPane.getChildren().clear();
         	   userResponse= "You are right";
         	   setBottomPane();

            }  
            else {
         	   System.out.println("Keep trying");
         	   bottomPane.getChildren().clear();
         	   userResponse= "Keep  working on the puzzle, YOu are wrong!!!";
         	   setBottomPane();

            }
    		//System.out.print(PuzzleController.puzzleR8.getAnswer().toUpperCase() + "answer");
    		  //setBottomPane();
                            		  		//System.out.println("TEsting puzze");
    	 
    	 
                            		  	}
    	
	  		
                            		 
      
      public void changeGem() {
    	  checkPuzzleAnswers();
    	  if (userInput.equals(riddleAnswer)) {
	  			
	  			//System.out.println("Riddleanswer:" +  riddleAnswer);
	  			leftPane.getChildren().clear();
	  			gem = gem + 10;
	  			setLeftPane();
	  			
	  		}
    	  
    	 
      }
      
     public Scene getLoginScene() { //Login scene that gets called when game begins . Upon validation of data , the main game page gets displayed
    	  BorderPane bp = new BorderPane();
          bp.setPadding(new Insets(10,50,50,50));
         //Adding HBox
         HBox hb = new HBox();
         hb.setPadding(new Insets(20,20,20,30));

         gridPane = new GridPane();
         gridPane.setPadding(new Insets(20,20,20,20));
         gridPane.setHgap(5);
         gridPane.setVgap(5);

         lblUserName = new Label("Username");
         tfUserName = new TextField();
         lblPassword = new Label("Password");
         tfPassword = new PasswordField();
         btnLogin = new Button("Login");
         lblMessage = new Label();
         btnNewUser = new Button("New User");
         lblMessages = new Label();
         
         



         //Adding Nodes to GridPane layout
         gridPane.add(lblUserName, 0, 0);
         gridPane.add(tfUserName, 1, 0);
         gridPane.add(lblPassword, 0, 1);
         gridPane.add(tfPassword, 1, 1);
         gridPane.add(btnLogin, 2, 1);
         gridPane.add(lblMessage, 1, 2);
         gridPane.add(btnNewUser, 2, 2);
         gridPane.add(lblMessages, 3, 1);

         //Reflection for gridPane
         Reflection r = new Reflection();
         r.setFraction(0.7f);
         gridPane.setEffect(r);

         //DropShadow effect
         DropShadow dropShadow = new DropShadow();
         dropShadow.setOffsetX(5);
         dropShadow.setOffsetY(5);

         //Adding text and DropShadow effect to it
         Text text = new Text("CITADEL OF STORMS");
         text.setFont(Font.font ("Jokerman", 25));
         text.setEffect(dropShadow);

         //Adding text to HBox
         hb.getChildren().add(text);

         //Add ID's to Nodes
         bp.setId("bp");
         gridPane.setId("root");
         btnLogin.setId("btnLogin");
         text.setId("text");
     
         
         
         //Add HBox and GridPane layout to BorderPane Layout
         bp.setTop(hb);
         bp.setCenter(gridPane);

         //Adding BorderPane to the scene and loading CSS
          Scene loginScene = new Scene(bp, 400, 300);
        
         loginScene.getStylesheets().add(getClass().getClassLoader().getResource("css/loginStyle.css").toExternalForm());
         return loginScene;
         // stage.setScene(loginScene);
         //loginStage.setScene(loginScene);
        // loginStage.setResizable(false);
        // loginStage.show();
         
     }
     
    
      
    public boolean isWrongPassword() {
    	return password != "game";
    }
    public boolean isWrongUserName() {
    	return userName != "player";
    }
      
}
