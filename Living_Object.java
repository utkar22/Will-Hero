
public abstract class Living_Object extends Game_Object{
	private int curr_jump;
	private int jump_limit;
	private int jump_base;
	private boolean if_alive;
	private int verticle_speed;
	private double curr_base;
	private final boolean if_hero;

	Living_Object(double x, double y, double width, double height, double power,
			int curr_jump, int jump_limit, int jump_base, int verticle_speed, double curr_base, boolean if_hero) 
	{
		super(x, y, width, height, power);
		
		this.curr_jump = curr_jump;
		this.jump_limit = jump_limit;
		this.jump_base = jump_base;
		this.verticle_speed = verticle_speed;
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

	public int get_verticle_speed() {
		return verticle_speed;
	}

	public void set_verticle_speed(int verticle_speed) {
		this.verticle_speed = verticle_speed;
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
		//will decrease it's y value by 0.5 (goes up). If it is equal, then the
		//y value is increased by 0.5 (falls down).
		if (this.curr_jump<jump_limit) {
			this.curr_jump--;
			this.update_y(-.5);
		}
		else {
			this.update_y(.5);
		}
	}
	
	//COLLISION FUNCTIONS
	
	public void collision_with_platform(Platform platform) {
		//This function is for living objects colliding with platforms
		
		if (this.get_right_x()>=platform.get_x() && this.get_x()<platform.get_x()) {
			//In the case where the living object pushes onto the left edge of 
			//the platform, the object moves upwards. This simulates climbing
			this.set_right_x(platform.get_x());
			this.update_y(-2);
		}
		else if (platform.get_x()<this.get_x() && this.y<platform.get_y() 
				&& this.y>=platform.get_bottom_y()) {
			//In the case where the living object hits the platform from below.
			//The living object's jump is set to the max jump, meaning it
			//cannot jump more, and will fall down.
			this.set_y(platform.get_bottom_y());
			this.max_curr_jump();
		}
		else if (this.get_bottom_y()<=platform.get_y()&&this.get_bottom_y()>platform.get_bottom_y()) {
			//In the case where the living object hits the platform from above.
			//The most common case.
			//Case is applicable even if the Living Object is not completely on
			//the platform. Only a part of it being on the platform is fine.
			//The jumping will be reset.
			this.set_bottom_y(platform.get_y());
			this.reset_curr_jump();
		}
	}
	
	public abstract void collision_with_hero(Hero hero);
	public abstract void collision_with_orc(Orc orc);
	public abstract void collision_with_chest(Chest chest);
	public abstract void collision_with_coin(Coin coin);
	
	public void collision_with_living_object(Living_Object l_obj) {
		//No functionality in this method
	}

}
