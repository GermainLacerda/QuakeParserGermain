package model;

import java.util.*;

public class GamesModel {
	private int gameRound;
	private int totalKills;
	private LinkedList<PlayersModel> players;
	private LinkedList<String> kills;
	
	public GamesModel (int gameRound, int totalKills, LinkedList<PlayersModel> players, LinkedList<String> kills) {
		this.gameRound = gameRound;
		this.totalKills = totalKills;
		this.players = players;
		this.kills = kills;
	}
	
	public int getGameRound () {
		return this.gameRound;
	}
	
	public void setGameRound (int gameRound) {
		this.gameRound = gameRound;
	}
	
	public int getTotal_kills () {
		return this.totalKills;
	}
	
	public void settotalKills (int totalKills) {
		this.totalKills = totalKills;
	}
	
	public LinkedList<PlayersModel> getPlayers (){
		return this.players;
	}
	
	public void setPlayers (LinkedList<PlayersModel> players) {
		this.players = players;
	}
	
	public LinkedList<String> getKills (){
		return this.kills;
	}
	
	public void setKills (LinkedList<String> kills) {
		this.kills = kills;
	}
	
	public String toStringGame (GamesModel gamesmodel) {
		return "1";//criar e puxar do view a modelagem da visualização do game  
	}
	
}
