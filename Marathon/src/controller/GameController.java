package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class GameController implements Initializable {
	@FXML ImageView validate;
	@FXML ImageView roll;
	@FXML ImageView firstDice;
	@FXML ImageView secondDice;
	@FXML ImageView thirdDice;
	@FXML Label distance;
	@FXML TextField response;
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
		firstDice.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				response.setText(response.getText()+getValue(firstDice.getImage()));	
			}
		});
		secondDice.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				response.setText(response.getText()+getValue(secondDice.getImage()));	
			}
		});
		thirdDice.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				response.setText(response.getText()+getValue(thirdDice.getImage()));	
			}
		});
		fourthDice.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				response.setText(response.getText()+getValue(fourthDice.getImage()));	
			}
		});
		launchAndDisplayTirage();
		response.addEventFilter(KeyEvent.KEY_RELEASED, keyEvent -> {
			if(keyEvent.getCode() == KeyCode.ENTER)
				validateInput();
		});
	}



	@FXML private void validateInput() {
		if(response.getLength()==4) {
			int_dist-=Integer.parseInt(response.getText());
			distance.setText(int_dist.toString());
			launchAndDisplayTirage();
			response.setText("");
		}
		else response.setText("");

	}

	private int getValue(Image img) {
		int nb=0;
		if (img.getUrl().contains("1"))nb=1;
		else if (img.getUrl().contains("2"))nb=2;
		else if (img.getUrl().contains("3"))nb=3;
		else if (img.getUrl().contains("4"))nb=4;
		else if (img.getUrl().contains("5"))nb=5;
		else nb=6;
		return nb;

	}


	@FXML public void launchAndDisplayTirage() {
		if(int_dist>9999) {
			tirage = new Tirage(4);
		}
		else if (int_dist>999) {
			tirage = new Tirage(3);
			fourthDice.setImage(null);
		}
		else if (int_dist>99) {
			tirage = new Tirage(2);
			thirdDice.setImage(null);
			fourthDice.setImage(null);
		}
		else {
			tirage = new Tirage(1);
			secondDice.setImage(null);
			thirdDice.setImage(null);
			fourthDice.setImage(null);
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
