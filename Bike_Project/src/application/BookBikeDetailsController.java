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

public class BookBikeDetailsController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private Label color;

    @FXML
    private Label engineNumber;

    @FXML
    private Label model;

    @FXML
    private Label name;

    public void displayBikeEngineNumber(String rs) {
		engineNumber.setText(String.valueOf(rs));
    }
    
    public void displayBikeModel(String bike_Model) {
    	model.setText(bike_Model);
    }
    
    public void displayBikeName(String BikeName) {
    	name.setText(BikeName);
    }
    
    public void displayBikeColor(String BikeColor) {
    	color.setText(BikeColor);
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
