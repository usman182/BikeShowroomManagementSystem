package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmployeeCRUDController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;


    @FXML
    void addANewEmployee(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("NewEmployee.fxml"));
    	root = loader.load();
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void deleteEmployee(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteEmployee.fxml"));
    	root = loader.load();
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();

    }

    @FXML
    void updateEmployee(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateEmployee.fxml"));
    	root = loader.load();
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();

    }

}
