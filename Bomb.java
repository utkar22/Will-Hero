public class Bomb extends Weapon implements Cloneable{
	private int damage_radius;
	private boolean if_attached;
	private Orc attached_to;
	
	Bomb(double x, double y, double width, double height, double power, String name, int damage) {
		super(x, y, width, height, power, "Bomb", damage);

		this.damage_radius = 5; //dummy value, will be changed
		this.if_attached = false;
		this.attached_to = null;
	}
	
	//GETTERS
	
	public Orc get_attached_to() {
		return this.attached_to;
	}
	
	public int get_damage_radius() {
		return this.damage_radius;
	}
	
	
	//USAGE METHODS
	
	public void explode() {
		//Function about the bomb exploding
	}
	
	@Override
	public void use() {
		// TODO Auto-generated method stub
		
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
	
	//GUI FUNCTIONS
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
