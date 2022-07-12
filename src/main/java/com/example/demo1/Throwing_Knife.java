package com.example.demo1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class Throwing_Knife extends Weapon implements Cloneable, Serializable
{
	private double tail_length;
	private static final long serialVersionUID = 36;
	transient Timeline swish;
	Throwing_Knife(double x, double y, double width, double height, double power, String name, int damage, int tail_length) throws FileNotFoundException {
		super(x, y, width, height, power, name, damage);
		// TODO Auto-generated constructor stub
		this.setBackground(new Background(
				new BackgroundImage(
						new Image(new FileInputStream("toPutInProject\\knife1.png")),
						BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
						new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
						new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
				)));
		KeyFrame zoom = new KeyFrame(Duration.millis(1), new throwHandler());
		swish  = new Timeline(zoom);
		swish.setCycleCount(300);

	}
	AnchorPane toRemove;
	int damage;
	Throwing_Knife(double x, double y, double width, double height, double power, String name, int damage, int tail_length, AnchorPane remover) throws FileNotFoundException {
		super(x, y, width, height, power, name, damage);
		// TODO Auto-generated constructor stub
		this.setBackground(new Background(
				new BackgroundImage(
						new Image(new FileInputStream("toPutInProject\\knife1.png")),
						BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
						new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
						new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
				)));
		KeyFrame zoom = new KeyFrame(Duration.millis(1), new throwHandler());
		swish  = new Timeline(zoom);
		swish.setCycleCount(400);
		toRemove = remover;
		this.damage = damage;

	}

	int checkthrow = 0;
	public class throwHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			set_x(1);
			x+=1;
			checkthrow+=1;
			for(Node obj: toRemove.getChildren()){
				if(obj instanceof Orc){
					Orc tt = (Orc) obj;
					if ((x + width >= tt.x && x<tt.x) && (!(y + height < tt.y || y > tt.y + tt.height))){
						tt.setHealth(tt.getHealth() - damage);
						System.out.println("Stabbed an orc");
						swish.stop();
						remove();
					}
				}
			}
			if(checkthrow==400){
				System.out.println("stopped");
				remove();

			}
		}
	}
	@Override
	public void use() {
		// TODO Auto-generated method stub
		
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

	public void remove(){
		toRemove.getChildren().remove(this);
	}

}
