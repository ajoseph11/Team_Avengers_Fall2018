package view;

import javafx.application.Application;
import javafx.scene.Scene;
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

    

	@Override
	public void start(Stage stage) throws Exception {
		
		mainPane = new BorderPane();
		leftPane = new VBox();
		centerPane = new VBox();
		rightPane = new VBox();
		topPane = new HBox();
		bottomPane = new HBox();
		
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
