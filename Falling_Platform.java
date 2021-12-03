
public class Falling_Platform extends Platform{
	private boolean if_interacted;
	private int time_to_fall;

	Falling_Platform(double x, double y, double width, double height, double power) {
		super(x, y, width, height, power);
		// TODO Auto-generated constructor stub
	}
	
	public void update_fall_time() {
		//Updates the falling time
	}
	
	public void fall() {
		//Falls
	}
	
	@Override
	public void collision_with_hero(Hero hero) {
		//Collision with hero
	}

}
