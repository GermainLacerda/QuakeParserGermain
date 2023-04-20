package controller;

import java.io.*;

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

				if (fileLine.contains("InitGame:")) {
					// iniciar jogo
					System.out.println("O jogo "+count+" iniciou");

					while (!fileLine.contains("ShutdownGame:")) {

						if (fileLine.contains("ClientUserinfoChanged:")) {
							System.out.println("jogador entrou na partida");
							System.out.println(fileLine);
						}

						if (fileLine.contains("Kill:")) {
							System.out.println("alguma morte aconteceu");
							System.out.println(fileLine);
						}
						fileLine = quakeBuffer.readLine();

					}
					count++;
				}
				if (fileLine.contains("ShutdownGame:")) {
					System.out.println("O jogo "+(count-1)+" acabou");
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
