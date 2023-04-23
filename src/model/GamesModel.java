package model;

import java.util.*;

public class GamesModel {
	private int gameRound;
	private int totalKills;
	private LinkedList<PlayersModel> players;
	
	
	public GamesModel (int gameRound, int totalKills, LinkedList<PlayersModel> players) {
		this.gameRound = gameRound;
		this.totalKills = totalKills;
		this.players = players;
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
	
	
}
