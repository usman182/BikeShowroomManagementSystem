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

public class ManageInventoryController {

    @FXML
    private TextField engineNumber;
    
    private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    void submitBikeDetails(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {

    	String[] rs = null;
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ManageInventoryDetails.fxml"));
    	root = loader.load();
    	
    	ManageInventoryDetailsController crc = loader.getController();
    	
    	int engine_Number = Integer.parseInt(engineNumber.getText());
    	
    	Showroom showroom = new Showroom();
    	rs = showroom.manageInventory(engine_Number);
    	
    	crc.displayBikeEngineNumber(Integer.parseInt(rs[1]));
    	crc.displayBikeModel(rs[2]);
    	crc.displayBikeName(rs[3]);
    	crc.displayBikeColor(rs[4]);
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

}
