package model;

public class PlayersModel {
	private int playerID;
	private String playerName;
	private int playerKills;
	
	public PlayersModel (int playerID, String playerName) {
		this.playerID = playerID;
		this.playerName = playerName;
	}
	
	public int getPlayerID () {
		return this.playerID;
	}
	
	public String getPlayerName () {
		return this.playerName;
	}
	
	public void setPlayerName (String playerName) {
		this.playerName = playerName;
	}
	
	public int getPlayerKills () {
		return this.playerKills;
	}
	
	public void setPlayerKills (int playerKills) {
		this.playerKills = playerKills;
	}
}
