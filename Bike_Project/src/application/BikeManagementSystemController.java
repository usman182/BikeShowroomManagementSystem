package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BikeManagementSystemController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private TextField myTextField1;

    @FXML
    private TextField myTextField2;
    
    public void logIn(ActionEvent event) throws IOException {
    	
    	String pass="123";
    	if (myTextField1.getText().equals("showroom") && myTextField2.getText().equals("123")) {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("UseCases.fxml"));
    		root = loader.load();
    	
    		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();	
    		
    		try 
    		{
    			checkPass(pass);
    		}
    		
    		catch (Exception e) 
    		{
				// TODO: handle exception
    			System.out.println("Password error! Please enter correct Password or username!"+e);
			}
    	}
    	
    }
    
    static void checkPass(String passid) throws LoginException
    {
    	
    	
    	if (passid.equals("123"))
    	{
			System.out.println("You are now Login successfully!");
		}
    	
    	else 
    	{
    		throw new LoginException("\n"+"You must be enter 123 to succesfully login!");
    		
    	}
    }

}
