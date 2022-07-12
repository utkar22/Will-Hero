package com.example.demo1;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Orc extends Living_Object{
	private String type;
	private boolean canreward = true;
	private boolean if_bomb;
	private int health;
	private ObservableList<Node> lst;
	Timeline pushed;
	Timeline blownup;
	Timeline falling;
	double platformx;
	double platformy;
	Orc(double x, double y, double width, double height, double power, String type, int health,
			int jump_limit, int jump_base, int verticle_speed, int curr_base, ObservableList<Node> lst) throws FileNotFoundException {
		super(x, y, width, height, power, 0, jump_limit, jump_base, verticle_speed, curr_base, false);
		this.lst = lst;
		this.type = type;

		this.if_bomb = false;
		this.health = health;
		this.setBackground(new Background(
				new BackgroundImage(
						new Image(new FileInputStream("toPutInProject\\redorc.png")),
						BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
						new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
						new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
				)));
		KeyFrame upFrame=new KeyFrame(Duration.millis(40), new jumphandlerorc());
		falling=new Timeline(upFrame);
		falling.setCycleCount(Animation.INDEFINITE);
		falling.play();
		KeyFrame rightmove = new KeyFrame(Duration.millis(20), new Pusher());
		KeyFrame boom = new KeyFrame(Duration.millis(20), new blow());

		blownup = new Timeline(boom);
		blownup.setCycleCount(10);
		pushed= new Timeline(rightmove);
		if(ifboss()){
			pushed.setCycleCount(5);
		}
		else{
		pushed.setCycleCount(20);}
	}
	int j = 1;



	public class jumphandlerorc implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e){
			fall(j);
			if((y>= 600 && health>0) || health<=0){
				endwork(lst);
			}

			for(Node obj:lst){

				if(obj instanceof Platform){
					if(collision_with_platform((Platform) obj)){
						fall(-17);
						platformx = ((Platform) obj).initx;
						platformy = ((Platform) obj).inity;
					}
				}
				if(obj instanceof Orc && x!= ((Orc) obj).x){
					Orc tt = (Orc) obj;
					if ((x + width >= tt.x && x < tt.x) && (!(y + height < tt.y || y > tt.y + tt.height))) {
						tt.pushed.play();
						if(if_bomb){
							setToBlow = 0;
							blownup.play();

						}
						pushed.stop();
						System.out.println("Dash from orc to orc");
					}
				}


			}

		}
	}
	int setToBlow = 0;

	public class Pusher implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			if(if_bomb){

				setToBlow+=1;
			}
			if(!ifboss()){
			set_x(12);
			x += 12;}
			else{
				set_x(13);
				x += 13;
			}
			if(setToBlow>=20){
				setToBlow = 0;
				blownup.play();
				if_bomb = false;
			}
			for (Node obj : lst) {
				if (obj instanceof Orc && x!= ((Orc) obj).x) {
					Orc tt = (Orc) obj;
					if ((x + width >= tt.x && x < tt.x) && (!(y + height < tt.y || y > tt.y + tt.height))) {
						tt.pushed.play();
						if(if_bomb){
							setToBlow = 0;
							blownup.play();

						}
						pushed.stop();
						System.out.println("Dash from orc to orc");
					}
				}
			}


		}
	}
	int blowupnumber =0;
	public class blow implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e){
			try {
				blowupnumber+=1;

				setBackground(new Background(
						new BackgroundImage(
								new Image(new FileInputStream("toPutInProject\\explosion.png")),
								BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
								new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
								new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
						)));
				if (blowupnumber>=10 && colour() ){
					if(health<=0){
						endwork(lst);
					}
					else{
					setBackground(new Background(
							new BackgroundImage(
									new Image(new FileInputStream("toPutInProject\\boss.jpg")),
									BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
									new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
									new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
							)));
					blowupnumber =0;
				}}
				else if(blowupnumber>= 10 && !colour()){
					if(health<=0){
						endwork(lst);
					}
					else{
					setBackground(new Background(
							new BackgroundImage(
									new Image(new FileInputStream("toPutInProject\\redorc.jpg")),
									BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
									new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
									new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
							)));
					blowupnumber =0;
					}}


			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void fall(int k){
		this.set_y(k);
		if(k<0 && k>-10 && k==1000){
			y+=k;
			j=k-1;
		}
//		else if(k==-10){
//			j=1;
//		}
		else{
			y+=k;
			j=k+1;
		}

	}
	//GETTERS
	public String get_type() {
		return this.type;
	}
	

	
	public boolean get_if_bomb() {
		return this.if_bomb;
	}
	
	
	//BOMB METHODS
	
	public void attach_bomb(Bomb bomb) {
		//Attached bomb
	}
	
	public void remove_bomb() {
		//Removes bomb
	}

	public int getHealth() {
		return health;
	}
	public void setHealth(int h){
		health = h;
	}

	public void setIf_bomb(boolean iff){
		if_bomb = iff;
	}
	public void endwork(ObservableList<Node> lst){
		health = 0;
		lst.remove(this);
		for(Node obj: lst){
			if(obj instanceof Hero && canreward){
				((Hero) obj).reward(5);
				canreward = false;
			}
		}
	}
	//COLLISION METHODS

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
	public void collision_with_coin(Coin coin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	public boolean colour(){
		return false;
	}

	public boolean ifboss(){
		return false;
	}

}
