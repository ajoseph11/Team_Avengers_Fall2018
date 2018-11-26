package controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.concurrent.BlockingDeque;

import javax.swing.ButtonModel;

import com.sun.org.apache.xml.internal.security.utils.UnsyncBufferedOutputStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
	String [] userOptions = {"N", "E", "S", "W", "I", "P", "M"};
	int iUserOption = 0;// 1, 2, 3, 4, 5, 6, 7; for each of  the above values we are adding 1 to their index
	
	
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
	private String direction, exits, errorMessage, userResponse,riddle, item, monster, userInput;
	private boolean isPuzzle, isMonster, isItem;
	
	
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
		Button btInstructions = new Button("Instructions");
		Button btCloseInstruction = new Button("X");
		//userResponse = "";
		lbUserResponse = new Label("GAME-MESSAGE" + "\n" + userResponse);
		//lbUserResponse.setMaxWidth(guiWidth - 200);
		//lbUserResponse.setMinHeight(50);
		lbUserResponse.setWrapText(true);
		lbUserResponse.setAlignment(Pos.BASELINE_LEFT);
		HBox hbBottom = new HBox();
		hbBottom.setAlignment(Pos.BOTTOM_RIGHT);
		hbBottom.setSpacing(10);
		hbBottom.getChildren().addAll(lbUserResponse, btInstructions, btCloseInstruction);
		bottomPane.getChildren().addAll(hbBottom);
		bottomPane.setAlignment(Pos.BASELINE_CENTER);
		HBox.setMargin(lbUserResponse, new Insets(0, 100, 0, 0));
		HBox.setMargin(hbBottom, new Insets(0, 0, 0, 50));

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
    	           userResponse = userInput;
    	            txtUserInput.setText(userInput);
    	    	           
    	        } else {
    	        	userInput = "No input!!!";
    	        
    	        }
    	        validateUserInput();
    	        System.out.println(userInput);
    			System.out.println(userInput + " is user input & " + iUserOption + " is button clicked value");
    			//setRoomDetails();
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
    	  if (iUserOption == 0 ) {  //First room 
  			roomDesc = RoomController.entranceChamberRoom.getDescription();
  			exits = RoomController.entranceChamberRoom.getExit();
  			
			
  			
  		}
    		//check for user input
			
    	  
  		//go to connecting chambers
  		 if (iUserOption == 1) {
  			roomDesc = RoomController.connectingChamberRoom.getDescription();
  			exits = RoomController.connectingChamberRoom.getExit();
  			

  		}
  		if (iUserOption == 2) {
  			roomDesc = RoomController.roomA1.getDescription();
  			exits = RoomController.roomA1.getExit();
  			
  		}
    	  
    	//centerPane.getChildren().clear();
  		//centerPane.getChildren().addAll(lbRmDesc, lbExit, lbIsPuzzle, lbIsMonster, LbIsItem, lbDirection, hbUserInput);

      }
	
      public void clearTextField() {
      } 
    
}
