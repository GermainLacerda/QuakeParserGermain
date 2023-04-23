package main;

import java.io.*;
import java.util.regex.*;

import controller.*;

public class Main {

	public static void main(String[] args) {
		File parserFile = new File("F:\\eclipse-workspace\\QuakeParserGermain\\src\\main\\quake_parser.log");

		if (!parserFile.exists()) {
			parserFile.mkdir();
		}
		Parser quakeParser = new Parser(parserFile.getPath());
		
		//String input = " 4:00 Kill: 1022 2 6: Zeh killed Dono da Bola by MOD_ROCKET";
		
		//GamesController gc = new GamesController();
		//System.out.println( gc.killingMap(input).get(0)+" "+ gc.killingMap(input).get(1)+" "+gc.killingMap(input).get(2));

	}

}
