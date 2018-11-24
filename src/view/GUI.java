package view;

import java.io.IOException;


import controller.PuzzleController;
import controller.RoomController;
import controller.MonsterController;
import controller.ItemController;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;

public class GUI extends Application{
	

    

   private boolean gamestateActive;
   private int currentRoom;
   private int buttonClicked;
   final private int windowWidth = 1000; // width of Window
    final private int windowHeight = 700; //height of window
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
   HBox hpControlMenu;
   Label lbHistory;
   Label lbNavigation;
   Button btLaunchCM;
   Button btViewInstructions;
   Button btNav;
   HBox hbControlMenu;
   SplitMenuButton btPuzzleMenu;
   SplitMenuButton btMonsterMenu;
   SplitMenuButton btItemMenu;
   Button btDetails;
   Button btClearNav;
   ActionEvent event;
   Button btClearDetails;
   String playerName,roomTitle,  floorTitle, nav,  roomDesc, monster, attackStat, roomItem,  roomExits, puzzle,txtC; // This controls the item displayed in the center of the game console. We need to assign values form the room class to these once and them pain them in the center VBox.
   int  playerHealth;
   MenuItem miHint, miSolve, miReatttempt, miIgnore, miFlee, miAttack, miDefend, miRunAway, miEquip, miUnequip, miBuy, miSell;
   String menuItemClicked = "";
  

   boolean gamestateActive;

   
   public static final ObservableList<String> data = FXCollections.observableArrayList();
   final private int windowWidth = 1500; 
   final private int windowHeight = 900; 
   VBox vbCenter, vbRight, vbLeft; 
   GridPane gpNav;  
   HBox hbTop, hbBottom;  
   Label lbTitle; // 
   Insets insets; // 
   BorderPane borderPane;
   Button btNorth, btEast, btSouth, btWest, btLaunchCM,btViewInstructions, btUpperFloor, btLowerFloor, btNav, btDetails, btClearNav, btClearDetails, btExit;
   HBox hbWestEast, hpControlMenu, hbControlMenu;
   Label lbHistory, lbNavigation;
   SplitMenuButton btPuzzleMenu, btMonsterMenu, btItemMenu;
   MenuItem miHint, miSolve, miReatttempt, miIgnore, miFlee, miAttack, miDefend, miRunAway, miEquip, miUnequip, miBuy, miSell;
   String playerName,roomTitle,  floorTitle, nav,  roomDesc, monster, attackStat, roomItem,  roomExits, puzzle,txtC; // This controls the item displayed in the center of the game console. We need to assign values form the room class to these once and them pain them in the center VBox.
   int  playerHealth, currentRoom, buttonClicked;
   String lvPlayerName, lvRoomId, menuItemClicked = "";
   Text  txtErrorMsg;
   GUIController gUIController;
   VBox vbPlayField;     
   ListView<String> listView;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
			RoomController.setRoomFromText();
			PuzzleController.setPuzzleFromText();
			MonsterController.setMonsterFromText();
			ItemController.setItemFromText();
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		gamestateActive = false;
		nav = "default";
	   
	    
	    /*************Game, Player and NAvigation Begin***************/
	   
	
		
		/******Values that get printed on the canvas Begin*******/
		
		
		/********************Game, Player, and Navigation End***************************/
	    currentRoom = 1;
	   
		gUIController = new GUIController();
		txtErrorMsg = new Text();
		txtErrorMsg.setId("#txtErrorMsg");
		txtErrorMsg.setStrokeWidth(20);
		txtErrorMsg.setUnderline(true);
		
		
		txtErrorMsg.setFont(Font.font("Serif", FontPosture.ITALIC, 20));
		listView = new ListView<String>(data);
		listView.setPrefHeight(900.0);
		listView.setPrefWidth(350);
		//listView.setEditable(true);
		//listView.setPrefSize(200, 250);
		btNav = new Button("NAVIGATION");
		btDetails = new Button("GAME-HISTORY");
		btClearNav = new Button("Clear Navigation");
		btClearDetails = new Button("Clear Details");
		insets = new Insets(5,5, 5,5); //insets to set margin to nodes
		//Button btViewInstr = new Button("Create Account");
		//Button btLaunchCM = new Button("Create Account");
		btViewInstructions = new Button("View Instructions");
		btLaunchCM = new Button("Launch Command Menu");
		vbRight = new VBox();
		lbTitle = new Label("WELCOME TO CITADEl OF STORMS");
		lbHistory = new Label("GAME-HISTORY");
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
		miHint = new MenuItem("Hint");
		miSolve = new MenuItem("Solve");  
		miReatttempt = new MenuItem("Reattempt");  
		miIgnore = new MenuItem("Ignore");  
		miFlee = new MenuItem("Flee Combat");  
		miAttack = new MenuItem("Attack"); 
		miAttack.setOnAction(EventHandler ->{
			menuItemClicked = miAttack.getText();
		});
		miDefend = new MenuItem("Defend");  
		miRunAway = new MenuItem("");  
		miEquip = new MenuItem("Equip");  
		miUnequip = new MenuItem("Unequip");  
		miBuy = new MenuItem("Buy");  
		miSell =  new MenuItem("sell"); 
		
		hbControlMenu = new HBox(15);
		//hbControlMenu.getStyleClass().addAll("button");
		btPuzzleMenu = new SplitMenuButton();
				btPuzzleMenu.setText("Puzzle");
		btPuzzleMenu.getStyleClass().addAll("buttonSplit");
		btPuzzleMenu.getItems().addAll(miHint,miSolve, miReatttempt, miIgnore);


		btMonsterMenu = new SplitMenuButton();

		btMonsterMenu.setText("Monster");
		btMonsterMenu.getStyleClass().addAll("buttonSplit");
		btMonsterMenu.getItems().addAll(miAttack, miDefend, miFlee, miRunAway);
		btItemMenu = new SplitMenuButton();
		//System.out.println(		btItemMenu.getContextMenu().toString());
		miBuy.setOnAction(EventHandler ->{
			System.out.print("You just bought an item");
			
		});
		miAttack.setOnAction(EventHandler -> {
			menuItemClicked = miAttack.getText();
			if (monster.equals(MonsterController.getM1Monster().getMonsterName())) {
				playerHealth = playerHealth - Integer.parseInt(MonsterController.getM1Monster().getHealthLoss());
			}
			monster = menuItemClicked;
			System.out.print("You just clicked attack");
		
	  		borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster, roomItem,  roomExits, puzzle,  txtC));

		});
		miDefend.setOnAction(EventHandler -> {
			menuItemClicked = miDefend.getText();
			monster = menuItemClicked;
			System.out.print("You just clicked defend");
	  		borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster, roomItem,  roomExits, puzzle,  txtC));

		});
		miFlee.setOnAction(EventHandler -> {
			menuItemClicked = miFlee.getText();
			monster = menuItemClicked;
			System.out.print("You just clicked flee");
	  		borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster, roomItem,  roomExits, puzzle,  txtC));

		});
		miAttack.setOnAction(EventHandler -> {
			menuItemClicked = miAttack.getText();
			monster = menuItemClicked;
			playerHealth = 20 - Integer.parseInt(MonsterController.m3Monster.getHealthLoss());

			System.out.print("You just clicked attack");
	  		borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster, roomItem,  roomExits, puzzle,  txtC));

		});
	   if (menuItemClicked .equals(miAttack.getText())) {
		   monster = "You just clicked an attack button";
		   System.out.print("You just clicked attack and did sth...");
	   }

		btItemMenu.setText("Item");
		btItemMenu.getStyleClass().addAll("buttonSplit");
		btItemMenu.getItems().addAll(miEquip, miUnequip, miBuy, miSell);


		hbControlMenu.getChildren().addAll(btPuzzleMenu, btItemMenu, btMonsterMenu);

		hbTop = new HBox();
		hbTop.setPrefWidth(1.0);
		hbTop.getStyleClass().add("hbox-htTop");
		hbTop.getChildren().add(lbTitle);
		hbTop.setAlignment(Pos.CENTER);
		
		insets = new Insets(50, 10, 50, 10);
		gpNav = new GridPane();
		
		
		vbLeft = new VBox();
		lbHistory.setId("lbHistory");
		lbNavigation.setId("lbNavigation");
		//lbHistory.getStyleClass().addAll("hbox-htTop", "list-cell");
		
		 //This is where all the details of the player goes to.
		 listView.setItems(data);
		 listView.getStyleClass().addAll("hbox-htTop");
		
		
		//vbLeft.getChildren().addAll(lbHistory, listView);
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
      if(gamestateActive == false) {
    	  borderPane.setCenter(gUIController.showLoginScreen());
      }		
      else {
  		borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster, roomItem,  roomExits, puzzle,  txtC));

      }
		//borderPane.setCenter(controller.showLoginScreen());

		//System.out.println("Scene Print: " + playerName + " " + playerHealth+ " " + roomTitle+ " " +  floorTitle+ " " + roomDesc+ " " + monster+ " " + attackStat+ " " + roomItem+ " " +  roomExits+ " " + txtC);
		
		borderPane.setLeft(vbLeft);
		borderPane.setRight(vbRight);
		borderPane.setBottom(hbBottom);
		
		/*******Navigation buttons***********/
	
		
		btNorth.setOnAction(e -> {
			if (e.getSource() == btNorth) {	
				buttonClicked = 1;
				//setRoomDetails();
				//playerName = "Dan";
				//borderPane.setCenter(controller.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, txtC));
				gamestateActive = true;
				buttonClicked = 1; 
				roomDesc = RoomController.getRoomB1().getDescription();
			    roomTitle = RoomController.getRoomB1().getId();
				roomItem = RoomController.getRoomB1().getItem();
				roomExits = RoomController.getRoomB1().getExit();
				playerHealth = 20;
				playerName = "Elijah";
				//roomItem =  "You just bought an item";
				
				monster= RoomController.getRoomB1().getMonster();
				
				nav = btNorth.getText();
				borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits,puzzle,  txtC));
				 data.addAll(
					      "*************"  + "****************", "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster 			            
			        );
			}
			System.out.println("Clicked: "+ buttonClicked);
			System.out.println("CurrentRoom: "+ currentRoom);
			

			});
			
	    	
				
				
				
				
				
		
		
		btEast.setOnAction(e -> {
			if (e.getSource() == btEast) {	
			buttonClicked = 2;
			//setRoomDetails();
			 //Repeat for button clicks and change corrsponding values respectively --BEGIN
			/*gamestateActive = true;
			buttonClicked = 1; 
			roomDesc = RoomController.getRoomC2().getDescription();
		    roomTitle = RoomController.getRoomC2().getId();
			roomItem = RoomController.getRoomC2().getItem();
			roomExits = RoomController.getRoomC2().getExit();
			playerHealth = 20;
			playerName = "Elijah";
			monster= RoomController.getRoomB1().getMonster();
			nav = btEast.getText();
			borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, puzzle, txtC));
			 data.addAll(
				      "*************"  + "****************", "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster, "Puzzle: " + puzzle  		            
		        );*/
			
			roomDesc = RoomController.connectingChamberRoom.getDescription();
		    roomTitle = RoomController.connectingChamberRoom.getId();
		    monster = RoomController.connectingChamberRoom.getMonster();
			roomItem = RoomController.connectingChamberRoom.getItem();
			roomExits = RoomController.connectingChamberRoom.getExit();
			playerHealth = 20;
			playerName = "Elijah";
			nav = btEast.getText();
			puzzle = RoomController.connectingChamberRoom.getPuzzle();
			//puzzle="";
			
			txtC = " ";
			borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, puzzle, txtC));
			 data.addAll(
		              "Player-Name: "  + playerName, "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster 
		            
		        );
		}
		System.out.println("Clicked: "+ buttonClicked);
		System.out.println("CurrentRoom: "+ currentRoom);
		
		 //Repeat for button clicks and change corrsponding values respectively --END

		
			
			
			
		});
		btSouth.setOnAction(e -> {
			if (e.getSource() == btSouth) {	
				buttonClicked = 3;
				//setRoomDetails();
				 //Repeat for button clicks and change corrsponding values respectively --BEGIN
				gamestateActive = true;
				//buttonClicked = 1; 
				roomDesc = RoomController.getRoomC1().getDescription();
			    roomTitle = RoomController.getRoomC1().getId();
				roomItem = RoomController.getRoomC1().getItem();
				roomExits = RoomController.getRoomC1().getExit();
				playerHealth = 20;
				playerName = "Elijah";
				monster= RoomController.getRoomC1().getMonster();
				nav = btSouth.getText();
				borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, puzzle, txtC));
				 data.addAll(
					      "*************"  + "****************", "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster 			            
			        );
			}
			System.out.println("Clicked: "+ buttonClicked);
			System.out.println("CurrentRoom: "+ currentRoom);
			
			 //Repeat for button clicks and change corrsponding values respectively --END
				
			
		});
		btWest.setOnAction(e -> {
			if (e.getSource() == btWest) {	
				buttonClicked = 4;
				//setRoomDetails();
				 //Repeat for button clicks and change corrsponding values respectively --BEGIN
				/*gamestateActive = true;
				//buttonClicked = 1; 
				roomDesc = RoomController.getRoomA3().getDescription();
			    roomTitle = RoomController.getRoomA3().getId();
				roomItem = RoomController.getRoomA3().getItem();
				roomExits = RoomController.getRoomA3().getExit();
				playerHealth = 20;
				playerName = "Elijah";
				txtC = " ";
				monster= RoomController.getRoomA3().getMonster();
				nav = "W";
				borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, puzzle,  txtC));
				 data.addAll(
			              "*************"  + "****************", "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster 
			            
			        );*/

				roomDesc = RoomController.connectingChamberRoom.getDescription();
			    roomTitle = RoomController.connectingChamberRoom.getId();
			    monster = RoomController.connectingChamberRoom.getMonster();
				roomItem = RoomController.connectingChamberRoom.getItem();
				roomExits = RoomController.connectingChamberRoom.getExit();
				playerHealth = 20;
				playerName = "Elijah";
				nav = btEast.getText();
				puzzle = RoomController.connectingChamberRoom.getPuzzle();
				//puzzle="";
				
				txtC = " ";
				borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, puzzle, txtC));
				 data.addAll(
			              "Player-Name: "  + playerName, "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster 
			            
			        );
				
				
			}
			System.out.println("Clicked: "+ buttonClicked);
			System.out.println("CurrentRoom: "+ currentRoom);
			
			 //Repeat for button clicks and change corrsponding values respectively --END
		});
		
		
		btUpperFloor.setOnAction(e -> {
			if (e.getSource() == btUpperFloor) {	
				buttonClicked = 5;
				//setRoomDetails();
				roomDesc = "";
			    roomTitle = "";
				roomItem = "";
				roomExits = "";
				playerHealth = 20;
				playerName = "Elijah";
				txtC = "WRONG-TURN: NO EXIT HERE! ";
				monster= "";
				nav = btUpperFloor.getText();
				borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, puzzle, txtC));
				 data.addAll(
			              "*************"  + "****************", "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster 
			            
			        );
				
				borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle,nav,  roomDesc, monster, roomItem,  roomExits, puzzle,  txtC));

				System.out.println("Clicked: "+ buttonClicked);}
		});
        btLowerFloor.setOnAction(e -> {
        	if (e.getSource() == btLowerFloor) {	
				buttonClicked = 6;
				//setRoomDetails();
				roomDesc = RoomController.getNecromancerRoom().getDescription();
			    roomTitle = RoomController.getNecromancerRoom().getId();
				roomItem = RoomController.getNecromancerRoom().getItem();
				roomExits = RoomController.getNecromancerRoom().getExit();
				playerHealth = 20;
				playerName = "Elijah";
				txtC = " ";
				monster= RoomController.getNecromancerRoom().getMonster();
				nav = btLowerFloor.getText();
				borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, puzzle,  txtC));
				 data.addAll(
			              "*************"  + "****************", "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster 
			            
			        );
				borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav, roomDesc, monster,  roomItem,  roomExits, puzzle, txtC));

				System.out.println("Clicked: "+ buttonClicked);
				}
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
 
       gUIController.showGameDetails();	
		});
		

		btNav.setOnAction(e -> {
			gUIController.showGameNav() ;
		});
		
		btClearDetails.setOnAction(e -> {
			gUIController.clearGameDetails();
		});
		

		btClearNav.setOnAction(e -> {
			gUIController.clearGameNav() ;
		});
		
		btExit.setOnAction(EventHandler -> {
			HBox hbExit = new HBox();
			HBox hbExit2 = new HBox();
			VBox vbExit = new VBox();
			
			Button btCancelExit = new Button("Bye for now");
			Label lbExit = new Label("Game successfully exited...");
			lbExit.setId("lbExit");
			borderPane.getChildren().clear();
			hbExit.getChildren().add(lbExit);
			hbExit.setAlignment(Pos.BASELINE_CENTER);
			hbExit.setId("hbExit");
			hbExit2.getChildren().add(btCancelExit);
			hbExit2.setAlignment(Pos.BASELINE_CENTER);
			VBox.setMargin(hbExit, new Insets(8));
			VBox.setMargin(hbExit2, new Insets(8));
			vbExit.getChildren().addAll(hbExit);
			borderPane.setCenter(vbExit);
		});
		
		
		Scene scene = new Scene(borderPane, windowWidth, windowHeight); // set size of the windwo
		scene.getStylesheets().add(getClass().getResource("viewStyle.css").toExternalForm()); // Add your stylesheet to the GUI
		primaryStage.setTitle("Citadel_Of_Storms");
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("Game state " + gamestateActive);

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
	
	
	class GUIController{
		
	
		
		
		private Object handler;


		//THese are the methods that the button call whenever someting needs to get done....
		public void showGameDetails() {
			if(!gamestateActive ==false) {
				try {
					txtErrorMsg.setText("MESSAGE: Click Clear when done"); 
					vbLeft.getChildren().addAll( lbHistory, listView, txtErrorMsg);
				} catch (Exception e) {
					txtErrorMsg.setText("MESSAGE: Details is already active"); 
					System.out.println(e);
				}
			}
			

		}
		
	    public void showGameNav() {
	    if (!gamestateActive == false) {
	    	try {
	    		txtErrorMsg.setText("MESSAGE: Click Clear when done"); 

	    		
				vbRight.getChildren().addAll(lbNavigation,  hbControlMenu, btUpperFloor, gpNav, btLowerFloor, txtErrorMsg);
			}
	    	catch (Exception e) {

	    		txtErrorMsg.setText("MESSAGE: Nav. Bar is already active"); 
	    		e.printStackTrace();
	    		System.out.println(e);
		}
	    }
	    }
	    
	    public void clearGameDetails() {
			vbLeft.getChildren().clear();

		}
		
	    public void clearGameNav() {
			vbRight.getChildren().clear();

		}
	    
	    /* Login page for game player Begin*/
	    public VBox showLoginScreen() {
			VBox loginVBox = new VBox();
			loginVBox.setId("loginVBox");
			Label lbUserName = new Label("Username:");
			Label lbPassword = new Label("Password:");
			TextArea txtUserName = new TextArea();
			txtUserName.setPrefRowCount(1);
			txtUserName.setPrefColumnCount(15);
			txtUserName.setWrapText(false);
			txtUserName.setEditable(true);
			TextArea txtPassword = new TextArea();
			txtPassword.setPrefRowCount(1);
			txtPassword.setPrefColumnCount(15);
			txtPassword.setEditable(true);
			Button btLogin = new Button("Login");
			HBox top = new HBox();
			top.getChildren().addAll(lbUserName, txtUserName);
			HBox midA = new HBox();
			midA.getChildren().addAll(lbPassword, txtPassword);
			HBox midB = new HBox();
			HBox base = new HBox(btLogin);
			top.setAlignment(Pos.BASELINE_CENTER);
			midA.setAlignment(Pos.BASELINE_CENTER);
			midA.setAlignment(Pos.BASELINE_CENTER);
			base.setAlignment(Pos.BASELINE_CENTER);
			
			VBox.setMargin(top, new Insets(4));
			VBox.setMargin(midA, new Insets(4));
			VBox.setMargin(midB, new Insets(4));
			VBox.setMargin(base, new Insets(4));
			loginVBox.setSpacing(10);
			
			loginVBox.getChildren().addAll(top, midA, midB, base);
			
		
			
			btLogin.setOnAction(EventHandler -> {
				gamestateActive = true;
				buttonClicked = 1; 
				roomDesc = RoomController.entranceChamberRoom.getDescription();
			    roomTitle = RoomController.entranceChamberRoom.getId();
			    monster = RoomController.entranceChamberRoom.getMonster();
				roomItem = RoomController.entranceChamberRoom.getItem();
				roomExits = RoomController.entranceChamberRoom.getExit();
				playerHealth = 20;
				playerName = "Elijah";
				nav = btLogin.getText();
				puzzle = RoomController.entranceChamberRoom.getPuzzle();
				//puzzle="";
				
				txtC = " ";
				borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, puzzle, txtC));
				 data.addAll(
			              "Player-Name: "  + playerName, "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster 
			            
			        );
				 
				 //east of login page/screnn
				 btEast.setOnAction(e -> {
						if (e.getSource() == btEast) {	
						buttonClicked = 2;
						//setRoomDetails();
						 //Repeat for button clicks and change corrsponding values respectively --BEGIN
						/*gamestateActive = true;
						buttonClicked = 1; 
						roomDesc = RoomController.getRoomC2().getDescription();
					    roomTitle = RoomController.getRoomC2().getId();
						roomItem = RoomController.getRoomC2().getItem();
						roomExits = RoomController.getRoomC2().getExit();
						playerHealth = 20;
						playerName = "Elijah";
						monster= RoomController.getRoomB1().getMonster();
						nav = btEast.getText();
						borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, puzzle, txtC));
						 data.addAll(
							      "*************"  + "****************", "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster, "Puzzle: " + puzzle  		            
					        );*/
						
						roomDesc = RoomController.connectingChamberRoom.getDescription();
					    roomTitle = RoomController.connectingChamberRoom.getId();
					    monster = RoomController.connectingChamberRoom.getMonster();
						roomItem = RoomController.connectingChamberRoom.getItem();
						roomExits = RoomController.connectingChamberRoom.getExit();
						playerHealth = 20;
						System.out.println(MonsterController.m3Monster.getHealthLoss());
						playerName = "Elijah";
						nav = btEast.getText();
						puzzle = RoomController.connectingChamberRoom.getPuzzle();
						//puzzle="";
						
						txtC = " ";
						borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, puzzle, txtC));
						 data.addAll(
					              "Player-Name: "  + playerName, "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster 
					            
					        );
					}
					System.out.println("Clicked: "+ buttonClicked);
					System.out.println("CurrentRoom: "+ currentRoom);
					
					 //Repeat for button clicks and change corrsponding values respectively --END

					
						
						
						
					});
				 
				 //south of login screen
				 btSouth.setOnAction(e -> {
						if (e.getSource() == btSouth) {	
						buttonClicked = 2;
						//setRoomDetails();
						 //Repeat for button clicks and change corrsponding values respectively --BEGIN
						/*gamestateActive = true;
						buttonClicked = 1; 
						roomDesc = RoomController.getRoomC2().getDescription();
					    roomTitle = RoomController.getRoomC2().getId();
						roomItem = RoomController.getRoomC2().getItem();
						roomExits = RoomController.getRoomC2().getExit();
						playerHealth = 20;
						playerName = "Elijah";
						monster= RoomController.getRoomB1().getMonster();
						nav = btEast.getText();
						borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, puzzle, txtC));
						 data.addAll(
							      "*************"  + "****************", "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster, "Puzzle: " + puzzle  		            
					        );*/
						
						roomDesc = "";
					    roomTitle = "";
					    monster = "";
						roomItem = "";
						roomExits = "";
						playerHealth = 20;
						playerName = "Elijah";
						nav = btEast.getText();
						puzzle = "";
						//puzzle="";
						
						txtC = " NO EXIT HERE!";
						borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, puzzle, txtC));
						 data.addAll(
					              "Player-Name: "  + playerName, "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster 
					            
					        );
					}
					System.out.println("Clicked: "+ buttonClicked);
					System.out.println("CurrentRoom: "+ currentRoom);
					
					 //Repeat for button clicks and change corrsponding values respectively --END

					
						
						
						
					});
				 
				 //north of login screen
				 btNorth.setOnAction(e -> {
						if (e.getSource() == btSouth) {	
						buttonClicked = 2;
						//setRoomDetails();
						 //Repeat for button clicks and change corrsponding values respectively --BEGIN
						/*gamestateActive = true;
						buttonClicked = 1; 
						roomDesc = RoomController.getRoomC2().getDescription();
					    roomTitle = RoomController.getRoomC2().getId();
						roomItem = RoomController.getRoomC2().getItem();
						roomExits = RoomController.getRoomC2().getExit();
						playerHealth = 20;
						playerName = "Elijah";
						monster= RoomController.getRoomB1().getMonster();
						nav = btEast.getText();
						borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, puzzle, txtC));
						 data.addAll(
							      "*************"  + "****************", "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster, "Puzzle: " + puzzle  		            
					        );*/
						
						roomDesc = "";
					    roomTitle = "";
					    monster = "";
						roomItem = "";
						roomExits = "";
						playerHealth = 20;
						playerName = "Elijah";
						nav = btEast.getText();
						puzzle = "";
						//puzzle="";
						
						txtC = " NO EXIT HERE!";
						borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, puzzle, txtC));
						 data.addAll(
					              "Player-Name: "  + playerName, "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster 
					            
					        );
					}
					System.out.println("Clicked: "+ buttonClicked);
					System.out.println("CurrentRoom: "+ currentRoom);
					
					 //Repeat for button clicks and change corrsponding values respectively --END

					
						
						
						
					});
				 
				 //west of login screen
				 btWest.setOnAction(e -> {
						if (e.getSource() == btSouth) {	
						buttonClicked = 2;
						//setRoomDetails();
						 //Repeat for button clicks and change corrsponding values respectively --BEGIN
						/*gamestateActive = true;
						buttonClicked = 1; 
						roomDesc = RoomController.getRoomC2().getDescription();
					    roomTitle = RoomController.getRoomC2().getId();
						roomItem = RoomController.getRoomC2().getItem();
						roomExits = RoomController.getRoomC2().getExit();
						playerHealth = 20;
						playerName = "Elijah";
						monster= RoomController.getRoomB1().getMonster();
						nav = btEast.getText();
						borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, puzzle, txtC));
						 data.addAll(
							      "*************"  + "****************", "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster, "Puzzle: " + puzzle  		            
					        );*/
						
						roomDesc = "";
					    roomTitle = "";
					    monster = "";
						roomItem = "";
						roomExits = "";
						playerHealth = 20;
						playerName = "Elijah";
						nav = btEast.getText();
						puzzle = "";
						//puzzle="";
						
						txtC = " NO EXIT HERE!";
						borderPane.setCenter(gUIController.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, puzzle, txtC));
						 data.addAll(
					              "Player-Name: "  + playerName, "Visited-Room ID: " + roomTitle, "HealthPoint: " + playerHealth, "Monster: " + monster 
					            
					        );
					}
					System.out.println("Clicked: "+ buttonClicked);
					System.out.println("CurrentRoom: "+ currentRoom);
					
					 //Repeat for button clicks and change corrsponding values respectively --END

					
						
						
						
					});

			});
			
	    	return loginVBox;
	    }
	    /* Login page for game player True*/

	    
	    public VBox getVBox(String playerName, int playerHealth, String roomTitle, String  floorTitle, String nav, String roomDesc, String monster, String roomItem, String roomExits, String puzzle, String txtC) {
	    	
	    	
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
	    	HBox hbPuzzle = new HBox();
	    	hbPuzzle.setAlignment(Pos.CENTER);
	    	HBox baseC = new HBox();
	    	baseC.setAlignment(Pos.CENTER);
	    	
	    	
	    	
	    
	    	
	    	
			VBox vbPlayField = new VBox();
			vbPlayField.setId("playField");
			
			Label playerDetails = new Label("PLAYER: " + playerName + " || Current HP: "  + playerHealth);
			playerDetails.setId("playerDetails");
			//nav = "default";
			
		
			//Label roomHeader = new Label("Room: " +roomTitle + " || Floor: "  + floorTitle + " || NAV. Clicked: " + nav );
			Label roomHeader = new Label("Room: " +roomTitle + " || Current-Navigation: " + nav );

			roomHeader.setId("roomHeader");
			
			Label roomDesctn = new Label("DESCRIPTION:::::::: " + roomDesc);
			roomDesctn.setId("roomDesctn");
			Label monstDesc = new Label("Monster: " + monster);
			monstDesc.setId("monstDesc");
			Label attackStatus = new Label("Attack Status: " + attackStat);
			attackStatus.setId("attackStatus");
			
			Label lbroomItem = new Label("Item: " + roomItem);
			lbroomItem.setId("textA");
			Label textB = new Label("Valid_Exit-RoomIDs: " + roomExits);
			textB.setId("textB");
			Label lbPuzzle = new Label("Puzzle: " + puzzle);
			lbPuzzle.setId("textC");
			Label textC = new Label(" " + txtC);
			textC.setId("textC");
			
			topX.getChildren().add(playerDetails);
			top.getChildren().add(roomHeader);
			topB.getChildren().add(roomDesctn);
			mid.getChildren().add(monstDesc);
			base.getChildren().add(attackStatus);
			baseA.getChildren().add(lbroomItem);
			baseB.getChildren().add(textB);
			hbPuzzle.getChildren().add(lbPuzzle);
			baseC.getChildren().add(textC);
			vbPlayField.getChildren().addAll(topX, top, topB, mid,  baseA, baseB, hbPuzzle, baseC);
			VBox.setMargin(topX, new Insets(4));
			VBox.setMargin(top, new Insets(4));
			VBox.setMargin(topB, new Insets(4));
			VBox.setMargin(mid, new Insets(4));
			VBox.setMargin(base, new Insets(4));
			VBox.setMargin(baseA, new Insets(4));
			VBox.setMargin(baseB, new Insets(4));
			VBox.setMargin(baseC, new Insets(4));
			System.out.println("Game state " + gamestateActive);
			
	    
			
		
	    return vbPlayField;
	    	
	    }
		
		
	}
	
	
	
	
	
   
	
}
