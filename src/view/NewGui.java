package view;






import controller.NewGuiController;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;


public class NewGui extends Application {

	//static members
	private static Stage stage;
	private static Scene scene;
	
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage; //link our primaryStage variable to the GUI's primary stage so we can be able to acces it in the contoroller. 
		NewGuiController guiController = new NewGuiController(); //instance of gui controller which controlls all instances of gui-view and classes-model
		//guiController.setNodesForGui();
		guiController.setSceneAndStageForGUI(); // this updates GUi accordingly...
		guiController. getUserInputFromTextField();
		guiController.allocateRoomNUmber();
		guiController.setRoomDetails();
		

		// show the gui upon running the app
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	// static getters and setters
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		NewGui.stage = stage;
	}
	
	
	
	public static Scene getScene() {
		return scene;
	}

	public static void setScene(Scene scene) {
		NewGui.scene = scene;
	}

	

	
    
	
	
}
