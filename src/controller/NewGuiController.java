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

import view.NewGui;

public class NewGuiController {
	//
	CitadelController citadelController; //Master controller for the game
	
	//Selections for users to interact with the game
	String [] userOptions = {"N", "E", "S", "W", "I", "P", "M", "U", "D"};
	int iUserOption = 0;// 1, 2, 3, 4, 5, 6, 7; for each of  the above values we are adding 1 to their index
	
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
	
	private String hP = "";
	private String gem = " ";
	private String weapon = " ";
	private String exits,  userResponse,riddle, item, monster, userInput;
	private boolean isPuzzle, isMonster, isItem;

	protected Node hbBottom;
	
	
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
		lbDirection = new Label("DIRECTION: Choose and type ONLY one character. Example: N, E, S, or W from the available room exits. Otherwise, only the first character will be considered!!!");
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
		lbHp = new Label("HP:" + "\n" + hP);
		lbGem = new Label("GEM:" + "\n" + gem);
		lbWeapon = new Label("WEAPON:" + "\n" + weapon);
		leftPane.getChildren().addAll(lbHp, lbGem, lbWeapon);
		leftPane.setAlignment(Pos.BASELINE_LEFT);
		
		
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
		centerPane.getChildren().clear();
		centerPane.getChildren().addAll(lbRmDesc, lbExit, lbIsPuzzle, lbIsMonster, LbIsItem, lbDirection, hbUserInput, lbItem);

	}
	
	public void addPuzzleDetails() {
		lbPuzzle = new Label("PUZZLE:" + "\n" + riddle);
		centerPane.getChildren().clear();
		centerPane.getChildren().addAll(lbRmDesc, lbExit, lbIsPuzzle, lbIsMonster, LbIsItem, lbDirection, hbUserInput, lbPuzzle);

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
		
		
		
		
	}
      
      public void getUserInputFromTextField() {
  		
    		 btSubmitUserInput.setOnAction(new EventHandler<ActionEvent>() {
    			 
    	@Override
    	    public void handle(ActionEvent e) {
    	        if ((txtUserInput.getText() != null && !txtUserInput.getText().isEmpty())) {
    	        	
    	           userInput = txtUserInput.getText().toUpperCase();
    	           if (userInput.length() > 1) { //cut the user input back to 1 if more than one
    	        	   userInput = userInput.substring(0, 1);
    	        	   
    	        	
    	        	 
    	           }
    	           validateUserInput();//check what they entered
    	            txtUserInput.setText(userInput); //print it back to them on the textfield
    	           
    	            setRoomDetails(); // set new room details
    	    	           
    	        } else {
    	        	userInput = "No input, Please make a choice!!!";
    	        	userResponse = userInput;
    	        	bottomPane.getChildren().clear();
    	        	setBottomPane();
    	        
    	        }
    	        
    	        System.out.println(userInput);
    			System.out.println(userInput + " is user input & " + iUserOption + " is button clicked value");
    			
    			showItemPuzzleMonster();
    	      
    	     }

    	 });
    		 

    		
    			
    		}
      
      public void showItemPuzzleMonster() {
    		if (iUserOption == 5 && isItem != false) { //add Item if I is entered
				addItemDetails();
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
    	  if (iUserOption == 0 ) {  //First room  entrance chamber
  			roomDesc = RoomController.entranceChamberRoom.getDescription();
  			allocateRoomNUmber();//allocate number as you print details;
  			exits = RoomController.entranceChamberRoom.getExit();
  			setCenterPane();
  			
  			bottomPane.getChildren().clear();
			userResponse =  "Room ID: " + RoomController.entranceChamberRoom.getId();
			setBottomPane();
			getUserInputFromTextField();
		  	  	
  		}
    	 if (roomDesc.equals(RoomController.entranceChamberRoom.getDescription()) && iUserOption == 2 && currentRoom == 1) {//Entrance
    	//	if (iUserOption == 2 && roomDesc.equals(RoomController.entranceChamberRoom.getDescription())) {
    			
    			roomDesc = RoomController.connectingChamberRoom.getDescription();
    			allocateRoomNUmber();//allocate number as you print details;
    			exits = RoomController.connectingChamberRoom.getExit();
    			centerPane.getChildren().clear();
    			setCenterPane();
    			getUserInputFromTextField();
    			
    			bottomPane.getChildren().clear();
    			userResponse = "You are now East of " + RoomController.entranceChamberRoom.getId() + " ID: " + RoomController.connectingChamberRoom.getId();
    			setBottomPane();
    			

    	    
    			
    	 }
    	
    	
    		else if (roomDesc.equals(RoomController.entranceChamberRoom.getDescription()) && iUserOption != 2)  {
    			centerPane.getChildren().clear();
    			
    			setCenterPane();
    			
    			bottomPane.getChildren().clear();
    			userResponse = "Room ID: " + RoomController.entranceChamberRoom.getId();

    			setBottomPane();
    			getUserInputFromTextField();
    		}
    	 
    	 
    	 if (roomDesc.equals(RoomController.getConnectingChamberRoom().getDescription()) && iUserOption == 4 && currentRoom == 2) {//Entrance
    	    	//	if (iUserOption == 2 && roomDesc.equals(RoomController.entranceChamberRoom.getDescription())) {
    	    			
    	    			roomDesc = RoomController.entranceChamberRoom.getDescription();
    	    			allocateRoomNUmber();//allocate number as you print details;
    	    			exits = RoomController.entranceChamberRoom.getExit();
    	    			centerPane.getChildren().clear();
    	    			setCenterPane();
    	    			getUserInputFromTextField();
    	    			
    	    			bottomPane.getChildren().clear();
    	    			userResponse = "You are now West of " + RoomController.connectingChamberRoom.getId() + " ID: " + RoomController.entranceChamberRoom.getId();
    	    			setBottomPane();
    	    			

    	    	    
    	    			
    	    	 }
    	    	
    	    	
    	    		else if (roomDesc.equals(RoomController.getConnectingChamberRoom().getDescription()) && iUserOption != 4) {
    	    			centerPane.getChildren().clear();
    	    			
    	    			setCenterPane();
    	    			
    	    			bottomPane.getChildren().clear();
    	    			userResponse = "Room ID: " + RoomController.connectingChamberRoom.getId();

    	    			setBottomPane();
    	    			getUserInputFromTextField();
    	    		}
    	 
    	 
   
       	
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
    
}
