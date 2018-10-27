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
import javafx.scene.layout.Priority;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class GUI extends Application{
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
		borderPane.setCenter(controller.getVBox(0));
		borderPane.setLeft(vbLeft);
		borderPane.setRight(vbRight);
		borderPane.setBottom(hbBottom);
		
		
		
		
		btDetails.setOnAction(e -> {
			controller.showGameDetails();
			System.out.println(btDetails.getId());
			
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
	    
	    public VBox getVBox(int roomFrom) {
	    	String roomDescription =  "";
	    	//Room room = new Room(roomDescription);
	    	HBox top = new HBox();
	    	top.setAlignment(Pos.CENTER);
	    	HBox mid = new HBox();
	    	mid.setAlignment(Pos.CENTER);
	    	HBox base = new HBox();
	    	base.setAlignment(Pos.CENTER);
	    	
			VBox vbPlayField = new VBox();
			vbPlayField.setId("playField");
		
			Label roomDesc = new Label("Room Description ");
			roomDesc.setId("roomDesc");
			Label monstDesc = new Label("Monster Description ");
			monstDesc.setId("monstDesc");
			Label attackStatus = new Label("Attack Status ");
			attackStatus.setId("attackStatus");
			
			
			top.getChildren().add(roomDesc);
			mid.getChildren().add(monstDesc);
			base.getChildren().add(attackStatus);
			vbPlayField.getChildren().addAll(top, mid, base);
			VBox.setMargin(top, new Insets(2));
			VBox.setMargin(mid, new Insets(2));
			VBox.setMargin(base, new Insets(2));
			return vbPlayField;
			
			
	    	
	    }
		
		
	}
	
	
	
   
	
}
