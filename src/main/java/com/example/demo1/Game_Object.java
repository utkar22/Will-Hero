package com.example.demo1;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.Region;
import javafx.util.Duration;

import java.io.Serializable;

public abstract class Game_Object extends Region implements Serializable {
	protected double x;
	protected double y;
	protected double width;
	protected double height;
	protected double power;
	private static final long serialVersionUID = 29;
	transient TranslateTransition translate;
	double initx;
	double inity;
	Game_Object(double x, double y, double width, double height, double power){
		this.x = x;
		this.y = y;
		this.initx = x;
		this.inity = y;
		this.width = width;
		this.height = height;
		this.power = power;

		this.setLayoutX(this.x);
		this.setLayoutY(this.y);
		this.setPrefWidth(this.width);
		this.setPrefHeight(this.height);

		translate = new TranslateTransition();
	}
	
	//GETTERS
	public double get_x() {
		return this.x;
	}
	
	public double get_y() {
		return this.y;
	}
	
	public double get_width() {
		return this.width;
	}
	
	public double get_height() {
		return this.height;
	}
	
	public double get_power() {
		return this.power;
	}
	
	//SETTERS
	
	public void set_x(double x) {
		//translate.setByX(x-this.x);
		//
		//translate.setAutoReverse(true);
		this.setLayoutX(this.getLayoutX()+x);
	}
	
	public void set_y(double y) {
		//translate.setByY(y+this.y);
		this.setLayoutY(this.getLayoutY()+y);

		//translate.setDuration(Duration.millis(200));
		//translate.setCycleCount(1);
		//translate.setNode(this);
		//translate.play();
		//translate.setAutoReverse(true);
	}
	
	public void set_width(double width) {
		this.width = width;
	}
	
	public void set_height(double height) {
		this.height = height;
	}
	
	public void set_power(double power) {
		this.power = power;
	}
	
	//RIGHT, BOTTOM EDGE coordinates
	
	public double get_right_x() {
		//Returns the x coordinate of the right edge
		return this.x + this.width;
	}
	
	public double get_bottom_y() {
		//Returns the y coordinate of the bottom edge
		return this.y + this.height;
	}
	
	public void set_right_x(double right_x) {
		set_x(right_x - this.width);
	}
	
	public void set_bottom_y(double bottom_y) {
		set_y(bottom_y - this.height);
	}
	
	//UPDATE
	public void update_x(double val) {
		this.set_x(this.x + val);
	}
	
	public void update_y(double val) {
		this.set_y(this.y + val);
	}
	
	//RELATIVE POSITIONS
	public double get_relative_x(double hero_x) {
		return this.x - hero_x;
	}
	
	public double get_relative_y(double hero_y) {
		return this.y - hero_y;
	}
	
	//COLLISION METHODS
	
	public boolean check_collision(Game_Object obj) {
		//This method checks if this object is colliding with the given object
		//Checks each edge of this object, and checks if it lies inside the 
		//other object

		if (obj==this){
			//In case the same object is received
			return false;
		}
		
		else if (obj.get_x()<=this.x&&this.x<=obj.get_right_x() && obj.get_y()<=this.y&&this.y<=obj.get_bottom_y()) {
			//Top left edge
			return true;
		}
		
		else if (obj.get_x()<=this.get_right_x()&&this.x<=obj.get_right_x() && 
				obj.get_y()<=this.y&&this.y<=obj.get_bottom_y()) {
			//Top right edge
			return true;
		}
		
		else if (obj.get_x()<=this.x&&this.x<=obj.get_right_x() &&
				obj.get_y()<=this.get_bottom_y()&&this.get_bottom_y()<=obj.get_bottom_y()) {
			//Bottom left edge
			return true;
		}
		
		else if (obj.get_x()<=this.get_right_x()&&this.get_right_x()<=obj.get_right_x() &&
				obj.get_y()<=this.get_bottom_y()&&this.get_bottom_y()<=obj.get_bottom_y()) {
			//Bottom right edge
			return true;
		}
		
		return false;
	}
	
	public abstract void collision_with_living_object(Living_Object l_obj);
	public abstract void collision_with_hero(Hero hero);
	public abstract void collision_with_orc(Orc orc);
	public abstract void collision_with_chest(Chest chest);
	public abstract boolean collision_with_platform(Platform platform);
	public abstract void collision_with_coin(Coin coin);
	
	
	//GUI METHODS
	
	public abstract void draw();
	

}
