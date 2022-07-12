package com.example.demo1;

import java.io.FileNotFoundException;

public class Coin_Chest extends Chest{
	private int chest_contains; //Amount of coins

	Coin_Chest(double x, double y, double width, double height, double power, int chest_contains) throws FileNotFoundException {
		super(x, y, width, height, power);
		this.chest_contains = chest_contains;
	}

	@Override
	public void reward(Hero hero) {
		// Rewards the hero	
		
	}
	public int getChest_contains() {
		return chest_contains;
	}


	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
