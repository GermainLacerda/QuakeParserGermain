package view;

import java.util.LinkedList;

import model.PlayersModel;

public class GamesView {
	public void printGameInfos(int gameRound, int totalKills, LinkedList<PlayersModel> players,
			LinkedList<String> kills) {

		String tittle = "game_" + gameRound + " {";
		String totalKillsInGame = "\n	total_kills: " + totalKills + ";";
		String playersInGame = "\n	Players:" + players.toString();
		String killsInGame = "\n	Kills: {"
				+ "\n		adonaldinho: 5\n		dibraldinho: 18\n		adoninho: 20\n	}"; // é possivel fazer um
																								// metodo para fazer
																								// a formatação de uma
																								// String lendo o vetor
																								// e adicionando os
																								// espaços e imprimindo
																								// o players e suas
																								// kills por linha
		String closeTittle = "\n}";

		System.out.println(tittle + totalKillsInGame + playersInGame + killsInGame + closeTittle); 
	}
}
