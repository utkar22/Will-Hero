
public abstract class Weapon extends Game_Object implements Cloneable{
	private final String name;
	private int level;
	private int damage;
	
	Weapon(double x, double y, double width, double height, double power, String name, int damage) {
		super(x, y, width, height, power);
		this.name = name;
		this.damage = damage;
		
		this.level = 1;
		// TODO Auto-generated constructor stub
	}
	
	
	//GETTERS AND SETTERS
	public String get_name() {
		return this.name;
	}
	
	//UPDATERS	
	private void update_damage(int change) {
		//Updates damage
	}
	
	public void update_level() {
		//Updates level
	}
	
	//OTHER FUNCTIONS
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public abstract void use();
	
	
}
