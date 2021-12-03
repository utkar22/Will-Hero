
public class Helmet {
	private Weapon curr_weapon;
	
	private boolean if_throwing_knife;
	private boolean if_bomb;
	
	private Throwing_Knife throwing_knife;
	private Bomb bomb;
	
	Helmet(){
		this.curr_weapon = null;
		
		this.throwing_knife = null;
		this.bomb = null;
		
		this.if_throwing_knife = false;
		this.if_bomb = false;
	}
	
	public void receive_weapon(Weapon weapon) {
		//Receives weapon
		String weapon_name = weapon.get_name();
		
		if (weapon_name.equals("Throwing Knife")) {
			if (!if_throwing_knife) {
				if_throwing_knife = true;
				throwing_knife = (Throwing_Knife) weapon;
			}
			else {
				throwing_knife.update_level();
			}
		}
		else if (weapon_name.equals("Bomb")) {
			if (!if_bomb) {
				if_bomb = true;
				bomb = (Bomb) weapon;
			}
			else {
				bomb.update_level();
			}
		}
	}
	
	public Weapon get_curr_weapon() {
		//Returns (a clone of) the current weapon
		try {
			Weapon send_weapon = (Weapon) curr_weapon.clone();
			return send_weapon;
		}
		catch (Exception e) {
			//In case the weapon is not able to be cloned, we just do not send
			//anything back, and let the user call for the weapon again
			return null;
		}
		finally {
			
		}
	}

}
