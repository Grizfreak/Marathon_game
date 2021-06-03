package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameController implements Initializable {
	@FXML ImageView validate;
	@FXML ImageView roll;
	@FXML ImageView firstDice;
	@FXML ImageView secondDice;
	@FXML ImageView thirdDice;
	@FXML Label distance;
	@FXML TextArea response;
	@FXML ImageView fourthDice;
	String playername;
	Tirage tirage;
	Integer int_dist=42195;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		validate.setImage(new Image(getClass().getResource("/images/check.png").toString()));
		roll.setImage(new Image(getClass().getResource("/images/return.png").toString()));
		TextInputDialog dialog = new TextInputDialog("random");
		dialog.setTitle("Choix du nom");
		dialog.setHeaderText("Ce nom vous suivra dans vos plus beau records");
		dialog.setContentText("Veuillez entrer votre nom");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			System.out.println("Your name: " + result.get());
		}
		playername=result.toString();
		launchAndDisplayTirage();
		response.addEventFilter(KeyEvent.KEY_RELEASED, keyEvent -> {
			if(keyEvent.getCode() == KeyCode.ENTER)
				validateInput();
		});
	}


	private void validateInput() {
		
	}


	@FXML public void launchAndDisplayTirage() {
		if(int_dist>9999) {
			tirage = new Tirage(4);
		}
		else if (int_dist>999) {
			tirage = new Tirage(3);
		}
		else if (int_dist>99) {
			tirage = new Tirage(2);
		}
		else {
			tirage = new Tirage(1);
		}
		switch (tirage.getNbDice()) {
		case 1 :
			firstDice.setImage(new Image(getClass().getResource(tirage.getvalue(tirage.getFirst())).toString()));
			break;
		case 2 :
			firstDice.setImage(new Image(getClass().getResource(tirage.getvalue(tirage.getFirst())).toString()));
			secondDice.setImage(new Image(getClass().getResource(tirage.getvalue(tirage.getSecond())).toString()));
			break;
		case 3 :
			firstDice.setImage(new Image(getClass().getResource(tirage.getvalue(tirage.getFirst())).toString()));
			secondDice.setImage(new Image(getClass().getResource(tirage.getvalue(tirage.getSecond())).toString()));
			thirdDice.setImage(new Image(getClass().getResource(tirage.getvalue(tirage.getThird())).toString()));
			break;
		default :
			firstDice.setImage(new Image(getClass().getResource(tirage.getvalue(tirage.getFirst())).toString()));
			secondDice.setImage(new Image(getClass().getResource(tirage.getvalue(tirage.getSecond())).toString()));
			thirdDice.setImage(new Image(getClass().getResource(tirage.getvalue(tirage.getThird())).toString()));
			fourthDice.setImage(new Image(getClass().getResource(tirage.getvalue(tirage.getFourth())).toString()));
			break;
		}
	}

}
