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
			while ((fileLine = quakeBuffer.readLine()) != null) {
				// System.out.println(fileLine);
				PlayersController playerBuilder = new PlayersController();
				GamesController gamesBuilder = new GamesController();
				KillsModel killMath = new KillsModel();
				PlayersView playerDisplaier = new PlayersView();
				GamesView gameDisplaier = new GamesView();
				
				if (fileLine.contains("InitGame:")) {
					System.out.println("O jogo "+count+" iniciou");
					GamesModel game;
					int totalKills = 0;
					LinkedList<PlayersModel> gamePlayers = new LinkedList<>();
					
					while (!fileLine.contains("ShutdownGame:")) {
						
						if (fileLine.contains("ClientUserinfoChanged:")) {
							PlayersModel player = playerBuilder.playerCreator(fileLine);
							if (!gamePlayers.contains(player)) {
								gamePlayers.add(player);
								System.out.println("jogador entrou na partida");
								playerDisplaier.printPlayerInfos(playerBuilder.playerCreator(fileLine));
							}
							
						}

						if (fileLine.contains("Kill:")) {
							totalKills++;
							LinkedList<Integer> killIDs = gamesBuilder.killingMap(fileLine);// retorna o id de quem matou, quem morreu e como foi morto
							 gamePlayers = killMath.killInterpreter (gamePlayers, killIDs);
							//System.out.println("alguma morte aconteceu");
							//System.out.println(fileLine);
						}
						fileLine = quakeBuffer.readLine();
					}
					System.out.println(totalKills);
					for (int i = 0; i < gamePlayers.size(); i++) {
						int id = gamePlayers.get(i).getPlayerID();
					    String nome = gamePlayers.get(i).getPlayerName();
					    int kills = gamePlayers.get(i).getPlayerKills();
					    System.out.println(id+" - "+nome +": " + kills);
					}
					game = new GamesModel(count, totalKills, gamePlayers);
					
					if (fileLine.contains("ShutdownGame:")) {
						System.out.println("O jogo "+count+" acabou");
					}
					count++;
				}
				

			}
			System.out.println(count);
			quakeBuffer.close();
		} catch (FileNotFoundException FNFE) {
			System.out.println(FNFE.getMessage());

		} catch (IOException IOE) {
			System.out.println(IOE.getMessage());
		}

	}

}
