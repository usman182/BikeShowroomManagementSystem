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

public class CustomerRegistrationDetailsController {
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private Label address;

    @FXML
    private Label age;

    @FXML
    private Label cnic;

    @FXML
    private Label dateOfBirth;

    @FXML
    private Label email;

    @FXML
    private Label gender;

    @FXML
    private Label name;

    @FXML
    private Label occupation;

    @FXML
    private Label phoneNumber;

    @FXML
    private Label uniqueId;
    
    private static int idForCustomer = 1;
    
    public void displayName(String CustomerName) {
    	name.setText(CustomerName);
    }
    
    public void displayAge(String CustomerAge) {
    	age.setText(CustomerAge);
    }
    
    public void displayGender(String CustomerGender) {
    	gender.setText(CustomerGender);
    }
    
    public void displayEmail(String CustomerEmail) {
    	email.setText(CustomerEmail);
    }
    
    public void displayDateOfBirth(String CustomerDateOfBirth) {
    	dateOfBirth.setText(CustomerDateOfBirth);
    }
    
    public void displayAddress(String CustomerAddress) {
    	address.setText(CustomerAddress);
    }
    
    public void displayPhoneNumber(String CustomerPhoneNumber) {
    	phoneNumber.setText(CustomerPhoneNumber);
    }
    
    public void displayCNIC(String CustomerCNIC) {
    	cnic.setText(CustomerCNIC);
    }
    
    public void displayOccupation(String CustomerOccupation) {
    	occupation.setText(CustomerOccupation);
    	
    	if (occupation.getText() != "" && cnic.getText() != "" && phoneNumber.getText() != "" && address.getText() != "" &&
    			dateOfBirth.getText() != "" && email.getText() != "" && gender.getText() != "" && age.getText() != "" && name.getText() != "") {
    		uniqueId.setText(String.valueOf("Unique Id: " + idForCustomer));
        	idForCustomer++;
    	}
    	else {
    		uniqueId.setText("Unique Id: " + "Incomplete Details!!! Enter Details Again");
    	}
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
