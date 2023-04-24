package main;

import java.io.*;

import controller.*;

public class Main {

	public static void main(String[] args) {
		File parserFile = new File("F:\\eclipse-workspace\\QuakeParserGermain\\src\\main\\quake_parser.log");

		if (!parserFile.exists()) {
			parserFile.mkdir();
		}
		Parser quakeParser = new Parser(parserFile.getPath());
		
 	}

}
