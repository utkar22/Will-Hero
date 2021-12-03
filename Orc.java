
public class Orc extends Game_Object{
	private String type;
	private int orc_size;
	private boolean if_bomb;

	Orc(double x, double y, double width, double height, double power, String type, int orc_size) {
		super(x, y, width, height, power);
		
		this.type = type;
		this.orc_size = orc_size;
		this.if_bomb = false;
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
