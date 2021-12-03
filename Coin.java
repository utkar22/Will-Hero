
public class Coin extends Game_Object{
	private final int reward_amount;

	Coin(double x, double y, double width, double height, double power, int reward_amount) {
		super(x, y, width, height, power);
		this.reward_amount = reward_amount;
	}

	

	@Override
	public void collision_with_hero(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	public void reward(Hero hero) {
		//Rewards hero
	}

	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	
	
	//Blank collision methods
	@Override
	public void collision_with_coin(Coin coin) {
		//Empty method
	}
	@Override
	public void collision_with_platform(Platform platform) {
		// Empty method
	}
	@Override
	public void collision_with_chest(Chest chest) {
		// Empty method
	}
	@Override
	public void collision_with_orc(Orc orc) {
		// Empty method
	}
	@Override
	public void collision_with_living_object(Living_Object l_obj) {
		// Empty method
	}

}
