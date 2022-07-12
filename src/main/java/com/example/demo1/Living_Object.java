package com.example.demo1;

import java.io.Serializable;

public abstract class Living_Object extends Game_Object implements Serializable {
	private int curr_jump;
	private int jump_limit;
	private int jump_base;
	private boolean if_alive;
	private int vertical_speed;
	private double curr_base;
	private final boolean if_hero;
	private static final long serialVersionUID = 26;
	Living_Object(double x, double y, double width, double height, double power,
			int curr_jump, int jump_limit, int jump_base, int vertical_speed, double curr_base, boolean if_hero)
	{
		super(x, y, width, height, power);
		
		this.curr_jump = curr_jump;
		this.jump_limit = jump_limit;
		this.jump_base = jump_base;
		this.vertical_speed = vertical_speed;
		this.curr_base = curr_base;
		this.if_hero = if_hero;
		
		this.if_alive = true;
		
		
	}
	
	
	//GETTERS AND SETTERS

	public int get_curr_jump() {
		return curr_jump;
	}

	public void set_curr_jump(int curr_jump) {
		this.curr_jump = curr_jump;
	}

	public int get_jump_limit() {
		return jump_limit;
	}

	public void set_jump_limit(int jump_limit) {
		this.jump_limit = jump_limit;
	}

	public int get_jump_base() {
		return jump_base;
	}

	public void set_jump_base(int jump_base) {
		this.jump_base = jump_base;
	}

	public boolean is_if_alive() {
		return if_alive;
	}

	public void set_if_alive(boolean if_alive) {
		this.if_alive = if_alive;
	}

	public int get_vertical_speed() {
		return vertical_speed;
	}

	public void set_vertical_speed(int vertical_speed) {
		this.vertical_speed = vertical_speed;
	}
	
	//JUMP
	public void reset_curr_jump() {
		this.curr_jump = 0;
	}
	
	public void max_curr_jump() {
		this.curr_jump = jump_limit;
	}
	
	public void jump() {
		//If the current jump is smaller than the jump limit, the Living Object
		//will decrease it's y value by 10 (goes up). If it is equal, then the
		//y value is increased by 10 (falls down).
		this.setLayoutY(this.getLayoutY()-100);
		//System.out.println("working");
	}
	
	//COLLISION FUNCTIONS
	
	public boolean collision_with_platform(Platform obj) {
		//This function is for living objects colliding with platforms

		if((x + width >= ((Platform) obj).x && x<=((Platform) obj).x + ((Platform) obj).width) && (y+height>= ((Platform) obj).y+10 && y+height<= obj.y+ ((Platform) obj).height)){
			return true;
		}
		return false;
	}
	
	public abstract void collision_with_hero(Hero hero);
	public abstract void collision_with_orc(Orc orc);
	public abstract void collision_with_chest(Chest chest);
	public abstract void collision_with_coin(Coin coin);
	
	public void collision_with_living_object(Living_Object l_obj) {
		//No functionality in this method
	}

}
