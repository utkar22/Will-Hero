package com.example.demo1;

import javafx.geometry.Side;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Weapon_Chest extends Chest{
	private Weapon chest_contains;

	Weapon_Chest(double x, double y, double width, double height, Weapon chest_contains) throws FileNotFoundException {
		super(x, y, width, height, 20);
		this.chest_contains = chest_contains;
		// TODO Auto-generated constructor stub

	}

	@Override
	public void reward(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	public Weapon getChest_contains() {
		return chest_contains;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
