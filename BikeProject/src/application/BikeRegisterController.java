package application;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BikeRegisterController {

    @FXML
    private TextField color;

    @FXML
    private TextField engine_number;

    @FXML
    private TextField model;

    @FXML
    private TextField name;
    
    private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    void addBiketoDB(ActionEvent event) throws IOException, ClassNotFoundException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("BikeRegisterDetails.fxml"));
    	root = loader.load();
    	
    	BikeRegistrationDetailsController crc = loader.getController();
    	int Engine_Number = Integer.parseInt(engine_number.getText());
    	crc.displayBikeEngine_Number(Engine_Number);
    	
    	String Bike_Model = model.getText();
    	crc.displayBikeModel(Bike_Model);
    	
    	String Bike_Name = name.getText();
    	crc.displayBikeName(Bike_Name);
    	
    	String Bike_Color = color.getText();
    	crc.displayBikeColor(Bike_Color);
    	
    	
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    	
    	Showroom showroom = new Showroom();
    	showroom.AddBike(Engine_Number, Bike_Model, Bike_Name, Bike_Color);

    }

}
