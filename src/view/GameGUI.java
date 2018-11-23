package view;

import java.awt.TextField;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.sun.org.apache.xml.internal.serializer.ToTextSAXHandler;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameGUI extends Application {
	
	BorderPane mainPane;
	VBox leftPane, centerPane, rightPane;
	HBox topPane, bottomPane;
	
	final private int guiHeight = 700; 
	final private int guiWidth = 1000; 

	
	Label lbTop, lbRmDesc, lbUserResponse, lbHp, lbGem, lbWeapon;
	TextArea txtUserInput;
	
	String roomDesc = "";
	String userResponse = "";
	String hP = "";
	String gem = " ";
	String weapon = " ";
	
    

	@Override
	public void start(Stage stage) throws Exception {
		
		mainPane = new BorderPane();
		leftPane = new VBox();
		centerPane = new VBox();
		rightPane = new VBox();
		topPane = new HBox();
		bottomPane = new HBox();
		
		lbTop  = new Label("CITADEL OF STORMS");
		topPane.setAlignment(Pos.BASELINE_CENTER);
		topPane.getChildren().add(lbTop);
		
		
		txtUserInput = new TextArea();
		txtUserInput.setPrefColumnCount(5);
		txtUserInput.setPrefRowCount(1);
		
		
		
		lbRmDesc = new Label("ROOM DESCRIPTION:" + "\n" + roomDesc);
		centerPane.getChildren().addAll(lbRmDesc, txtUserInput);
		
		
		centerPane.setAlignment(Pos.BASELINE_CENTER);
		
		
		lbUserResponse = new Label("MESSAGE:" + "\n" + userResponse);
		bottomPane.getChildren().addAll(lbUserResponse);
		bottomPane.setAlignment(Pos.BASELINE_CENTER);
		BorderPane.setMargin(topPane, new Insets(5));
		BorderPane.setMargin(rightPane, new Insets(5));

		BorderPane.setMargin(bottomPane, new Insets(5));
		BorderPane.setMargin(leftPane, new Insets(5));
		BorderPane.setMargin(centerPane, new Insets(5));


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
	
	
	
	public static void main(String [] args) {
		Application.launch(args);
	}

	
	
}
