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

public class PurchasedBookBikeController {

    @FXML
    private TextField name;
    
    private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    void submitBikeDetails(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {

    	String[] rs = null;
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("PurchasedBookBikeDetails.fxml"));
    	root = loader.load();
    	
    	PurchasedBookBikeDetailsController crc = loader.getController();
    	
    	String bike_Name = name.getText();
    	crc.displayBikeName(bike_Name);
    	
    	Showroom showroom = new Showroom();
    	rs = showroom.purchaseBookBike(bike_Name);
    	
    	crc.displayBikeEngineNumber(rs[1]);
    	crc.displayBikeModel(rs[2]);
    	crc.displayBikeName(rs[3]);
    	crc.displayBikeColor(rs[4]);
    	crc.displayBikePayment(rs[5]);
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

}
