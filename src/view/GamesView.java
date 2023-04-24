package view;

import java.util.LinkedList;

import model.*;

public class GamesView {
	public void printGameInfos(GamesModel game) {
		
		

		String tittle = "game_" + game.getGameRound() + " {";
		String totalKillsInGame = "\n	total_kills: " + game.getTotal_kills() + ";";
		String playersInGame = "\n	Players:" + nameFormater(game.getPlayers());
		String killsInGame = "\n	Kills: {" +  killFormater(game.getPlayers()); 
		String closeTittle = "\n}";

		System.out.println(tittle + totalKillsInGame + playersInGame + killsInGame + closeTittle);
	}

	public void printDeathInfos(String killer, String killed, int method) {
		KillsModel killMethods = new KillsModel();
		String modMethod = killMethods.killMethods(method).replace("MOD_", "");
		if (!killer.equalsIgnoreCase("world")) {
			if (modMethod.contains("SPLASH")) {
				if (modMethod.contains("BFG")) {
					modMethod = modMethod.replace("_SPLASH", "");
				} else {
					modMethod = (modMethod.substring(0, 1).toUpperCase() + modMethod.substring(1).toLowerCase()).replace("_splash", "");
				}
				System.out.println(
						"O player " + killer + " matou o player " + killed + " usando a explosão da arma " + modMethod);
			} else {
				modMethod = (modMethod.substring(0, 1).toUpperCase() + modMethod.substring(1).toLowerCase());
				System.out.println("O player " + killer + " matou o player " + killed + " usando a arma " + modMethod);
			}

		} else {
			if (modMethod.contains("TRIGGER_HURT")) {
				System.out.println("O player " + killed + " morreu pois estava com pouca vida e sofreu um dano mundano");
			} else if (modMethod.equals("FALLING")) {
				System.out.println("O player " + killed + " morreu pois caiu de uma altura muito alta");
			} else {
				System.out.println("O player " + killed + " morreu pois foi esmagado");
			}
		}

	}
	
	public String nameFormater (LinkedList<PlayersModel> players) {
		String playersName = " ";
		for (int i = 0; i < players.size()-1; i++) {
			playersName = playersName + "\""+players.get(i).getPlayerName()+"\", ";
		}
		playersName = playersName + "\""+players.get(players.size()-1).getPlayerName()+"\"";
		return playersName;
	}
	
	public String killFormater (LinkedList<PlayersModel> players) {
		String playersKills = "\n";
		playersKills = playersKills + "		\""+players.get(0).getPlayerName()+"\": "+players.get(0).getPlayerKills()+", \n";
		for (int i = 1; i < players.size()-1; i++) {
			playersKills = playersKills + "		\""+players.get(i).getPlayerName()+"\": "+players.get(i).getPlayerKills()+", \n";
		}
		playersKills = playersKills + "		\""+players.get(players.size()-1).getPlayerName()+"\": "+players.get(players.size()-1).getPlayerKills()+"\n	}";
		return playersKills;
	}
}
