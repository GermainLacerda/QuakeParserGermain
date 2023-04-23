package controller;

import java.util.LinkedList;
import java.util.regex.*;

import model.*;

public class GamesController {
	public LinkedList<Integer> killingMap (String gameLine) {
		
		Pattern pattern = Pattern.compile("Kill:\\s(\\d+)\\s(\\d+)\\s(\\d+)");
		Matcher matcher = pattern.matcher(gameLine);
		matcher.find();
		LinkedList<Integer> killingIDs = new LinkedList<Integer>();
		killingIDs.add(Integer.parseInt(matcher.group(1)));
		killingIDs.add(Integer.parseInt(matcher.group(2)));
		killingIDs.add(Integer.parseInt(matcher.group(3)));
		    
		    
		return killingIDs;
	}
}
