package controller;

import java.util.Random;

import javafx.scene.image.Image;


public class Tirage {
	private int nbDice;
	private int first;
	private int second;
	private int third;
	private int fourth;

	public Tirage(int nbDice) {
		this.nbDice=nbDice;
		Random random= new Random();
		switch(nbDice) {
		case 4:
			first=random.nextInt(6)+1;
			second=random.nextInt(6)+1;
			third=random.nextInt(6)+1;
			fourth=random.nextInt(6)+1;
			break;
		case 3:
			first=random.nextInt(6)+1;
			second=random.nextInt(6)+1;
			third=random.nextInt(6)+1;
			break;
		case 2:
			first=random.nextInt(6)+1;
			second=random.nextInt(6)+1;
			break;
		default :
			first=random.nextInt(6)+1;
			break;
		}
	}
	
	public String getvalue(int value) {
		String returned;
		switch(value) {
		case 1 : returned="/images/1.png";
		break;
		case 2 : returned="/images/2.png";
		break;
		case 3 : returned="/images/3.png";
		break;
		case 4 : returned="/images/4.png";
		break;
		case 5 : returned="/images/5.png";
		break;
		default : returned="/images/6.png";
		break;
		}
		return returned;
	}

	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}

	public int getThird() {
		return third;
	}

	public int getFourth() {
		return fourth;
	}

	public int getNbDice() {
		return nbDice;
	}
	
	public void compare(String value) {
		
	}
}
