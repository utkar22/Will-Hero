package com.example.demo1;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;

public class Hero extends Living_Object implements Serializable {
	@FXML transient private Button revie;
	@FXML transient private Button exit;
	private int no_of_deaths;
	private double horizontal_speed;
	private int curr_coins;
	private static final long serialVersionUID = 23;
	transient private ObservableList<Node> lst;
	transient private AnchorPane addonDeath;
	transient Timeline dash;
	transient Timeline pullback;
	transient Timeline falling;
	private int score=0;
	int knife_level = 0;
	int bomb_level = 0;
	double platformx;
	double platformy;
	Weapon curr_weapon = null;
	Hero(double x, double y, double width, double height, double power, int jump_limit,
		 int vertical_speed, ObservableList<Node> lst, AnchorPane boo) throws FileNotFoundException {
		super(x, y, width, height, power, 0, jump_limit, 0, vertical_speed, 0, true);

		this.lst = lst;
		this.setBackground(new Background(
				new BackgroundImage(
						new Image(new FileInputStream("toPutInProject\\will.jpg")),
						BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
						new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
						new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
				)));
		curr_coins = 0;
		addonDeath = boo;
		KeyFrame pull = new KeyFrame(Duration.millis(1), new retreat());
		pullback = new Timeline(pull);
		pullback.setCycleCount(20);
		KeyFrame upFrame=new KeyFrame(Duration.millis(40), new jumphandler());
		falling=new Timeline(upFrame);
		falling.setCycleCount(Animation.INDEFINITE);
		falling.play();
		KeyFrame shifter=new KeyFrame(Duration.millis(1), new RightHandler());
		dash=new Timeline(shifter);
		dash.setCycleCount(50);

	}
	public class retreat implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e){
			for (Node obj : lst) {
				if (obj instanceof Game_Object && !(obj instanceof Hero)) {
					((Game_Object) obj).set_x(2);
					((Game_Object) obj).x += 2;
				}
			}
		}
	}


	double j = 1;
	public class jumphandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			if(y>600){
				try {
					herodeath();
					falling.stop();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			Label coins = (Label) lst.get(0);
			Label scor = (Label) lst.get(1);
			scor.setText("Position: "+ score);
			if(score>=109){
				winner();
			}
			coins.setText("Coins: "+ curr_coins);
			fall(j);
			if (!dash.getStatus().equals(Animation.Status.RUNNING)) {
			for (Node obj : lst) {
				if(obj instanceof Weapon_Chest){
					Weapon_Chest tt = (Weapon_Chest) obj;
					if ((tt.x<=x+width && tt.x + tt.width>=x) && (tt.y <= y+height) && tt.isIf_base() ){
						System.out.println("weapon recieved");
						curr_weapon = ((Weapon_Chest) obj).getChest_contains();
						if(curr_weapon instanceof Throwing_Knife){
							knife_level +=1;
							System.out.println("knife recieved");
							try {
								setBackground(new Background(
										new BackgroundImage(
												new Image(new FileInputStream("toPutInProject\\will.jpg")),
												BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
												new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
												new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
										)));
							} catch (FileNotFoundException ex) {
								ex.printStackTrace();
							}
						}
						else if(curr_weapon instanceof Bomb){
							bomb_level +=1;
							try {
								setBackground(new Background(
										new BackgroundImage(
												new Image(new FileInputStream("toPutInProject\\bomberman.PNG")),
												BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
												new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
												new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
										)));
							} catch (FileNotFoundException ex) {
								ex.printStackTrace();
							}
						}
						tt.setIf_base(false);
						try {
							tt.setBackground(new Background(
									new BackgroundImage(
											new Image(new FileInputStream("toPutInProject\\chest_open.png")),
											BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
											new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
											new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
									)));
						} catch (FileNotFoundException ex) {
							ex.printStackTrace();
						}
					}
				}

				if(obj instanceof  Coin_Chest){
					Coin_Chest tt = (Coin_Chest) obj;
					if ((tt.x<=x+width && tt.x + tt.width>=x) && (tt.y <= y+height) && tt.isIf_base() ){
						System.out.println("Coins recieved");
						curr_coins+=tt.getChest_contains();
						System.out.println(curr_coins);
						tt.setIf_base(false);
						try {
							tt.setBackground(new Background(
									new BackgroundImage(
											new Image(new FileInputStream("toPutInProject\\chest_open.png")),
											BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
											new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
											new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
									)));
						} catch (FileNotFoundException ex) {
							ex.printStackTrace();
						}
					}

				}
				if (obj instanceof Platform) {
					if (collision_with_platform((Platform) obj)) {
						platformx = ((Platform) obj).initx;
						platformy = ((Platform) obj).inity;
						System.out.println(platformx);
						fall(-15);
					}
				}

				if (obj instanceof Coin) {
					Coin tt = (Coin) obj;
					if ((!(x + width < tt.x || x > tt.x + tt.width)) && (!(y + height < tt.y || y > tt.y + tt.height))) {

						if (tt.isRewardable()) {
							reward(tt.getreward());
							tt.setRewardable();
							lst.remove(tt);
						}
						System.out.println(curr_coins);
					}
				}

				if (obj instanceof Orc) {
					Orc tt = (Orc) obj;
					if (!(x + width  < tt.x+5 || x + 5 > tt.x + tt.width) && (tt.y + tt.height >= y && tt.y + tt.height <= y + height-20)) {
						System.out.println("death from falling");
						try {
							herodeath();
							falling.stop();
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
//					if(!(x+width<tt.x || x>tt.x + tt.width) && (y>= tt.y+tt.height)){
//						System.out.println("death");
//					}
					else if ((!(x + width < tt.x || x > tt.x + tt.width)) && ((y +height<= tt.y+tt.height && y+height>=tt.y))) {
						//System.out.println("jump");
						fall(-15);
					}
				}
			}
		}
		}
	}
	int stop_controller = 0;
	public class RightHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {

			for (Node obj : lst) {
				if (obj instanceof Game_Object && !(obj instanceof Hero)) {
					((Game_Object) obj).set_x(-2);
					((Game_Object) obj).x -= 2;
				}
			}

			for (Node obj : lst) {

				if (obj instanceof Platform) {
					if (collision_with_platform((Platform) obj)) {
						fall(-15);
					}
				}

				if (obj instanceof Coin) {
					Coin tt = (Coin) obj;
					if ((!(x + width < tt.x || x > tt.x + tt.width)) && (!(y + height < tt.y || y > tt.y + tt.height))) {

						if (tt.isRewardable()) {
							reward(tt.getreward());
							tt.setRewardable();
							lst.remove(tt);
						}
						System.out.println(curr_coins);
					}
				}
				if (obj instanceof Orc) {
					Orc tt = (Orc) obj;
					if ((x + width >= tt.x && x<tt.x) && (!(y + height < tt.y || y > tt.y + tt.height))) {
						if(curr_weapon instanceof Bomb){
							try {
								if(!tt.colour()){
								tt.setBackground(new Background(
										new BackgroundImage(
												new Image(new FileInputStream("toPutInProject\\bombed_red.jpeg")),
												BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
												new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
												new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
										)));}
								else{
									tt.setBackground(new Background(
											new BackgroundImage(
													new Image(new FileInputStream("toPutInProject\\bombed.jpeg")),
													BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
													new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
													new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
											)));
								}

							} catch (FileNotFoundException ex) {
								ex.printStackTrace();
							}

						tt.setHealth(tt.getHealth()-bomb_level);
						tt.setIf_bomb(true);
						}
						tt.pushed.play();
						dash.pause();
						System.out.println("Dash");

					}else if ((!(x + width < tt.x+5 || x > tt.x + tt.width-5)) && ((y+height <= tt.y+tt.height && y+height>=tt.y ))) {
						//System.out.println("jump");
						fall(-15);
					} else if (!(x + width  < tt.x+5 || x + 5 > tt.x + tt.width) && (tt.y + tt.height >= y && tt.y + tt.height <= y + height)) {
						System.out.println("death from dashing");
						try {
							herodeath();
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}

				}
			}


		}
		}



	public void fall(double k){
		this.set_y(k);
			y+=k;
			j=k+1;
	}
	
	
	//GETTERS AND SETTERS

	public int getScore(){
		return score;
	}
	public void setScore(int _setscore){
		score = _setscore;
	}
	//WEAPON METHODS
	
	public void receive_weapon(Weapon weapon) {
		//Receives weapon and stores it in the helmet
	}
	
	public void launch_weapon() {
		//Launches the current weapon
	}
	
	public void switch_weapon() {
		//Switches current weapon
	}
	
	//COIN METHODS
	
	public void receive_coins(int coins){
		//Receives coins, and adds it to the user's wallet too
	}
	
	//REVIVAL METHODS
	

	
	
	
	//COLLISION METHODS

	@Override
	public void collision_with_hero(Hero hero) {
		// Empty method
	}

	@Override
	public void collision_with_orc(Orc orc) {
		// When the hero collides with an orc
		
	}

	@Override
	public void collision_with_chest(Chest chest) {
		// When the hero collides with a chest
		
	}

	@Override
	public void collision_with_coin(Coin coin) {
		// When the hero collides with a coin
		
	}
	
	public int getCurr_coins(){
		return curr_coins;
	}
	//GUI METHODS
	public void reward(int amt){
		this.curr_coins +=amt;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	public void herodeath() throws IOException {
		lst.remove(this);
		for(Node obj: lst){
			if (obj instanceof Button){
				saveonpause(this);
				//addonDeath.getChildren().addAll(new Boss_Orc(200, 200, 125, 125, 1, "boss", 3, 2, 3, 4, lst));
				Rectangle endscreen = new Rectangle();
				endscreen.setLayoutX(100);
				endscreen.setLayoutY(300);
				endscreen.setWidth(400);
				endscreen.setHeight(200);
				endscreen.setStyle("-fx-background-color: #00BFFF; -fx-border-color: #000000; -fx-border-width: 1.5px;-fx-border-radius: 15;-fx-background-radius: 15;");
				addonDeath.getChildren().addAll(endscreen);
				Button revive = new Button();
				revive.setLayoutX(120);
				revive.setLayoutY(350);
				revive.setText("Revive? 50 coins");
				Button exit = new Button();
				exit.setLayoutX(120);
				exit.setLayoutY(380);
				exit.setText("Exit?");
				exit.setOnAction(event -> leavegame());

				addonDeath.getChildren().addAll(exit);
				addonDeath.getChildren().addAll(revive);


				break;
			}
		}
	}
	public void saveonpause(Hero mega) throws IOException{
		for(Node obj: lst){
			if(obj instanceof Hero){
				((Hero) obj).falling.stop();
				((Hero) obj).pullback.stop();
				((Hero) obj).dash.stop();
			}
			if(obj instanceof Orc){
				((Orc) obj).falling.stop();
				((Orc) obj).pushed.stop();
				((Orc) obj).blownup.stop();

			}
			if(obj instanceof Throwing_Knife){
				((Throwing_Knife) obj).swish.stop();
			}
		}
		File savefolder =  new File("saveiles");
		File[] savelist = savefolder.listFiles();
		ObjectInputStream in=null;
		String filename="savefiles\\temp.txt";
		try{
			in=new ObjectInputStream(new FileInputStream(filename));}
		catch (FileNotFoundException e)
		{
			File newfile=new File(filename);
			System.out.println(newfile.createNewFile());
		}
		ObjectOutputStream out = null;
		try
		{
			out=new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(mega);
			System.out.println(mega.x);
			//            System.out.println("File saved");

		} catch (IOException e) {
			e.printStackTrace();
		}finally
		{
			if(out!=null) out.close();
		}
	}
	public Hero placehero(Hero mag){
		File savefiles=new File("savefiles");
		File[] savelist=savefiles.listFiles();
		ObjectInputStream in=null;

		try
		{
			String filename="savefiles\\temp.txt";
			System.out.println(filename);
			in=new ObjectInputStream(new FileInputStream(filename));
			if(in==null)
			{
				System.out.println("in was null");
			}
			mag= (Hero) in.readObject();
			System.out.println(mag.getScore());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return mag;
	}

	public void leavegame(){
			for(Node obj: lst){
				if(obj instanceof Button){
					Stage closer = (Stage) obj.getScene().getWindow();
					closer.close();
					break;
				}
			}
	}

	public void winner(){
		Rectangle endscreen = new Rectangle();
		endscreen.setLayoutX(0);
		endscreen.setLayoutY(0);
		endscreen.setWidth(900);
		endscreen.setHeight(600);
		endscreen.setStyle("-fx-background-color: #00BFFF; -fx-border-color: #000000; -fx-border-width: 1.5px;-fx-border-radius: 15;-fx-background-radius: 15;");
		addonDeath.getChildren().addAll(endscreen);
		Label coins = (Label) lst.get(0);
		Label scor = (Label) lst.get(1);
		scor.setText("Position: "+ score);

		Button exit = new Button();
		exit.setLayoutX(120);
		exit.setLayoutY(380);
		exit.setText("Exit?");
		exit.setOnAction(event -> leavegame());

		addonDeath.getChildren().addAll(exit);


	}
	public void revive(){
		Hero x = null;
		x = placehero(x);
		System.out.println(x.getScore());

	}
}
