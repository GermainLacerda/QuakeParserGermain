package controller;

import java.io.*;

public class Parser {
	
	
	
	public Parser (String filePath)  {
		String fileLine;
		
		try {
			FileInputStream quakeFile = new FileInputStream (filePath);	
			InputStreamReader quakeStreamRdr = new InputStreamReader(quakeFile);
			BufferedReader quakeBuffer = new BufferedReader (quakeStreamRdr, 262144);
			
			
			
			while ((fileLine = quakeBuffer.readLine()) != null) {
				System.out.println(fileLine);
			}
			
			quakeBuffer.close();
		}catch (FileNotFoundException FNFE) {
			System.out.println(FNFE.getMessage());
			
		}catch (IOException IOE){
			System.out.println(IOE.getMessage());
		}
		
		
	}
	

}
