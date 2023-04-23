package view;

import java.util.LinkedList;

import model.*;

public class GamesView {
	public void printGameInfos(int gameRound, int totalKills, LinkedList<PlayersModel> players) {

		String tittle = "game_" + gameRound + " {";
		String totalKillsInGame = "\n	total_kills: " + totalKills + ";";
		String playersInGame = "\n	Players:" + nameFormater(players);
		String killsInGame = "\n	Kills: {" +  killFormater(players); 
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
		return null;
	}
	
	public String killFormater (LinkedList<PlayersModel> players) {
		return null;
	}
}
