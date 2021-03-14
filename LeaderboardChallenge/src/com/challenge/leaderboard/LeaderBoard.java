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
			
			String winner = "";
			int maxDifference = 0;
			int player1Acum = 0;
			int player2Acum = 0;
			
			for(String round : leaderBoard)
			{
				int spaceIndex = round.indexOf(" ");
				int player1 = Integer.parseInt(round.substring(0, spaceIndex));
				int player2 = Integer.parseInt(round.substring(spaceIndex + 1, round.length()));
				
				player1Acum += player1;
				player2Acum += player2;
				
				int difference = player1Acum - player2Acum;
				difference = difference < 0 ? difference * -1 : difference;
				
				if(maxDifference < difference)
				{
					maxDifference = difference;
					winner = difference > 0 ? "1" : "2";
				}
			}
			
			winner = String.format("%s %d", winner, maxDifference);
			
			System.out.println(winner);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
