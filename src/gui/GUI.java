package gui;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class GUI extends Application{
	private int buttonCliked;
   final private int windowWidth = 1500; // width of Window
    final private int windowHeight = 900; //height of window
   VBox vbCenter; // vertical pane in the center of the window's borderPane
   VBox vbLeft;  // vertical pane in the left  of the window's borderPane
   GridPane gpNav;  // grid pane to palce the navigation option east , west , north, and south
   VBox vbRight;//Right side of the game windows
   HBox hbTop;  // horizontal pane in the top of the window's borderPane
   HBox hbBottom; // horizontal pane in the bottom of the window's borderPane
   Label lbTitle; // label for game title
   Insets insets; // insets to create margin or padding aroung node items
   BorderPane borderPane; // main border Pane to display the window
   Button btExit; //exit button for each room
   Button btNorth;
   Button btEast;
   HBox hbWestEast;
   Button btSouth;
   Button btWest;
   Button btUpperFloor;
   Button btLowerFloor;
   Label lbDetails;
   Label lbNavigation;
   Button btLaunchCM;
   Button btViewInstructions;
   Button btNav;
   Button btDetails;
   Button btClearNav;
   Button btClearDetails;
   String playerName,roomTitle,  floorTitle, roomDesc, monster, attackStat, txtA,  txtB, txtC; // This controls the item displayed in the center of the game console. We need to assign values form the room class to these once and them pain them in the center VBox.
   int  playerHealth;
  
   Text  txtErrorMsg;
   public static final ObservableList<String> data = 
   FXCollections.observableArrayList();
   Controller controller;
   VBox vbPlayField;
	       
   ListView<String> listView;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//vbPlayField = controller.getVBox();
	
		controller = new Controller();
		txtErrorMsg = new Text();
		txtErrorMsg.setId("#txtErrorMsg");
		txtErrorMsg.setStrokeWidth(20);
		txtErrorMsg.setUnderline(true);
		
		//txtErrorMsg.setFont(Font.font("Serif", FontWeight.LIGHT,20 ));
		txtErrorMsg.setFont(Font.font("Serif", FontPosture.ITALIC, 20));
		listView = new ListView<String>(data);
		listView.setPrefHeight(900.0);
		listView.setPrefWidth(350);
		//listView.setEditable(true);
		//listView.setPrefSize(200, 250);
		btNav = new Button("NAVIGATION");
		btDetails = new Button("GAME-DETAILS");
		btClearNav = new Button("Clear Navigation");
		btClearDetails = new Button("Clear Details");
		insets = new Insets(5,5, 5,5); //insets to set margin to nodes
		//Button btViewInstr = new Button("Create Account");
		//Button btLaunchCM = new Button("Create Account");
		btViewInstructions = new Button("View Instructions");
		btLaunchCM = new Button("Launch Command Menu");
		vbRight = new VBox();
		lbTitle = new Label("WELCOME TO CITADEl OF STORMS");
		lbDetails = new Label("GAME-DETAILS");
		lbNavigation =  new Label("NAVIGATION");
		btExit = new Button("EXIT");
		btNorth = new Button("N");
		btNorth.setAlignment(Pos.BASELINE_CENTER);
		btEast = new Button("E");
		btSouth = new Button("S");
		btWest = new Button("W");
		btNorth.setId("btnorth-button");
		btEast.setId("bteast-button");
		btSouth.setId("btsouth-button");
		btWest.setId("btwest-button");
		hbWestEast = new HBox();
		hbWestEast.getChildren().addAll(btWest, btEast);
		hbWestEast.setSpacing(20);
		hbWestEast.setAlignment(Pos.BASELINE_LEFT);
		btUpperFloor = new Button("Upper-Floor");
		btLowerFloor = new Button("Lower-Floor");
		
	
		hbTop = new HBox();
		hbTop.setPrefWidth(1.0);
		hbTop.getStyleClass().add("hbox-htTop");
		hbTop.getChildren().add(lbTitle);
		hbTop.setAlignment(Pos.CENTER);
		
		insets = new Insets(50, 10, 50, 10);
		gpNav = new GridPane();
		
		
		vbLeft = new VBox();
		lbDetails.setId("lbDetails");
		lbNavigation.setId("lbNavigation");
		//lbDetails.getStyleClass().addAll("hbox-htTop", "list-cell");
		
		 data.addAll(
		              "Username:", "Curren-Room: ", "HealthPoint: ", "Gems:", "Moster defeated:"
		            
		        ); //This is where all the details of the player goes to.
		 listView.setItems(data);
		 listView.getStyleClass().addAll("hbox-htTop");
		
		
		//vbLeft.getChildren().addAll(lbDetails, listView);
		vbLeft.getStyleClass().addAll("hbox-htTop", "vbox-vbLeft");
		
		//gpRight.getChildren().addAll(btNorth,hbWestEast, btSouth);
		//gpRight.setSpacing(20);
		GridPane.setConstraints(btNorth, 1, 0);
		GridPane.setConstraints(btSouth, 1, 2);
		GridPane.setConstraints(btWest, 0, 1);
		GridPane.setConstraints(btEast, 2, 1);
		gpNav.getChildren().addAll(btNorth, btSouth, btWest, btEast);

		gpNav.setPadding(insets);
		gpNav.setAlignment(Pos.BASELINE_CENTER);
		
		
		hbBottom = new HBox();
		//hbBottom.setSpacing(200);
		//hbBottom.setPadding(new Insets (50,50,50,50));
		//HBox.setMargin(hbBottom, new Insets(200,0,200,200));
		hbBottom.getStyleClass().addAll("hbox-htTop", "hbox-hbBottom");
		hbBottom.getChildren().addAll(btDetails,btClearDetails, btLaunchCM, btViewInstructions, btExit, btNav, btClearNav);
		hbBottom.setAlignment(Pos.CENTER);
		
		
		vbRight = new VBox();
		//vbRight.getChildren().addAll(lbNavigation, btUpperFloor, gpNav, btLowerFloor);
		vbRight.getStyleClass().addAll("hbox-htTop", "vbox-vbRight");
		//vbRight.setMargin(btUpperFloor, insets);
		
		
		borderPane = new BorderPane();
		borderPane.getStyleClass().add("borderPane");
		borderPane.setTop(hbTop);
		borderPane.setCenter(controller.getVBox(playerName, playerHealth, roomTitle,  floorTitle, roomDesc, monster, attackStat, txtA,  txtB, txtC));
		borderPane.setLeft(vbLeft);
		borderPane.setRight(vbRight);
		borderPane.setBottom(hbBottom);
		
		/*******Navigaition buttons***********/
	
		
		btNorth.setOnAction(e -> {
			if (e.getSource() == btNorth) {	
				buttonCliked = 1;
				System.out.println("Clicked: "+ buttonCliked);}	
		});
		
		btEast.setOnAction(e -> {
			if (e.getSource() == btEast) {	
			buttonCliked = 2;
			System.out.println("Clicked: "+ buttonCliked);}
		});
		btSouth.setOnAction(e -> {
			if (e.getSource() == btSouth) {	
				buttonCliked = 3;
				System.out.println("Clicked: "+ buttonCliked);}
		});
		btWest.setOnAction(e -> {
			if (e.getSource() == btWest) {	
				buttonCliked = 4;
				System.out.println("Clicked: "+ buttonCliked);}
		});
		
		
		btUpperFloor.setOnAction(e -> {
			if (e.getSource() == btUpperFloor) {	
				buttonCliked = 200;
				System.out.println("Clicked: "+ buttonCliked);}
		});
        btLowerFloor.setOnAction(e -> {
        	if (e.getSource() == btLowerFloor) {	
				buttonCliked = 100;
				System.out.println("Clicked: "+ buttonCliked);}
		});
		/*******Navigaition buttons***********/
		
		
		btDetails.setOnAction(e -> {
			//System.out.println( ((Button) e.getSource()));
	/*		
       if (e.getSource() == btDetails) {	
	    buttonCliked = 1;
	    System.out.println("Clicked: "+ buttonCliked);
	 
			
			//System.out.println(btDetails.getId());
			
      }
  */
 
       controller.showGameDetails();	
		});
		

		btNav.setOnAction(e -> {
			controller.showGameNav() ;
		});
		
		btClearDetails.setOnAction(e -> {
			controller.clearGameDetails();
		});
		

		btClearNav.setOnAction(e -> {
			controller.clearGameNav() ;
		});
		
		
		
		Scene scene = new Scene(borderPane, windowWidth, windowHeight); // set size of the windwo
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		primaryStage.setTitle("Citadel_Of_Storms");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false); // disallow increasing window size
		
		
		
	}
	public int getButtonClicked() {
		Button checker = new Button();
		int buttonClicked = 0;
	
		
		return buttonClicked;
		
	}
	
	public static void main(String [] args) {
		Application.launch(args);
	}
	
	
	class Controller{
		
		//THese are the methods that the button call whenever someting needs to get done....
		public void showGameDetails() {
			try {
				txtErrorMsg.setText("MESSAGE: Click Clear when done"); 
				vbLeft.getChildren().addAll( lbDetails, listView, txtErrorMsg);
			} catch (Exception e) {
				txtErrorMsg.setText("MESSAGE: Details is already active"); 
				System.out.println(e);
			}
			

		}
		
	    public void showGameNav() {
	    	try {
	    		txtErrorMsg.setText("MESSAGE: Click Clear when done"); 
	    		vbRight.getChildren().addAll(lbNavigation, btUpperFloor, gpNav, btLowerFloor, txtErrorMsg);
			}
	    	catch (Exception e) {

	    		txtErrorMsg.setText("MESSAGE: Nav. Bar is already active"); 
	    		
	    		System.out.println(e);
		}
	    }
	    
	    public void clearGameDetails() {
			vbLeft.getChildren().clear();

		}
		
	    public void clearGameNav() {
			vbRight.getChildren().clear();

		}
	    
	    public VBox getVBox(String playerName, int playerHealth, String roomTitle, String  floorTitle, String roomDesc, String monster, String attackStat, String txtA, String txtB, String txtC) {
	    	String roomDescription =  "";
	    	//Room room = new Room(roomDescription);
	    	HBox topX = new HBox();
	    	topX.setAlignment(Pos.CENTER);
	    	HBox top = new HBox();
	    	top.setAlignment(Pos.CENTER);
	    	HBox topB = new HBox();
	    	topB.setAlignment(Pos.CENTER);
	    	HBox mid = new HBox();
	    	mid.setAlignment(Pos.CENTER);
	    	HBox base = new HBox();
	    	base.setAlignment(Pos.CENTER);
	    	
	    	HBox baseA = new HBox();
	    	baseA.setAlignment(Pos.CENTER);
	    	HBox baseB = new HBox();
	    	baseB.setAlignment(Pos.CENTER);
	    	HBox baseC = new HBox();
	    	baseC.setAlignment(Pos.CENTER);
	    	
	    	
	    	
			VBox vbPlayField = new VBox();
			vbPlayField.setId("playField");
			
			Label playerDetails = new Label("Player: " + playerName + " || HealthPoint: "  + playerHealth);
			playerDetails.setId("playerDetails");
			
		
			Label roomHeader = new Label("Room: " +roomTitle + " || Floor: "  + floorTitle);
			roomHeader.setId("roomHeader");
			
			Label roomDesctn = new Label("Room Desc: " + roomDesc);
			roomDesctn.setId("roomDesctn");
			Label monstDesc = new Label("Monster Desc: " + monster);
			monstDesc.setId("monstDesc");
			Label attackStatus = new Label("Attack Status: " + attackStat);
			attackStatus.setId("attackStatus");
			
			Label textA = new Label("TextA: " + txtA);
			textA.setId("textA");
			Label textB = new Label("TextB: " + txtB);
			textB.setId("textB");
			Label textC = new Label("TextC: " + txtC);
			textC.setId("textC");
			
			topX.getChildren().add(playerDetails);
			top.getChildren().add(roomHeader);
			topB.getChildren().add(roomDesctn);
			mid.getChildren().add(monstDesc);
			base.getChildren().add(attackStatus);
			baseA.getChildren().add(textA);
			baseB.getChildren().add(textB);
			baseC.getChildren().add(textC);
			vbPlayField.getChildren().addAll(topX, top, topB, mid, base, baseA, baseB, baseC);
			VBox.setMargin(topX, new Insets(4));
			VBox.setMargin(top, new Insets(4));
			VBox.setMargin(topB, new Insets(4));
			VBox.setMargin(mid, new Insets(4));
			VBox.setMargin(base, new Insets(4));
			VBox.setMargin(baseA, new Insets(4));
			VBox.setMargin(baseB, new Insets(4));
			VBox.setMargin(baseC, new Insets(4));
			return vbPlayField;
			
			
	    	
	    }
		
		
	}
	
	
	
   
	
}
