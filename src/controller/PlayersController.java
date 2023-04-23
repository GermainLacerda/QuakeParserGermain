package controller;

import java.util.regex.*;

import model.*;

public class PlayersController {
	public PlayersModel playerCreator (String playerLine) {
		int playerID;
		String playerName;
		String regexID = "^.*ClientUserinfoChanged:\\s*(\\d+).*";
		String regexName = "n\\\\(.+?)\\\\t";
		Pattern pattern = Pattern.compile(regexID);
		Matcher matcher = pattern.matcher(playerLine);
		
		matcher.find();
		playerID = Integer.parseInt(matcher.group(1));	
			
		pattern = Pattern.compile(regexName);	
		matcher = pattern.matcher(playerLine);
		
		
		matcher.find();
		playerName = matcher.group(1);
		
		PlayersModel player = new PlayersModel (playerID, playerName);	
		return player;
		
		
	}
}
