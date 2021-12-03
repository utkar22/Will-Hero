
public abstract class Game_Object {
	protected double x;
	protected double y;
	protected double width;
	protected double height;
	protected double power;
	
	Game_Object(double x, double y, double width, double height, double power){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.power = power;
	}
	
	//GETTERS
	public double get_x() {
		return this.x;
	}
	
	public double get_y() {
		return this.y;
	}
	
	public double get_width() {
		return this.width;
	}
	
	public double get_height() {
		return this.height;
	}
	
	public double get_power() {
		return this.power;
	}
	
	//SETTERS
	
	public void set_x(double x) {
		this.x = x;
	}
	
	public void set_y(double y) {
		this.y = y;
	}
	
	public void set_width(double width) {
		this.width = width;
	}
	
	public void set_height(double height) {
		this.height = height;
	}
	
	public void set_power(double power) {
		this.power = power;
	}
	
	
	public double get_right_x() {
		//Returns the x coordinate of the right edge
		return this.x + this.width;
	}
	
	public double get_bottom_y() {
		//Returns the y coordinate of the bottom edge
		return this.y + this.height;
	}
	
	//COLLISION METHODS
	
	public boolean check_collision(Game_Object obj) {
		//This method checks if this object is colliding with the given object
		//Checks each edge of this object, and checks if it lies inside the 
		//other object
		
		if (obj.get_x()<=this.x&&this.x<=obj.get_right_x() && obj.get_y()<=this.y&&this.y<=obj.get_bottom_y()) {
			//Top left edge
			return true;
		}
		
		else if (obj.get_x()<=this.get_right_x()&&this.x<=obj.get_right_x() && 
				obj.get_y()<=this.y&&this.y<=obj.get_bottom_y()) {
			//Top right edge
			return true;
		}
		
		else if (obj.get_x()<=this.x&&this.x<=obj.get_right_x() &&
				obj.get_y()<=this.get_bottom_y()&&this.get_bottom_y()<=obj.get_bottom_y()) {
			//Bottom left edge
			return true;
		}
		
		else if (obj.get_x()<=this.get_right_x()&&this.get_right_x()<=obj.get_right_x() &&
				obj.get_y()<=this.get_bottom_y()&&this.get_bottom_y()<=obj.get_bottom_y()) {
			//Bottom right edge
			return true;
		}
		
		return false;
	}
	
	public abstract void collision_with_living_object(Living_Object l_obj);
	public abstract void collision_with_hero(Hero hero);
	public abstract void collision_with_orc(Orc orc);
	public abstract void collision_with_chest(Chest chest);
	public abstract void collision_with_platform(Platform platform);
	public abstract void collision_with_coin(Coin coin);
	
	
	//GUI METHODS
	
	public abstract void draw();
	
	
	

}
