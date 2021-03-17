package com.challenge.leaderboard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class LeaderBoard {

	public static void main(String[] args) {
		try {
			JFileChooser chooser = new JFileChooser();
	        int returnVal = chooser.showOpenDialog(null);
	        if(returnVal != JFileChooser.APPROVE_OPTION) {
	            System.out.println("File wasn't selected");
	        }
	        else
	        {
				Scanner scanner = new Scanner(chooser.getSelectedFile());
				
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
				
				createFile(winner);
	        }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void createFile(String winner) {
		try {
		      File myObj = new File("D:\\Tablero-Winner.txt");
		      
		      myObj.createNewFile();
		      writeFile(winner);		      
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
	}
	
	public static void writeFile(String winner) {
		try {
	          FileWriter myWriter = new FileWriter("D:\\Tablero-Winner.txt");
	          myWriter.write(winner);
	          myWriter.close();
	        } catch (IOException e) {
	          e.printStackTrace();
	        }
	}
}
