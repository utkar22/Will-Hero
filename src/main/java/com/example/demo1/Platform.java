package com.example.demo1;

import javafx.geometry.Side;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Platform extends Game_Object{

	Platform(double x, double y, double width, double height) throws FileNotFoundException {
		super(x, y, width, height, 100);
		// TODO Auto-generated constructor stub
		this.setBackground(new Background(
				new BackgroundImage(
						new Image(new FileInputStream("toPutInProject\\platform1.png")),
						BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
						new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
						new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
				)));
	}

	@Override
	public void collision_with_living_object(Living_Object l_obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collision_with_hero(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collision_with_orc(Orc orc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collision_with_chest(Chest chest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean collision_with_platform(Platform platform) {
		// TODO Auto-generated method stub
		return false;
		
	}

	@Override
	public void collision_with_coin(Coin coin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
