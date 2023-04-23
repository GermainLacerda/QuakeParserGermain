package model;

import java.util.LinkedList;
import view.*;

public class KillsModel {
	public LinkedList<PlayersModel> killInterpreter(LinkedList<PlayersModel> playersList, LinkedList<Integer> killIDs) { //acho q deve retorna a list de players atualizada com as kills modificadas
		GamesView deathDisplaier = new GamesView();
		if (killIDs.get(0)==1022) { //detecta se o assassino é o world
			int id = 0;
			String name =null;
			for (int i = 0; i < playersList.size(); i++) {
				if (playersList.get(i).getPlayerID() == killIDs.get(1) ) { //pega o id do player que foi morto pelo world
					name = playersList.get(i).getPlayerName();
					id = playersList.get(i).getPlayerID();
					playersList.get(i).setPlayerKills(playersList.get(i).getPlayerKills()-1);
					
				}
			}	
			deathDisplaier.printDeathInfos("world", name, killIDs.get(2));
			
		}else {
			int id = 0;
			String killerName =null;
			String killedName =null;
			for (int i = 0; i < playersList.size(); i++) {
				if (playersList.get(i).getPlayerID() == killIDs.get(0) ) { //pega o id do player que foi matou
					killerName = playersList.get(i).getPlayerName();
					id = playersList.get(i).getPlayerID();
					playersList.get(i).setPlayerKills(playersList.get(i).getPlayerKills()+1); //adiciona uma kill a quem matou
					
				}
				if(playersList.get(i).getPlayerID() == killIDs.get(1)){
					killedName= playersList.get(i).getPlayerName();
				}
			}
			
			deathDisplaier.printDeathInfos(killerName, killedName, killIDs.get(2));
		}
		return playersList;

	}

	public String killMethods(int code) {
		
		switch (code) {
		case 1:
			return "MOD_SHOTGUN";
		case 3:
			return "MOD_MACHINEGUN";
		case 6:
			return "MOD_ROCKET";
		case 7:
			return "MOD_ROCKET_SPLASH";
		case 10:
			return "MOD_RAILGUN";
		case 12:
			return "MOD_BFG";
		case 13:
			return "MOD_BFG_SPLASH";
		case 17:
			return "MOD_CRUSH";
		case 18:
			return "MOD_TELEFRAG";
		case 19:
			return "MOD_FALLING";
		case 22:
			return "MOD_TRIGGER_HURT";
		default:
			return "Código não reconhecido!";
		}
	}
}