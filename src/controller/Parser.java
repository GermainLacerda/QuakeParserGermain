package controller;

import java.io.*;
import java.util.LinkedList;

import model.*;
import view.PlayersView;

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
				PlayersView playerShower = new PlayersView();
				if (fileLine.contains("InitGame:")) {
					System.out.println("O jogo "+count+" iniciou");
					GamesModel game;
					int totalKills = 0;
					LinkedList<PlayersModel> gamePlayers = new LinkedList<>();
					LinkedList<String> kills = new LinkedList<>();
					
					while (!fileLine.contains("ShutdownGame:")) {
						
						if (fileLine.contains("ClientUserinfoChanged:")) {
							//criar e iniciar o objeto do player
							System.out.println("jogador entrou na partida");
							gamePlayers.add(playerBuilder.criarPlayer(fileLine));
							//System.out.println(fileLine);
							playerShower.printPlayerInfos(playerBuilder.criarPlayer(fileLine));
							// chamar a função de regex da linha
						}

						if (fileLine.contains("Kill:")) {
							totalKills++;
							//System.out.println("alguma morte aconteceu");
							//System.out.println(fileLine);
						}
						fileLine = quakeBuffer.readLine();
					}

					game = new GamesModel(count, totalKills, gamePlayers, kills);
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
