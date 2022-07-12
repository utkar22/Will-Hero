package com.example.demo1;

import java.util.ArrayList;

public class Game {
	private ArrayList<Level> list_of_levels;
	private User player;
	private int final_score;
	
	Game(User player){
		this.player = player;
		
		this.final_score = 0;
		
		this.list_of_levels = new ArrayList<Level>();
		
	}
	
	//SETTERS AND GETTERS
	
	public void set_final_score(int final_score) {
		this.final_score = final_score;
	}
	
	public int get_final_score() {
		return this.final_score;
	}
	
	
	public void generate_level() {
		//Generates level
	}
	
	public void pause() {
		//Pauses
	}
	
	public void serialise() {
		//Serialises
	}
	
	public void save_game() {
		//Saves game
	}
	

}
