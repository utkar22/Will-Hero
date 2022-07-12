package com.example.demo1;

public class User {
	private int score;
	private int total_coins;
	private Hero will;
	
	User(Hero will){
		this.will = will;
		this.score = 0;
		this.total_coins = 0;
	}
	
	//GETTERS AND SETTERS
	public int get_score() {
		return this.score;
	}
	
	public int get_total_coins() {
		return this.total_coins;
	}
	
	public Hero get_will() {
		return this.will;
	}
	
	public void set_score(int score) {
		if (score>this.score) {
			this.score = score;
		}
	}
	
	public void update_coins(int amount) {
		this.total_coins += amount;
	}
	
	//OTHER FUNCTIONS
	
	public void revive() {
		//Revives
	}
}
