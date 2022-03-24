/*package application;

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

public class UpdateEmployeeDetailsController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;


	@FXML
    private TextField address;

    @FXML
    private TextField cnic;

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField phoneNumber;
    
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

}*/




package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateEmployeeDetailsController {
	
	 	private Stage stage;
		private Scene scene;
		private Parent root;

    @FXML
    private TextField address;

    @FXML
    private TextField cnic;

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField phoneNumber;

    @FXML
    void submitEmployeeDetails(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {

    	String[] rs = null;
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateEmployeeDetails2.fxml"));
    	Object root = loader.load();
    	
    	UpdateEmployeeDetails2Controller crc = loader.getController();
    	int Emplyee_ID = Integer.parseInt(id.getText());
    	//crc.displayBikeEngineNumber(engine_Number);
    	
    	
    	Showroom showroom = new Showroom();
    	rs=showroom.ChangeDetails(Emplyee_ID);
    	

    	//String Employee_Name = name.getText();
    	crc.displayEmployeeName(rs[1]);
    	
    	//String Employee_Address = address.getText();
    	crc.displayEmployeeAddress(rs[3]);
    	
    	//String Employee_PhoneNumber = phoneNumber.getText();
    	crc.displayEmployeePhoneNumber(rs[4]);
    	
    	//String Employee_CNIC = cnic.getText();
    	crc.displayEmployeeCNIC(rs[5]);
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene((Parent) root);
    	stage.setScene(scene);
    	stage.show();
    	
    	
    }

}