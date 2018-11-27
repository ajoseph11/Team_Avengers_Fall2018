package controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.print.Printable;
import java.io.IOException;
import java.util.concurrent.BlockingDeque;

import javax.swing.ButtonModel;

import com.sun.org.apache.xml.internal.security.utils.UnsyncBufferedOutputStream;
import com.sun.tracing.dtrace.StabilityLevel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sun.nio.cs.FastCharsetProvider;
import view.NewGui;

public class NewGuiController {
	//
	CitadelController citadelController; //Master controller for the game
	
	//Selections for users to interact with the game
	String [] userOptions = {"N", "E", "S", "W", "I", "P", "M", "U", "D", "H"};
	int iUserOption = 0;// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10; for each of  the above values we are adding 1 to their index
	
   private int currentRoom;
   private Stage stage; //create a stage that references the gui stage when the game is run
   private Scene scene; //create a scene that references the GUI scene whenever the game is run.
	
	
	//set all variables for the instance of GUi inside the controller
	private int guiHeight;
	private int guiWidth;

	private BorderPane borderPane;
	private VBox leftPane, centerPane, rightPane;
	private HBox topPane, bottomPane, hbUserInput;
	//other modes in the gui

	private Label lbTop, lbRmDesc, lbUserResponse, lbHp, lbGem, lbWeapon, lbDirection, lbExit, lbIsPuzzle, lbIsMonster, LbIsItem, lbRiddle, lbPuzzle, lbMonster, lbItem;
	private TextField txtUserInput;
	private  Button btSubmitUserInput;
	
	private  String roomDesc;
	
	private int hP;
	private int gem;
	private String weapon = " ";
	private String exits,  userResponse,riddle, item, monster, userInput, riddleAnswer, hint;
	private boolean isPuzzle, isMonster, isItem;

	protected Node hbBottom;

	private Label lbHint;
	
	
	public NewGuiController() {
		citadelController = new CitadelController(); //master controller for the game
		
		stage = NewGui.getStage(); //static getter reference to the GUI
		scene = NewGui.getScene(); //static getter reference to the GUI
		
		userResponse = ""; //empty message at the beginning of game
		
		
		guiHeight = 800;
		guiWidth = 1000;
		
		borderPane = new BorderPane();
		leftPane = new VBox();
		leftPane.getStyleClass().add("vbox");//apply style from css to this vbox
		centerPane = new VBox();
		centerPane.getStyleClass().add("vbox");
		rightPane = new VBox();
		rightPane.getStyleClass().add("vbox");
		topPane = new HBox();
		topPane.getStyleClass().add("hbox");
		hbUserInput = new HBox();
		bottomPane = new HBox();
		bottomPane.getStyleClass().add("hbox");
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
		
		scene = new Scene(borderPane, guiWidth, guiHeight);
		scene.getStylesheets().add("gameControllerStyle.css");
		stage.setTitle("Citadel--Of--Storms");
		stage.setScene(scene);
		stage.setResizable(false);
		}
	
	public void setRightPane() {
		
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
		lbHp = new Label("HP: " + hP);
		lbGem = new Label("GEM:" + gem);
		lbWeapon = new Label("WEAPON:"  + weapon);
		leftPane.getChildren().addAll(lbHp, lbGem, lbWeapon);
		leftPane.setAlignment(Pos.BASELINE_LEFT);
		VBox.setMargin(lbHp, new Insets(5));
		VBox.setMargin(lbGem, new Insets(5));
		VBox.setMargin(lbWeapon, new Insets(5));
		
		
}
	
	public void setTopPane() {
		lbTop  = new Label("CITADEL OF STORMS");
		topPane.setAlignment(Pos.BASELINE_CENTER);
		topPane.getChildren().add(lbTop);
	}
	
	public void setBottomPane() {
		Button btSave = new Button("Save-Game");
		Button btPause = new Button("Pause-Game");
		Button btResume = new Button("Resume-Game");
		
		
		VBox  vbInteract = new VBox();
		//////vbInteract.setSpacing(10);
		vbInteract.getChildren().addAll(btSave, btPause, btResume);
		vbInteract.setAlignment(Pos.BASELINE_LEFT);
		
		VBox.setMargin(btSave, new Insets(0, 0, 10, 0));
		VBox.setMargin(btPause, new Insets(0, 0, 10, 0));
		VBox.setMargin(btResume, new Insets(0, 0, 10, 0));
		
		Button btInstructions = new Button("Instructions");
		Button btCloseInstruction = new Button("X");
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
	  			
	  			
				userResponse =  "Room ID: " + RoomController.entranceChamberRoom.getId();
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
						//isItem = true;
						//hint = PuzzleController.getPuzzleR8().getHint();
						item = ItemController.getItemW2().getItemName();
						monster = MonsterController.getM8Monster().getMonsterName();
						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomA1.getId();
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
						isMonster = false;
						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomB1.getId();
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
						hint =PuzzleController.getPuzzleR1().getHint();
						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomC1.getId();
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
						hint =PuzzleController.getPuzzleR2().getHint();

						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomA3.getId();
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
						hint =PuzzleController.getPuzzleR6().getHint();

						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomB2.getId();
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
						//riddle = PuzzleController.getPuzzleR6().getRiddle();
						//isPuzzle = true;
						//hint =PuzzleController.getPuzzleR6().getHint();
						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomB3.getId();
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
						hint =PuzzleController.getPuzzleR7().getHint();

						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomB4.getId();
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
						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomD1.getId();
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
						hint =PuzzleController.getPuzzleR5().getHint();

						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomD2.getId();
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
						monster = MonsterController.getM8Monster().getMonsterName();
						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomE1.getId();
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
						//riddle = PuzzleController.getPuzzleR6().getRiddle();
						//isPuzzle = true;
						//hint =PuzzleController.getPuzzleR6().getHint();
						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomE2.getId();
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


						userResponse =  "Room ID: " + RoomController.stairsB1FRoom.getId();
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
						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomC4.getId();
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
						//riddle = PuzzleController.getPuzzleR6().getRiddle();
						//isPuzzle = true;
						//hint =PuzzleController.getPuzzleR6().getHint();
						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomD3.getId();
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
						hint =PuzzleController.getPuzzleR8().getHint();
						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomD4.getId();
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
						//riddle = PuzzleController.getPuzzleR6().getRiddle();
						//isPuzzle = true;
						//hint =PuzzleController.getPuzzleR6().getHint();
						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomA4.getId();
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
						//riddle = PuzzleController.getPuzzleR6().getRiddle();
						//isPuzzle = true;
						//hint =PuzzleController.getPuzzleR6().getHint();
						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomE4.getId();
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
						//isPuzzle = true;
						//hint =PuzzleController.getPuzzleR6().getHint();
						setCenterPane();


						userResponse =  "Room ID: " + RoomController.roomC2.getId();
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
		  			monster = MonsterController.getM3Monster().getMonsterName();
		  			// showItemPuzzleMonster();
		  			setCenterPane();
		  			
		  			
					userResponse =  "Room ID: " + RoomController.connectingChamberRoom.getId();
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
		  			
		  			
					userResponse =  "Room ID: " + RoomController.spiralStaircaseRoom.getId();
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
		  			
		  			setCenterPane();
		  			
		  			
					userResponse =  "Room ID: " + RoomController.roomD3.getId();
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
					hint = PuzzleController.getPuzzleR6().getHint();
					setCenterPane();


					userResponse =  "Room ID: " + RoomController.roomB2.getId();
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
					hint = PuzzleController.getPuzzleR1().getHint();
					setCenterPane();


					userResponse =  "Room ID: " + RoomController.roomC1.getId();
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
					//isPuzzle = true;
					//hint = PuzzleController.getPuzzleR6().getHint();
					setCenterPane();


					userResponse =  "Room ID: " + RoomController.roomC2.getId();
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
					hint = PuzzleController.getPuzzleR5().getHint();
					setCenterPane();


					userResponse =  "Room ID: " + RoomController.roomD2.getId();
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
					//riddle = PuzzleController.getPuzzleR6().getRiddle();
					//isPuzzle = true;
					//hint = PuzzleController.getPuzzleR6().getHint();
					setCenterPane();


					userResponse =  "Room ID: " + RoomController.roomB3.getId();
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
					hint = PuzzleController.getPuzzleR7().getHint();
					setCenterPane();


					userResponse =  "Room ID: " + RoomController.roomB4.getId();
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


					userResponse =  "Room ID: " + RoomController.stairsB1FRoom.getId();
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
					//riddle = PuzzleController.getPuzzleR6().getRiddle();
					//isPuzzle = true;
					//hint = PuzzleController.getPuzzleR6().getHint();
					setCenterPane();


					userResponse =  "Room ID: " + RoomController.roomC4.getId();
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
					//riddle = PuzzleController.getPuzzleR6().getRiddle();
					//isPuzzle = true;
					isMonster= true;
					//hint = PuzzleController.getPuzzleR6().getHint();
					monster = MonsterController.getM8Monster().getMonsterName();
					setCenterPane();


					userResponse =  "Room ID: " + RoomController.roomE1.getId();
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
					//isPuzzle = true;
					///hint = PuzzleController.getPuzzleR6().getHint();
					setCenterPane();
					userResponse =  "Room ID: " + RoomController.roomE2.getId();
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


					userResponse =  "Room ID: " + RoomController.roomE3.getId();
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
					hint = PuzzleController.getPuzzleR8().getHint();
					setCenterPane();


					userResponse =  "Room ID: " + RoomController.roomD4.getId();
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
					//riddle = PuzzleController.getPuzzleR6().getRiddle();
					//isPuzzle = true;
					//hint = PuzzleController.getPuzzleR6().getHint();
					setCenterPane();


					userResponse =  "Room ID: " + RoomController.roomD5.getId();
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
					//riddle = PuzzleController.getPuzzleR6().getRiddle();
					//isPuzzle = true;
					//hint = PuzzleController.getPuzzleR6().getHint();
					setCenterPane();


					userResponse =  "Room ID: " + RoomController.roomE4.getId();
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
					//riddle = PuzzleController.getPuzzleR6().getRiddle();
					isMonster = true;
					monster = MonsterController.getM8Monster().getMonsterName();
					hint = PuzzleController.getPuzzleR6().getHint();
					setCenterPane();


					userResponse =  "Room ID: " + RoomController.roomE5.getId();
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
					//riddle = PuzzleController.getPuzzleR6().getRiddle();
					//isPuzzle = true;
					isMonster = true;
					monster = MonsterController.getM8Monster().getMonsterName();
					setCenterPane();


					userResponse =  "Room ID: " + RoomController.roomE5.getId();
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
					//riddle = PuzzleController.getPuzzleR6().getRiddle();
					//isPuzzle = true;
					isMonster = true;
					monster = MonsterController.getM8Monster().getMonsterName();
					setCenterPane();


					userResponse =  "Room ID: " + RoomController.roomE5.getId();
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
					//isMonster = true;
					//monster = MonsterController.getM8Monster().getMonsterName();
					setCenterPane();


					userResponse =  "Room ID: " + RoomController.roomB1.getId();
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
					//riddle = PuzzleController.getPuzzleR6().getRiddle();
					//isPuzzle = true;
					//isMonster = true;
					//monster = MonsterController.getM8Monster().getMonsterName();
					setCenterPane();


					userResponse =  "Room ID: " + RoomController.roomB5.getId();
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
						   //isMonster = true;
						   //isItem = true;
						   hint = PuzzleController.getPuzzleR8().getHint();
						   //item = ItemController.getItemW2().getItemName();
						  // monster = MonsterController.getM8Monster().getMonsterName();
						   setCenterPane();


						   userResponse =  "Room ID: " + RoomController.roomB2.getId();
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
						   isMonster = false;
						   setCenterPane();


						   userResponse =  "Room ID: " + RoomController.roomB3.getId();
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
						   isMonster = false;
						   setCenterPane();


						   userResponse =  "Room ID: " + RoomController.roomC2.getId();
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


						   userResponse =  "Room ID: " + RoomController.stairsB1FRoom.getId();
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
						   isMonster = false;
						   setCenterPane();


						   userResponse =  "Room ID: " + RoomController.roomA4.getId();
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
						   //isPuzzle = false;
						   isMonster = true;
						   monster = MonsterController.getM8Monster().getMonsterName();
						   setCenterPane();


						   userResponse =  "Room ID: " + RoomController.roomA5.getId();
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
						   isMonster = false;
						   hint = PuzzleController.getPuzzleR7().getHint();
						   setCenterPane();


						   userResponse =  "Room ID: " + RoomController.roomB4.getId();
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
						   isMonster = false;
						   setCenterPane();


						   userResponse =  "Room ID: " + RoomController.roomB5.getId();
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
						   isMonster = false;
						   hint = PuzzleController.getPuzzleR5().getHint();
						   setCenterPane();


						   userResponse =  "Room ID: " + RoomController.roomD2.getId();
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
						   isMonster = false;
						   setCenterPane();


						   userResponse =  "Room ID: " + RoomController.roomD3.getId();
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
						   isMonster = false;
						   hint = PuzzleController.getPuzzleR8().getHint();
						   setCenterPane();


						   userResponse =  "Room ID: " + RoomController.roomD4.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }
					   break;
				   case 8: //up
					   if (roomDesc.equals(RoomController.stairsB1FRoom.getDescription())) {
						   centerPane.getChildren().clear();
						   leftPane.getChildren().clear();
						   bottomPane.getChildren().clear();
						   roomDesc = RoomController.roomD4.getDescription();
						   allocateRoomNUmber();//allocate number as you print details;
						   exits = RoomController.roomD4.getExit();
						   riddle = PuzzleController.getPuzzleR6().getRiddle();
						   isPuzzle = true;
						   //isMonster = true;
						   //isItem = true;
						   hint = PuzzleController.getPuzzleR8().getHint();
						   //item = ItemController.getItemW2().getItemName();
						   // monster = MonsterController.getM8Monster().getMonsterName();
						   setCenterPane();


						   userResponse =  "Room ID: " + RoomController.roomD4.getId();
						   setBottomPane();
						   setLeftPane();
						   getUserInputFromTextField();
					   }

					   break;
				   case 9: //down
					   break;
				
			default:
				break;
			} 		    	
    		    		    	
    	
    	 
   // i ended here..
       	
      }
    	
    	
    	

    
    	  
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
    	  getUserInputFromTextField();
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
                            		  		
                            		  		
    		  
    		 System.out.print(PuzzleController.puzzleR8.getAnswer().toUpperCase() + "answer");
    		  //setBottomPane();
    	  }
                            		 
      }
      public void changeGem() {
    	  checkPuzzleAnswers();
    	  if (userInput.equals(riddleAnswer)) {
	  			
	  			System.out.println("Riddleanswer:" +  riddleAnswer);
	  			leftPane.getChildren().clear();
	  			gem = gem + 10;
	  			setLeftPane();
	  			
	  		}
      }
}
