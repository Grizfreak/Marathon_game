package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController implements Initializable{
	@FXML Button quit;
	@FXML Button play;
	@FXML Button record;
	protected static final String IDLE_BUTTON_STYLE = "-fx-background-color: black; -fx-border-color: white; -fx-border-width: 5;";
	protected static final String HOVERED_BUTTON_STYLE = "-fx-border-color: green; -fx-background-color: black; -fx-border-width: 5;";
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		quit.setStyle(IDLE_BUTTON_STYLE);
		play.setStyle(IDLE_BUTTON_STYLE);
		record.setStyle(IDLE_BUTTON_STYLE);
        quit.setOnMouseEntered(e -> quit.setStyle(HOVERED_BUTTON_STYLE));
        quit.setOnMouseExited(e -> quit.setStyle(IDLE_BUTTON_STYLE));
        play.setOnMouseEntered(e -> play.setStyle(HOVERED_BUTTON_STYLE));
        play.setOnMouseExited(e -> play.setStyle(IDLE_BUTTON_STYLE));
        record.setOnMouseEntered(e -> record.setStyle(HOVERED_BUTTON_STYLE));
        record.setOnMouseExited(e -> record.setStyle(IDLE_BUTTON_STYLE));
	}
	
	@FXML public void goToGame() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/Ingame.fxml"));
		Stage thisStage = (Stage) Main.actualRoot.getScene().getWindow();
		Main.actualRoot=root;
		Scene next = new Scene(root);
		thisStage.setScene(next);
	}
	@FXML public void goToRecord() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/Records.fxml"));
		Stage thisStage = (Stage) Main.actualRoot.getScene().getWindow();
		Main.actualRoot=root;
		Scene next = new Scene(root);
		thisStage.setScene(next);
	}
	@FXML public void exit() {
		Platform.exit();
	}

}
