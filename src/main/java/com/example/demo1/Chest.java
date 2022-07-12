package com.example.demo1;

import javafx.geometry.Side;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class Chest extends Game_Object{
	private boolean if_base;

	Chest(double x, double y, double width, double height, double power) throws FileNotFoundException {
		super(x, y, width, height, power);
		this.if_base = true;
		this.setBackground(new Background(
				new BackgroundImage(
						new Image(new FileInputStream("toPutInProject\\chest_closed.png")),
						BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
						new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
						new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
				)));
	}
	
	
	//BASE Methods
	//At the beginning of every frame, the base is set to be false. 
	//When the chest loops through the collisions, if a collision is found 
	//where the chest has a base, the yes_base() function is called.
	//If no base is found, then the chest will go through falling.
	public void no_base() {
		this.if_base = false;
	}
	
	public void yes_base() {
		this.if_base = true;
	}

	public void setIf_base(boolean if_base) {
		this.if_base = if_base;
	}

	public boolean isIf_base() {
		return if_base;
	}
	//COLLISION METHODS

	@Override
	public void collision_with_hero(Hero hero) {
		// Collision with hero
		
	}

	@Override
	public void collision_with_orc(Orc orc) {
		// Collision with orc
		
	}

	@Override
	public boolean collision_with_platform(Platform platform) {
		// Collision with platform
		// The only collision that matters is that of the chest with the top
		// part of the platform.
		return false;
	}
	
	//Other method
	public abstract void reward(Hero hero);

	
	
	////BLANK COLLISION METHODS
	@Override
	public void collision_with_coin(Coin coin) {
		// Does nothing
	}
	@Override
	public void collision_with_chest(Chest chest) {
		// Does nothing
	}
	@Override
	public void collision_with_living_object(Living_Object l_obj) {
		// Does nothing, everything covered by collision_with_hero() and
		// collision_with_orc() methods.
	}
}