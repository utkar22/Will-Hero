
public class Weapon_Chest extends Chest{
	private Weapon chest_contains;

	Weapon_Chest(double x, double y, double width, double height, double power, Weapon chest_contains) {
		super(x, y, width, height, power);
		this.chest_contains = chest_contains;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void reward(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
