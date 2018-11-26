package game_object2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import com.sun.javafx.stage.EmbeddedWindow;

import controller.CitadelController;
import controller.ItemController;
import controller.MonsterController;
import controller.PuzzleController;
import controller.RoomController;

public class GuiController {
	String [] userOPtions = {"N", "E", "S", "W", "I", "P", "M"};
	int iUserOption = 0;// 1, 2, 3, 4, 5, 6, 7; for each of  the above values we are adding 1 to their index
	Button submitButton = new Button("Submit");
	Boolean isPuzzle = false;
	Boolean isItem = false;
	Boolean isMonster = false;
	CitadelController citadelController = new CitadelController();
	GameGUI gameGUI;
	String userInputFromTextField = ""; 
	String messageToPrint = "";
	TextField tfUserInputFromGui = new TextField();
	Label lbRoomDesc = new Label();

	String roomDescription, exits, riddle, monster, item = " ";

	public GuiController() {
		

	}

	public void linkDataBackToGui() throws IOException {

		referenceAllControllers();
		referenceDataFromGameGui();
		setSpecificDataAccordingToRoom();
	}

	

	public void referenceDataFromGameGui() {
		
		getUserInputFromField();
		gameGUI = new GameGUI();
		gameGUI.setRoomDesc(roomDescription);
		gameGUI.setBtSubmitUserInput(submitButton);
		gameGUI.setExits(exits);
		gameGUI.setUserResponse(messageToPrint);
		gameGUI.setTxtUserInput(tfUserInputFromGui);
		lbRoomDesc = gameGUI.getLbRmDesc();
		
		
	
		//gameGUI.setUserInputFromTestField(userInputFromTextField);
		
	}

	public void referenceAllControllers() throws IOException {
		RoomController.setRoomFromText(); // This set the model Room ready with all the data needed on the GUI
		PuzzleController.setPuzzleFromText(); // this sets the model Puzzle ready with all the data needed on the GUI
		ItemController.setItemFromText(); // this sets the model Item readt for all the data needed for the GUI(view) to
											// run
		MonsterController.setMonsterFromText(); // this sets all the data needed for the model Monster

	}
	public void setSpecificDataAccordingToRoom() throws IOException {
		citadelController.setAllRoomDetails();
		tfUserInputFromGui.setPromptText("Enter your input & click submit to validate");
		tfUserInputFromGui.setPrefColumnCount(30);
		getUserInputFromField(); //get what the user enter after they click submit, verify to makesure its a string or send error message to the user.
		
		
		//print text according to what user entered
		//beginning entrance room
		if (iUserOption == 0 ) {
			//roomDescription = RoomController.entranceChamberRoom.getDescription();
			//GameGUI.roomDesc = RoomController.entranceChamberRoom.getDescription();
			//exits = RoomController.entranceChamberRoom.getExit();
			gameGUI.setRoomDesc(roomDescription);
			lbRoomDesc.setText("Test1");


		}
		//go to connecting chambers
		else if (iUserOption == 1) {
			roomDescription = RoomController.connectingChamberRoom.getDescription();
			exits = RoomController.connectingChamberRoom.getExit();
			gameGUI.setRoomDesc(roomDescription);
			lbRoomDesc.setText("Test1");

		}
		else if (iUserOption == 2) {
			roomDescription = RoomController.roomA1.getDescription();
			exits = RoomController.roomA1.getExit();
			lbRoomDesc.setText("Test2");
		}
		
	}
	
	
	public void getUserInputFromField() {
		
	 submitButton.setOnAction(new EventHandler<ActionEvent>() {
		 
@Override
    public void handle(ActionEvent e) {
        if ((tfUserInputFromGui.getText() != null && !tfUserInputFromGui.getText().isEmpty())) {
           userInputFromTextField = tfUserInputFromGui.getText().toUpperCase();
           messageToPrint = userInputFromTextField.toUpperCase();
            tfUserInputFromGui.setText(messageToPrint);
            getUserOption();
            referenceDataFromGameGui();
            System.out.println(userInputFromTextField);
            try {
				setSpecificDataAccordingToRoom();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
            
           
        } else {
        	messageToPrint = "No input!!!";
        	tfUserInputFromGui.setText(messageToPrint);
            referenceDataFromGameGui();
        }
        
        referenceDataFromGameGui();
        try {
			linkDataBackToGui();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      
     }

 });
	 getUserOption();

	
		
	}
	
	public void getUserOption() {
		
		for (int i = 0; i < userOPtions.length; i++) {
			if (userInputFromTextField.equals("N")) {

				iUserOption = 1;
				
			}
			if (userInputFromTextField.equals("E")) {

				iUserOption = 2;
			}
			if (userInputFromTextField.equals("S")) {

				iUserOption = 3;
			}
			if (userInputFromTextField.equals("W")) {

				iUserOption = 4;
			}
			if (userInputFromTextField.equals("I")) {

				iUserOption = 5;
			}
			if (userInputFromTextField.equals("P")) {

				iUserOption = 6;
			}
			if (userInputFromTextField.equals("M")) {

				iUserOption = 7;
			}
		}
		
		System.out.println(userInputFromTextField + " is user input & " + iUserOption + " is button clicked value");
		System.out.println(roomDescription);
		
	}
	
}
