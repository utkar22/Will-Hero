
public class Orc extends Living_Object{
	private String type;
	private int orc_size;
	private boolean if_bomb;
	private int health;

	Orc(double x, double y, double width, double height, double power, String type, int orc_size, int health,
			int jump_limit, int jump_base, int verticle_speed, int curr_base) {
		super(x, y, width, height, power, 0, jump_limit, jump_base, verticle_speed, curr_base, false);
		
		this.type = type;
		this.orc_size = orc_size;
		this.if_bomb = false;
		this.health = health;
	}
	
	//GETTERS
	public String get_type() {
		return this.type;
	}
	
	public int get_orc_size() {
		return this.orc_size;
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
	public void collision_with_platform(Platform platform) {
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

}
