
public abstract class Chest extends Game_Object{

	Chest(double x, double y, double width, double height, double power) {
		super(x, y, width, height, power);
		// TODO Auto-generated constructor stub
	}
	
	
	
	//COLLISION METHODS

	@Override
	public void collision_with_hero(Hero hero) {
		// Collision with hero
		
	}

	@Override
	public void collision_with_orc(Orc orc) {
		// Collision with orc
		
	}

	@Override
	public void collision_with_platform(Platform platform) {
		// Collision with platform
		
	}
	
	//Other method
	public abstract void reward(Hero hero);

	
	
	////BLANK COLLISION METHODS
	@Override
	public void collision_with_coin(Coin coin) {
		// Does nothing
	}
	@Override
	public void collision_with_chest(Chest chest) {
		// Does nothing
	}
	@Override
	public void collision_with_living_object(Living_Object l_obj) {
		// Does nothing, everything covered by collision_with_hero() and
		// collision_with_orc() methods.
	}
	
}
