package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class manageCustomerBillController {

    @FXML
    private TextField bikeName;

    @FXML
    private Label bill;

    @FXML
    private TextField customerName;
    
    private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    void submitCustomerDetails(ActionEvent event) throws IOException {

    	
    	
    	String Bike_Name = bikeName.getText();
    	
    	
    	if (Bike_Name.equalsIgnoreCase("Honda"))
    	{
    		bill.setText("40,000 PKR/-");
    	}
    	
    	else if (Bike_Name.equalsIgnoreCase("United"))
    	{
    		bill.setText("50,000 PKR/-");
    	}
    	
    	else if (Bike_Name.equalsIgnoreCase("Unique"))
    	{
    		bill.setText("60,000 PKR/-");
    	}
    	
    	else if (Bike_Name.equalsIgnoreCase("Speed"))
    	{
    		bill.setText("70,000 PKR/-");
    	}
    	
    	else if (Bike_Name.equalsIgnoreCase("Road Prince"))
    	{
    		bill.setText("80,000 PKR/-");
    	}
    	
    	else if (Bike_Name.equalsIgnoreCase("Crown"))
    	{
    		bill.setText("90,000 PKR/-");
    	}
    	

    }

}
