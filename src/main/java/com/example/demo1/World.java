package com.example.demo1;

import java.util.ArrayList;

public class World {
	private ArrayList<Platform> list_of_platforms;
	private ArrayList<Orc> list_of_orcs;
	private ArrayList<Weapon> list_of_weapons;
	private ArrayList<Coin> list_of_coins;
	private ArrayList<Chest> list_of_chests;
	
	private Hero will;
	
	World(){
		this.list_of_platforms = new ArrayList<Platform>();
		this.list_of_orcs = new ArrayList<Orc>();
		this.list_of_weapons = new ArrayList<Weapon>();
		this.list_of_coins = new ArrayList<Coin>();
		this.list_of_chests = new ArrayList<Chest>();
		
		this.will = null;
	}
	
	private void generate_platforms() {
		//Generates platforms
	}
	
	private void generate_orcs() {
		//Generates Orcs
	}
	
	private void generate_coins() {
		//Generate Coins
	}
	
	private void generate_chests() {
		//Generates Chests
	}
	
	
	public void generate_world_objects() {
		//Generates all of the world objects
		//Calls the other functions
		//Also generates the hero
	}
	

}
