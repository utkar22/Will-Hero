
public class Throwing_Knife extends Weapon implements Cloneable{
	private double tail_length;

	Throwing_Knife(double x, double y, double width, double height, double power, String name, int damage, int tail_length) {
		super(x, y, width, height, power, name, damage);
		// TODO Auto-generated constructor stub
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
