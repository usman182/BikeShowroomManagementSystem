package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerRegistrationController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private TextField address;

    @FXML 
    public TextField age;

    @FXML
    private TextField cnic;

    @FXML
    private DatePicker dateOfBirth;

    @FXML
    private TextField email;

    @FXML
    private TextField gender;

    @FXML
    private TextField name;

    @FXML
    private TextField occupation;

    @FXML
    private TextField phoneNumber;

    @FXML
    void submitCustomerRegistrationDetails(ActionEvent event) throws IOException, ClassNotFoundException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerRegistrationDetails.fxml"));
    	root = loader.load();
    	
    	CustomerRegistrationDetailsController crc = loader.getController();
    	String customerName = name.getText();
    	crc.displayName(customerName);
    	
    	String customerAge = age.getText();
    	crc.displayAge(customerAge);
    	
    	String customerGender = gender.getText();
    	crc.displayGender(customerGender);
    	
    	String customerEmail = email.getText();
    	crc.displayEmail(customerEmail);
    	
    	LocalDate selectedDate = dateOfBirth.getValue();
    	String customerdateOfBirth = "";
    	if (selectedDate != null) {
    		customerdateOfBirth = selectedDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyy"));
    		crc.displayDateOfBirth(customerdateOfBirth);
    	}
    	else {
    		crc.displayDateOfBirth(null);
    	}
    	
    	
    	String customerAddress = address.getText();
    	crc.displayAddress(customerAddress);
    	
    	String customerPhoneNumber = phoneNumber.getText();
    	crc.displayPhoneNumber(customerPhoneNumber);
    	
    	
    	
    	String customerCNIC = cnic.getText();
    	try 
    	{
			checkCNIC(customerCNIC);
		} 
    	
    	catch (Exception e) 
    	{
			// TODO: handle exception
    		System.out.println("CNIC can not be NULL"+e);
		}
    	crc.displayCNIC(customerCNIC);
    	
    	String customerOccupation = occupation.getText();
    	crc.displayOccupation(customerOccupation);
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    	
    	try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bikeshowroom", "root", "shadow123");
			//(customer_name, customer_age, customer_gender, customer_email, customer_dateOfBirth, customer_address, customer_phoneNumber, customer_CNIC, customer_occupation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			String sql = "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, customerName);
			statement.setInt(2, Integer.parseInt(customerAge));
			statement.setString(3, customerGender);
			statement.setString(4, customerEmail);
			statement.setString(5, customerdateOfBirth);
			statement.setString(6, customerAddress);
			statement.setString(7, customerPhoneNumber);
			statement.setString(8, customerCNIC);
			statement.setString(9, customerOccupation);
			statement.execute();
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer");
			
			/*while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}*/
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	

    }
    
    static void checkCNIC(String customer_cnic) throws CNICException
    {
    	if(customer_cnic=="")
    	{
    	 throw new CNICException("\n"+"CNIC can not be empty! Please enter!");	
    		
    	}
    	
    	else 
    	{
		 System.out.println("CNIC enter succesfully!");	
		}
    	
    }

}
