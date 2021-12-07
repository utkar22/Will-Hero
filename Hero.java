
public class Hero extends Living_Object{
	private User user;
	private int no_of_deaths;
	private double horizontal_speed;
	private int curr_coins;

	Hero(double x, double y, double width, double height, double power, int curr_jump, int jump_limit, int jump_base,
			int verticle_speed, double curr_base) {
		super(x, y, width, height, power, curr_jump, jump_limit, jump_base, verticle_speed, curr_base, true);
		// TODO Auto-generated constructor stub
	}
	
	
	//GETTERS AND SETTERS
	
	
	//WEAPON METHODS
	
	public void receive_weapon(Weapon weapon) {
		//Receives weapon and stores it in the helmet
	}
	
	public void launch_weapon() {
		//Launches the current weapon
	}
	
	public void switch_weapon() {
		//Switches current weapon
	}
	
	//COIN METHODS
	
	public void receive_coins(int coins){
		//Receives coins, and adds it to the user's wallet too
	}
	
	//REVIVAL METHODS
	
	public void revive() {
		//Revives the Hero
	}
	
	
	
	//COLLISION METHODS

	@Override
	public void collision_with_hero(Hero hero) {
		// Empty method
	}

	@Override
	public void collision_with_orc(Orc orc) {
		// When the hero collides with an orc
		
	}

	@Override
	public void collision_with_chest(Chest chest) {
		// When the hero collides with a chest
		
	}

	@Override
	public void collision_with_coin(Coin coin) {
		// When the hero collides with a coin
		
	}
	
	
	//GUI METHODS

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	
}
