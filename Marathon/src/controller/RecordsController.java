package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RecordsController implements Initializable {
	@FXML Button back;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		back.setStyle(MenuController.IDLE_BUTTON_STYLE);
		back.setOnMouseEntered(e -> back.setStyle(MenuController.HOVERED_BUTTON_STYLE));
		back.setOnMouseExited(e -> back.setStyle(MenuController.IDLE_BUTTON_STYLE));
	}
	@FXML public void before() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/Menu.fxml"));
		Stage thisStage = (Stage) Main.actualRoot.getScene().getWindow();
		Main.actualRoot=root;
		Scene next = new Scene(root);
		thisStage.setScene(next);
	}

}
