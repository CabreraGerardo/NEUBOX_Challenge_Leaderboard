package com.challenge.leaderboard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeaderBoard {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new File("D:/Tablero.txt"));
			
			String[] leaderBoard = null;
			int i = 0;
			
			while (scanner.hasNextLine()) {
				if(i == 0)
				{
					leaderBoard = new String[Integer.parseInt(scanner.nextLine())];
				}
				else
				{
					leaderBoard[i - 1] = scanner.nextLine();
				}
				i++;
			}
			scanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
