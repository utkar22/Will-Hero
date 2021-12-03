
public abstract class Living_Object extends Game_Object{
	private int curr_jump;
	private int jump_limit;
	private int jump_base;
	private boolean if_alive;
	private int verticle_speed;
	private double curr_base;

	Living_Object(double x, double y, double width, double height, double power,
			int curr_jump, int jump_limit, int jump_base, int verticle_speed, double curr_base) 
	{
		super(x, y, width, height, power);
		
		this.curr_jump = curr_jump;
		this.jump_limit = jump_limit;
		this.jump_base = jump_base;
		this.verticle_speed = verticle_speed;
		this.curr_base = curr_base;
		
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
	
	//COLLISION FUNCTIONS
	
	public void collision_with_platform(Platform platform) {
		//This function is for living objects colliding with platforms
	}
	
	public abstract void collision_with_hero(Hero hero);
	public abstract void collision_with_orc(Orc orc);
	public abstract void collision_with_chest(Chest chest);
	public abstract void collision_with_coin(Coin coin);
	
	public void collision_with_living_object(Living_Object l_obj) {
		//No functionality in this method
	}

}
