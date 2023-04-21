package view;

import model.PlayersModel;

public class PlayersView {
	public void printPlayerInfos(PlayersModel player) {

		System.out.println(player.getPlayerID() + " - " + player.getPlayerName() + ", matou: " + player.getPlayerKills());
	}
}
