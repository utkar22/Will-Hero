
public abstract class Chest extends Game_Object{
	private boolean if_base;

	Chest(double x, double y, double width, double height, double power) {
		super(x, y, width, height, power);
		this.if_base = false;
	}
	
	
	//BASE Methods
	//At the beginning of every frame, the base is set to be false. 
	//When the chest loops through the collisions, if a collision is found 
	//where the chest has a base, the yes_base() function is called.
	//If no base is found, then the chest will go through falling.
	public void no_base() {
		this.if_base = false;
	}
	
	public void yes_base() {
		this.if_base = true;
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
		// The only collision that matters is that of the chest with the top
		// part of the platform.
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
