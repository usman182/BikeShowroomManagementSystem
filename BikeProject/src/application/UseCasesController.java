package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UseCasesController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    void advanceBooking(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("AdvanceBooking.fxml"));
    	root = loader.load();
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void customerRegistration(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerRegistration.fxml"));
    	root = loader.load();
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void bookBike(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("BookBike.fxml"));
    	root = loader.load();
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    }

    @FXML
    void manageEmployee(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeCRUDOperation.fxml"));
    	root = loader.load();
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();

    }

    @FXML
    void manageInventory(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ManageInventory.fxml"));
    	root = loader.load();
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void searchBike(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchBike.fxml"));
    	root = loader.load();
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void manageBikeDetails(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("BikeRegister.fxml"));
    	root = loader.load();
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void purchasedBookBike(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("PurchasedBookBike.fxml"));
    	root = loader.load();
    	
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

}
