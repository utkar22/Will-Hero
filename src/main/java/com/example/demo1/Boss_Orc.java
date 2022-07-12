package com.example.demo1;

import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Boss_Orc extends Orc{

	Boss_Orc(double x, double y, double width, double height, double power, String type,
			int jump_limit, int jump_base, int verticle_speed, int curr_base, ObservableList<Node> lst) throws FileNotFoundException {
		super(x, y, width, height, power, "Boss Orc", 5, 10,  jump_base, verticle_speed, curr_base, lst);
		this.setBackground(new Background(
				new BackgroundImage(
						new Image(new FileInputStream("toPutInProject\\boss.jpg")),
						BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
						new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
						new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
				)));
	}
	
	public void move() {
		//Move
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean ifboss(){
		return true;
	}
}
