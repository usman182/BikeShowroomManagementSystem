package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BikeRegistrationDetailsController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
    @FXML
    private Label color;

    @FXML
    private Label engine_number;

    @FXML
    private Label model;

    @FXML
    private Label name;
    
    public void displayBikeEngine_Number(int Engine_Number) {
    	engine_number.setText(String.valueOf(Engine_Number));
    }
    
    public void displayBikeModel(String Bike_Model) {
    	model.setText(Bike_Model);
    }
    
    public void displayBikeName(String Bike_Name) {
    	name.setText(Bike_Name);
    }
    
    public void displayBikeColor(String Bike_Color) {
    	color.setText(Bike_Color);
    }
    
    

    @FXML
    void goToMainMenu(ActionEvent event) throws IOException {

    	FXMLLoader loader = new FXMLLoader(getClass().getResource("UseCases.fxml"));
    	root = loader.load();
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    

}
