package gui;

import java.io.IOException;

import game_object.*;
import game_object2.Item;
import game_object2.RoomController;
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
import javafx.scene.layout.Priority;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class GUI extends Application{
	
	private Navigationn navigationn = new Navigationn();

    private Roomm roomm;
    private Player player;
   private boolean gamestateActive;
	private int currentRoom;
	private int buttonClicked;
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
   Label lbHistory;
   Label lbNavigation;
   Button btLaunchCM;
   Button btViewInstructions;
   Button btNav;
   Button btDetails;
   Button btClearNav;
   Button btClearDetails;
   String playerName,roomTitle,  floorTitle, nav,  roomDesc, monster, attackStat, roomItem,  roomExits, txtC; // This controls the item displayed in the center of the game console. We need to assign values form the room class to these once and them pain them in the center VBox.
   int  playerHealth;
  
   
   String lvPlayerName, lvRoomId;
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
		//Reference the RoomCOntroller and set up values from the text file Room.txt
		try {
			RoomController.setPuzzleFromText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			String errorMessage = "Error writing from file : Puzzle.txt";
			e.printStackTrace();
			System.out.println(errorMessage);
			
		}
		System.out.println("From: " + RoomController.class.getName());
	    System.out.println(RoomController.getRoomA2().getDescription());//testing the get method from the Room class to see if an object is actually created. You can aslo change the filed to whicheevr you want. 

		
	   // lvRoomId = new String();
		gamestateActive = false;
		nav = "default";
	    navigationn = new Navigationn(); // instance of Navigation
	    roomm = new Roomm(); // instance of Room
	    player = new Player(); // instance of Player
	    /*************Game, Player and NAvigation Begin***************/
	   
	
		
		/******Values that get printed on the canvas Begin*******/
		
		
		/********************Game, Player, and Navigation End***************************/
	    currentRoom = 1;
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
    	  borderPane.setCenter(controller.showLoginScreen());
      }		
      else {
  		borderPane.setCenter(controller.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster, roomItem,  roomExits, txtC));

      }
		//borderPane.setCenter(controller.showLoginScreen());

		System.out.println("Scene Print: " + playerName + " " + playerHealth+ " " + roomTitle+ " " +  floorTitle+ " " + roomDesc+ " " + monster+ " " + attackStat+ " " + roomItem+ " " +  roomExits+ " " + txtC);
		
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
				monster= RoomController.getRoomB1().getItem();
				nav = btNorth.getText();
				borderPane.setCenter(controller.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, txtC));
				 data.addAll(
					      "*************"  + "****************", "Curren-Room: " + roomTitle, "HealthPoint: " + playerHealth, "Moster: " + monster 			            
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
			gamestateActive = true;
			buttonClicked = 1; 
			roomDesc = RoomController.getRoomC2().getDescription();
		    roomTitle = RoomController.getRoomC2().getId();
			roomItem = RoomController.getRoomC2().getItem();
			roomExits = RoomController.getRoomC2().getExit();
			playerHealth = 20;
			playerName = "Elijah";
			monster= RoomController.getRoomB1().getItem();
			nav = btEast.getText();
			borderPane.setCenter(controller.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, txtC));
			 data.addAll(
				      "*************"  + "****************", "Curren-Room: " + roomTitle, "HealthPoint: " + playerHealth, "Moster: " + monster 		            
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
				buttonClicked = 1; 
				roomDesc = RoomController.getRoomC1().getDescription();
			    roomTitle = RoomController.getRoomC1().getId();
				roomItem = RoomController.getRoomC1().getItem();
				roomExits = RoomController.getRoomC1().getExit();
				playerHealth = 20;
				playerName = "Elijah";
				monster= RoomController.getRoomC1().getItem();
				nav = btSouth.getText();
				borderPane.setCenter(controller.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, txtC));
				 data.addAll(
					      "*************"  + "****************", "Curren-Room: " + roomTitle, "HealthPoint: " + playerHealth, "Moster: " + monster 			            
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
				gamestateActive = true;
				buttonClicked = 1; 
				roomDesc = RoomController.getRoomA3().getDescription();
			    roomTitle = RoomController.getRoomA3().getId();
				roomItem = RoomController.getRoomA3().getItem();
				roomExits = RoomController.getRoomA3().getExit();
				playerHealth = 20;
				playerName = "Elijah";
				monster= RoomController.getRoomA3().getItem();
				nav = "W";
				borderPane.setCenter(controller.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, txtC));
				 data.addAll(
			              "*************"  + "****************", "Curren-Room: " + roomTitle, "HealthPoint: " + playerHealth, "Moster: " + monster 
			            
			        );
			}
			System.out.println("Clicked: "+ buttonClicked);
			System.out.println("CurrentRoom: "+ currentRoom);
			
			 //Repeat for button clicks and change corrsponding values respectively --END
		});
		
		
		btUpperFloor.setOnAction(e -> {
			if (e.getSource() == btUpperFloor) {	
				buttonClicked = 5;
				setRoomDetails();
				borderPane.setCenter(controller.getVBox(playerName, playerHealth, roomTitle,  floorTitle,nav,  roomDesc, monster, roomItem,  roomExits, txtC));

				System.out.println("Clicked: "+ buttonClicked);}
		});
        btLowerFloor.setOnAction(e -> {
        	if (e.getSource() == btLowerFloor) {	
				buttonClicked = 6;
				setRoomDetails();
				borderPane.setCenter(controller.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav, roomDesc, monster,  roomItem,  roomExits, txtC));

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
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
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
	
	
	class Controller{
		
	
		
		
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
	    		vbRight.getChildren().addAll(lbNavigation, btUpperFloor, gpNav, btLowerFloor, txtErrorMsg);
			}
	    	catch (Exception e) {

	    		txtErrorMsg.setText("MESSAGE: Nav. Bar is already active"); 
	    		
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
				roomDesc = RoomController.getRoomA2().getDescription();
			    roomTitle = RoomController.getRoomA2().getId();
				roomItem = RoomController.getRoomA2().getItem();
				roomExits = RoomController.getRoomA2().getExit();
				playerHealth = 20;
				playerName = "Elijah";
				monster= RoomController.getRoomA2().getItem();
				nav = btLogin.getText();
				borderPane.setCenter(controller.getVBox(playerName, playerHealth, roomTitle,  floorTitle, nav,  roomDesc, monster,  roomItem,  roomExits, txtC));
				 data.addAll(
			              "Player-Name: "  + playerName, "Curren-Room: " + roomTitle, "HealthPoint: " + playerHealth, "Moster: " + monster 
			            
			        );

			});
			
	    	return loginVBox;
	    }
	    /* Login page for game player True*/

	    
	    public VBox getVBox(String playerName, int playerHealth, String roomTitle, String  floorTitle, String nav, String roomDesc, String monster, String roomItem, String roomExits, String txtC) {
	    	
	    	System.out.println(navigationn.toString());
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
			Label textB = new Label("Vaild_Exits-RoomID: " + roomExits);
			textB.setId("textB");
			Label textC = new Label("TextC: " + txtC);
			textC.setId("textC");
			
			topX.getChildren().add(playerDetails);
			top.getChildren().add(roomHeader);
			topB.getChildren().add(roomDesctn);
			mid.getChildren().add(monstDesc);
			base.getChildren().add(attackStatus);
			baseA.getChildren().add(lbroomItem);
			baseB.getChildren().add(textB);
			baseC.getChildren().add(textC);
			vbPlayField.getChildren().addAll(topX, top, topB, mid,  baseA, baseB, baseC);
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
	
	public void setRoomDetails() {
	
		switch (buttonClicked) {
		case 1:
			        
				    roomm.setRoomDesc("Description of room goes here");
					roomm.setAttackStat("being attacked...");
					roomm.setFloorTitle("Floor 1");
					roomm.setMonster("Very Big Monster");
					roomm.setRoomTitle("Room One");
					roomm.setRoomItem("Text a goes here...");
					roomm.setRoomExits("Text b goes here...");
					roomm.setTxtC("Text c goes here...");
					
					player.setPlayerName("Elijah");
					player.setPlayerHealth(20);
					
					
					navigationn.setRoomTitle(roomm.getRoomTitle());
					navigationn.setRoomm(roomm);
					navigationn.setFloorTitle(roomm.getFloorTitle());
					navigationn.setMonster(roomm.getMonster());
					navigationn.setPlayer(player);
					navigationn.setAttackStat(roomm.getAttackStat());
					navigationn.setPlayerHealth(player.getPlayerHealth());
					navigationn.setPlayerName(player.getPlayerName());
					navigationn.setRoomDesc(roomm.getRoomDesc());
					  /******Values that get printed on the canvas Begin*******/
					 playerName = navigationn.getPlayerName();
					 roomTitle = navigationn.getRoomTitle();
					 floorTitle  = navigationn.getFloorTitle();
					 roomDesc = navigationn.getRoomDesc();
					 monster = navigationn.getMonster();
					 attackStat = navigationn.getAttackStat();
					 roomItem = navigationn.getRoomItem();
					 roomExits = navigationn.getRoomExits();
					 txtC = navigationn.getTxtC();
					 nav = "N";
					
			break;
		    case 2:
 
			    roomm.setRoomDesc("Not known");
				roomm.setAttackStat("Not known");
				roomm.setFloorTitle("Not known");
				roomm.setMonster("Not known");
				roomm.setRoomTitle("Not known");
				roomm.setRoomItem("Not known");
				roomm.setRoomExits("Not known");
				roomm.setTxtC("Not known");
				
				 player.setPlayerHealth(20);
				
				navigationn.setRoomTitle(roomm.getRoomTitle());
				navigationn.setRoomm(roomm);
				navigationn.setFloorTitle(roomm.getFloorTitle());
				navigationn.setMonster(roomm.getMonster());
				navigationn.setPlayer(player);
				navigationn.setAttackStat(roomm.getAttackStat());
				navigationn.setPlayerHealth(player.getPlayerHealth());
				navigationn.setPlayerName(player.getPlayerName());
				navigationn.setRoomDesc(roomm.getRoomDesc());
				  /******Values that get printed on the canvas Begin*******/
				 playerName = navigationn.getPlayerName();
				 roomTitle = navigationn.getRoomTitle();
				 floorTitle  = navigationn.getFloorTitle();
				 roomDesc = navigationn.getRoomDesc();
				 monster = navigationn.getMonster();
				 attackStat = navigationn.getAttackStat();
				 roomItem = navigationn.getRoomItem();
				 roomExits = navigationn.getRoomExits();
				 txtC = navigationn.getTxtC();
				
				 nav = "E";
					break;
		case 3:
			    
			roomm.setRoomDesc("Not known");
			roomm.setAttackStat("Not known");
			roomm.setFloorTitle("Not known");
			roomm.setMonster("Not known");
			roomm.setRoomTitle("Not known");
			roomm.setRoomItem("Not known");
			roomm.setRoomExits("Not known");
			roomm.setTxtC("Not known");
			
			player.setPlayerHealth(20);
			
			navigationn.setRoomTitle(roomm.getRoomTitle());
			navigationn.setRoomm(roomm);
			navigationn.setFloorTitle(roomm.getFloorTitle());
			navigationn.setMonster(roomm.getMonster());
			navigationn.setPlayer(player);
			navigationn.setAttackStat(roomm.getAttackStat());
			navigationn.setPlayerHealth(player.getPlayerHealth());
			navigationn.setPlayerName(player.getPlayerName());
			navigationn.setRoomDesc(roomm.getRoomDesc());
			  /******Values that get printed on the canvas Begin*******/
			 playerName = navigationn.getPlayerName();
			 roomTitle = navigationn.getRoomTitle();
			 floorTitle  = navigationn.getFloorTitle();
			 roomDesc = navigationn.getRoomDesc();
			 monster = navigationn.getMonster();
			 attackStat = navigationn.getAttackStat();
			 roomItem = navigationn.getRoomItem();
			 roomExits = navigationn.getRoomExits();
			 txtC = navigationn.getTxtC();
			 
			 nav = "S";
			 break;
		     case 4:
			
			roomm.setRoomDesc("Not known");
			roomm.setAttackStat("Not known");
			roomm.setFloorTitle("Not known");
			roomm.setMonster("Not known");
			roomm.setRoomTitle("Not known");
			roomm.setRoomItem("Not known");
			roomm.setRoomExits("Not known");
			roomm.setTxtC("Not known");
			
			player.setPlayerHealth(20);
			
			navigationn.setRoomTitle(roomm.getRoomTitle());
			navigationn.setRoomm(roomm);
			navigationn.setFloorTitle(roomm.getFloorTitle());
			navigationn.setMonster(roomm.getMonster());
			navigationn.setPlayer(player);
			navigationn.setAttackStat(roomm.getAttackStat());
			navigationn.setPlayerHealth(player.getPlayerHealth());
			navigationn.setPlayerName(player.getPlayerName());
			navigationn.setRoomDesc(roomm.getRoomDesc());
			  /******Values that get printed on the canvas Begin*******/
			 playerName = navigationn.getPlayerName();
			 roomTitle = navigationn.getRoomTitle();
			 floorTitle  = navigationn.getFloorTitle();
			 roomDesc = navigationn.getRoomDesc();
			 monster = navigationn.getMonster();
			 attackStat = navigationn.getAttackStat();
			 roomItem = navigationn.getRoomItem();
			 roomExits = navigationn.getRoomExits();
			 txtC = navigationn.getTxtC();
			 
			 nav = "W";
			
			break;
			
		     case 5:
		    	 roomm.setRoomDesc("Not known");
					roomm.setAttackStat("Not known");
					roomm.setFloorTitle("Not known");
					roomm.setMonster("Not known");
					roomm.setRoomTitle("Not known");
					roomm.setRoomItem("Not known");
					roomm.setRoomExits("Not known");
					roomm.setTxtC("Not known");
					
					player.setPlayerHealth(20);
					
					navigationn.setRoomTitle(roomm.getRoomTitle());
					navigationn.setRoomm(roomm);
					navigationn.setFloorTitle(roomm.getFloorTitle());
					navigationn.setMonster(roomm.getMonster());
					navigationn.setPlayer(player);
					navigationn.setAttackStat(roomm.getAttackStat());
					navigationn.setPlayerHealth(player.getPlayerHealth());
					navigationn.setPlayerName(player.getPlayerName());
					navigationn.setRoomDesc(roomm.getRoomDesc());
					  /******Values that get printed on the canvas Begin*******/
					 playerName = navigationn.getPlayerName();
					 roomTitle = navigationn.getRoomTitle();
					 floorTitle  = navigationn.getFloorTitle();
					 roomDesc = navigationn.getRoomDesc();
					 monster = navigationn.getMonster();
					 attackStat = navigationn.getAttackStat();
					 roomItem = navigationn.getRoomItem();
					 roomExits = navigationn.getRoomExits();
					 txtC = navigationn.getTxtC();
					 
					 nav = "Upper-Floor";
					 break;
		     case 6:
		    	     roomm.setRoomDesc("Not known");
					roomm.setAttackStat("Not known");
					roomm.setFloorTitle("Not known");
					roomm.setMonster("Not known");
					roomm.setRoomTitle("Not known");
					roomm.setRoomItem("Not known");
					roomm.setRoomExits("Not known");
					roomm.setTxtC("Not known");
					
					player.setPlayerHealth(20);
					
					navigationn.setRoomTitle(roomm.getRoomTitle());
					navigationn.setRoomm(roomm);
					navigationn.setFloorTitle(roomm.getFloorTitle());
					navigationn.setMonster(roomm.getMonster());
					navigationn.setPlayer(player);
					navigationn.setAttackStat(roomm.getAttackStat());
					navigationn.setPlayerHealth(player.getPlayerHealth());
					navigationn.setPlayerName(player.getPlayerName());
					navigationn.setRoomDesc(roomm.getRoomDesc());
					  /******Values that get printed on the canvas Begin*******/
					 playerName = navigationn.getPlayerName();
					 roomTitle = navigationn.getRoomTitle();
					 floorTitle  = navigationn.getFloorTitle();
					 roomDesc = navigationn.getRoomDesc();
					 monster = navigationn.getMonster();
					 attackStat = navigationn.getAttackStat();
					 roomItem = navigationn.getRoomItem();
					 roomExits = navigationn.getRoomExits();
					 txtC = navigationn.getTxtC();
					
					 nav = "Lower-Floor";
					 break;

		       default:
			     nav = "default";
			break;
		}
	}
	
	
	
   
	
}
