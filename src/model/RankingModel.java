package model;

import java.util.*;

public class RankingModel {
	public void killRank (LinkedList<GamesModel> gameList) {
		LinkedList<PlayersModel> playerList = new LinkedList<>();
		String playerName;
		PlayersModel player;
		for (int i = 0; i<gameList.size(); i++) {
			for (int j=0; j < gameList.get(i).getPlayers().size(); j++) {
				player = gameList.get(i).getPlayers().get(j); 
				playerName = player.getPlayerName(); 
				boolean found = false;
				
				if(playerList.isEmpty()) {
					playerList.add(player);
				}else{
					for(int k = 0; k< playerList.size();k++) {
						if (playerList.get(k).getPlayerName().equals(playerName)) {
							playerList.get(k).setPlayerKills(playerList.get(k).getPlayerKills()+player.getPlayerKills());
							found =true;
						}
					}
					if (found == false) {
						playerList.add(player);
					}
				}
			
			}
		}
		playerList = rankSort(playerList);
		System.out.println("\n\n\n\n");
		for(int k = 0; k< playerList.size();k++) {
			System.out.println(playerList.get(k).getPlayerName() + ": " + playerList.get(k).getPlayerKills());
			
		}	
			
			
		}
		
		public LinkedList<PlayersModel> rankSort (LinkedList<PlayersModel> playerList){
			//LinkedList<PlayersModel> rankSorted = new LinkedList<> ();
			
			playerList.sort(Comparator.comparingInt(PlayersModel::getPlayerKills).reversed());
			
			return playerList;
		}
	
}
