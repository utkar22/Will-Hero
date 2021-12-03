
public class Level {
	private int level_number;
	private World main_world;
	
	Level(int level_number){
		this.level_number = level_number;
		this.main_world = null;
	}
	
	public void generate_world() {
		//Generates the world
	}
}
