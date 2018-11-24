package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameGUI extends Application {
	GuiController guiController;
	BorderPane mainPane;
	VBox leftPane, centerPane, rightPane;
	HBox topPane, bottomPane;
	
	final private int guiHeight = 700; 
	final private int guiWidth = 1000; 

	
	Label lbTop, lbRmDesc, lbUserResponse, lbHp, lbGem, lbWeapon, lbDirection, lbExit, lbIsPuzzle, lbIsMonster, LbIsItem;
	TextField txtUserInput;
	
	static String roomDesc;
	
	String hP = "";
	String gem = " ";
	String weapon = " ";
	static String direction, exits, errorMessage, userResponse;
	static boolean isPuzzle, isMonster, isItem;
    

	@Override
	public void start(Stage stage) throws Exception {
		guiController = new GuiController();
	    guiController.setGameData();
		mainPane = new BorderPane();
		leftPane = new VBox();
		centerPane = new VBox();
		rightPane = new VBox();
		topPane = new HBox();
		bottomPane = new HBox();
		
		lbTop  = new Label("CITADEL OF STORMS");
		topPane.setAlignment(Pos.BASELINE_CENTER);
		topPane.getChildren().add(lbTop);
		
		
		txtUserInput = new TextField();
		//txtUserInput.setPrefColumnCount(5);
		//txtUserInput.setPrefRowCount(1);
		
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
		centerPane.getChildren().addAll(lbRmDesc, lbExit, lbIsPuzzle, lbIsMonster, LbIsItem, lbDirection,  txtUserInput );
		centerPane.setMargin(lbRmDesc, new Insets(5));
		centerPane.setMargin(lbExit, new Insets(5));
		centerPane.setMargin(lbDirection, new Insets(5));
		centerPane.setMargin(txtUserInput, new Insets(5));
		centerPane.setMargin(lbIsMonster, new Insets(5));
		centerPane.setMargin(lbIsPuzzle, new Insets(5));
		centerPane.setMargin(LbIsItem, new Insets(5));
		
		//centerPane.setAlignment(Pos.BASELINE_CENTER);
		
		
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
		
		
		//Thede lines must come last
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
	
	public void setRoomDesc(String roomDesc) {
		GameGUI.roomDesc = roomDesc;
	}
	public void setExit(String exits) {
		GameGUI.exits = exits;
	}
	public void setUserResponse(String userResponse) {
		GameGUI.userResponse = userResponse;
	}
	
	
	
	public static void main(String [] args) {
		Application.launch(args);
	}

	
	
}
