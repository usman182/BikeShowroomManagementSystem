package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchBikeController {

    @FXML
    private TextField engineNumber;

    @FXML
    private TextField name;
    
    private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    void submitBikeDetails(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
    	
    	String[] rs = null;
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchBikeDetails.fxml"));
    	root = loader.load();
    	
    	SearchBikeDetailsController crc = loader.getController();
    	int engine_Number = Integer.parseInt(engineNumber.getText());
    	//crc.displayBikeEngineNumber(engine_Number);
    	
    	try
    	{
			checkSearchID(engine_Number);
		} 
    	
    	catch (Exception e) 
    	{
			// TODO: handle exception
    		System.out.println("Error! You enter wrong Engine ID!");
		}
    	
    	String bike_Name = name.getText();
    	//crc.displayBikeName(bike_Name);
    	
    	Showroom showroom = new Showroom();
    	rs=showroom.searchBike(engine_Number, bike_Name);
    	
    	System.out.println("SearchBikeController");
    	for (int i=1; i<=4; i++) {
			System.out.print(rs[i] + " ");
		}
    	
		crc.displayBikeEngineNumber(Integer.parseInt(rs[1]));
		
		crc.displayBikeModel(rs[2]);
		
		crc.displayBikeName(rs[3]);
		
		crc.displayBikeColor(rs[4]);
    	

    	
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    	
    	
    	

    }
    
    
    static void checkSearchID(int engine_number) throws SearchBike_IDException
    {
 	 if(engine_number<=0)
 	 {
 	   throw new SearchBike_IDException("\n"+"You enter wrong Engine ID! Please enter correct engine ID. ");	 
 	 }
 	   
    }

}
