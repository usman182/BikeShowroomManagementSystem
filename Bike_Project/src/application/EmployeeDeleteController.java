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

public class EmployeeDeleteController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
    @FXML
    private TextField id;

    @FXML
    void deleteEmployeeDetails(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {

    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteEmployeeDetails.fxml"));
    	root = loader.load();
    	
    	DeleteEmployeeDetailsController crc = loader.getController();
    	int Employee_ID = Integer.parseInt(id.getText());
    	crc.displayEmployeeID(Employee_ID);
    	
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    	
    	Showroom showroom = new Showroom();
    	showroom.DeleteDetail(Employee_ID);
    }

}
