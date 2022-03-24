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

public class DeleteEmployeeDetailsController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
    private Label address;

    @FXML
    private Label cnic;

    @FXML
    private Label id;

    @FXML
    private Label name;

    @FXML
    private Label phoneNumber;
	
	public void displayEmployeeID(int Employee_ID) {
    	id.setText(String.valueOf(Employee_ID));
    }
    
    public void displayEmployeeName(String Employee_Name) {
    	name.setText(Employee_Name);
    }
    
    public void displayEmployeeAddress(String Employee_Address) {
    	address.setText(Employee_Address);
    }
    
    public void displayEmployeePhoneNumber(String Employee_PhoneNumber) {
    	phoneNumber.setText(Employee_PhoneNumber);
    }
    
    public void displayEmployeeCNIC(String Employee_CNIC) {
    	cnic.setText(Employee_CNIC);
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
