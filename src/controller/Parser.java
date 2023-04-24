package controller;

import java.io.*;
import java.util.LinkedList;

import model.*;
import view.*;

public class Parser {

	public Parser(String filePath) {
		String fileLine;

		try {
			FileInputStream quakeFile = new FileInputStream(filePath);
			InputStreamReader quakeStreamRdr = new InputStreamReader(quakeFile);
			BufferedReader quakeBuffer = new BufferedReader(quakeStreamRdr, 262144);
			int count = 1;
			LinkedList<GamesModel> gameList = new LinkedList<>();
			RankingModel playerRank =new RankingModel();
			while ((fileLine = quakeBuffer.readLine()) != null) {
				// System.out.println(fileLine);
				PlayersController playerBuilder = new PlayersController();
				GamesController gamesBuilder = new GamesController();
				KillsModel killMath = new KillsModel();
				PlayersView playerDisplaier = new PlayersView();
				GamesView gameDisplaier = new GamesView();
				
				if (fileLine.contains("InitGame:")) {
					GamesModel game;
					int totalKills = 0;
					LinkedList<PlayersModel> gamePlayers = new LinkedList<>();
					
					while (!fileLine.contains("ShutdownGame:")) {
						
						if (fileLine.contains("ClientUserinfoChanged:")) {
							PlayersModel player = playerBuilder.playerCreator(fileLine);
							if (!gamePlayers.contains(player)) {
								gamePlayers.add(player);
							}
							
						}

						if (fileLine.contains("Kill:")) {
							totalKills++;
							LinkedList<Integer> killIDs = gamesBuilder.killingMap(fileLine);
							 gamePlayers = killMath.killInterpreter (gamePlayers, killIDs);
						}
						fileLine = quakeBuffer.readLine();
					}
					
					game = new GamesModel(count, totalKills, gamePlayers);
					gameDisplaier.printGameInfos(game);
					gameList.add(game);
					count++;
				}
				

			}
			playerRank.killRank(gameList);
			quakeBuffer.close();
		} catch (FileNotFoundException FNFE) {
			System.out.println(FNFE.getMessage());

		} catch (IOException IOE) {
			System.out.println(IOE.getMessage());
		}

	}

}
