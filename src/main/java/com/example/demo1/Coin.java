package com.example.demo1;

import javafx.geometry.Side;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Coin extends Game_Object{
	private  int reward_amount;
	private boolean Rewardable = true;
	Coin(double x, double y, double width, double height, int reward_amount) throws FileNotFoundException {
		super(x, y, width, height, 0);
		this.reward_amount = reward_amount;
		this.setBackground(new Background(
				new BackgroundImage(
						new Image(new FileInputStream("toPutInProject\\coin.jpg")),
						BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
						new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
						new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
				)));
	}

	

	@Override
	public void collision_with_hero(Hero hero) {
		// TODO Auto-generated method stub
		
	}
	public int getreward(){
		return this.reward_amount;
	}



	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	public boolean isRewardable(){
		return Rewardable;
	}
	public void setRewardable(){
		Rewardable = false;
	}
	
	//Blank collision methods
	@Override
	public void collision_with_coin(Coin coin) {
		//Empty method
	}
	@Override
	public boolean collision_with_platform(Platform platform) {
		// Empty method
		return false;
	}
	@Override
	public void collision_with_chest(Chest chest) {
		// Empty method
	}
	@Override
	public void collision_with_orc(Orc orc) {
		// Empty method
	}
	@Override
	public void collision_with_living_object(Living_Object l_obj) {
		// Empty method
	}

}
