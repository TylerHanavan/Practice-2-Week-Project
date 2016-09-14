package me.maffew.practice;

import org.bukkit.entity.Player;

public class Elo {
	
	/*
	 * This class used to extend Player, so I thought you were trying to make your own custom Player class. If so, you can't extend user, you can only make a class that takes
	 * Player/UUID/username (string) as a parameter, then keep it consistent through whole plugin from login to logout. Do not call methods from Player after they logout
	 * as the object will have been garbage collected and thus null
	 */

    public static float DEFAULT_ELO = 1000;
    public float minimum_elo = 0;
    
    private Player player = null;
    
    public Elo(Player player) { //Might want to make a static list of Elo, then return from there if exists else make new one, add to list and return. This will keep data consistent
    	
    	this.player = player;
    	
    	this.setDefaultELO();
    	
    }
	
	public void setDefaultELO() {
		this.minimum_elo = this.DEFAULT_ELO;
	}
	
	public void calculateELO(Player a, Player b) { //I'll leave you to fix this, not sure what you're trying to do here.
		int player1 = a.MySQL.getCurrentELO();
		int player2 = b.MySQL.getCurrentELO();
		
		
	}

}
