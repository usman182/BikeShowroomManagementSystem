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

public class PurchasedBookBikeDetailsController {

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
    
    @FXML
    private Label payment;

    public void displayBikeEngineNumber(int engine_Number) {
		engineNumber.setText(String.valueOf(engine_Number));
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
    
    public void displayBikePayment(String BikePayment) {
    	payment.setText(BikePayment);
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