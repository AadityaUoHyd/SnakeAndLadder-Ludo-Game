//WAP for Snake and Ladder Ludo Game.
package com.aadi.snakeAndLadder;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class SnakeAndLadderMain {

	public static Map<Integer, Integer> getSnakePositions(){
		Map<Integer, Integer> snakePositions = new TreeMap<Integer, Integer>();
		//capturing positions of snakes
		snakePositions.put(54,17);
		snakePositions.put(68,47);
		snakePositions.put(82,21);
		snakePositions.put(96,43);
		return snakePositions;		
	}

	public static Map<Integer, Integer> getLadderPositions(){
		Map<Integer, Integer> ladderPositions = new TreeMap<Integer, Integer>();
		//capturing positions of ladders
		ladderPositions.put(5,35);
		ladderPositions.put(30,53);
		ladderPositions.put(59,83);
		ladderPositions.put(67,73);
		return ladderPositions;		
	}

	public static int rollDice() {
		Random random = new Random();
		int diceValue = (random.nextInt(6))+1;
		System.out.println("@Dice value is : "+diceValue+"\n");
		return diceValue;
	}

	public static void main(String[] args) {

		System.out.println("\t\t ##### Welcome To Snake And Ladder Ludo Game ##### \n ");
		System.out.println("Kindly enter the number of players want to play in Snake-Ladder-Tournament : ");
		
		//Loading snake and ladder positions.
		Map<Integer, Integer> ladderPositions = getLadderPositions();
		Map<Integer, Integer> snakePositions = getSnakePositions();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		//Get number of participants.
		int noOfParticipants = scanner.nextInt();
		System.out.println("Total "+ noOfParticipants+" players are playing this game. Now, let's play :~\n");

		boolean isGameEnd = false;
		int currentPlayer = 1;
		Integer score[] = new Integer[noOfParticipants];
		for(int i=0; i< noOfParticipants; i++) {
			score[i]=0;
		}

		//Game playing logic.
		while(!isGameEnd) {
			System.out.println(" => This is Player-"+currentPlayer+", and Player-"+currentPlayer+" has total score: "+score[currentPlayer-1]);

			boolean isSnakeBite = false;
			boolean isLadderClimb = false;
			boolean isDiceSix = false;

			System.out.println("    Kindly press 'ENTER' key to roll dice for Player-"+currentPlayer);
			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
			s.nextLine();

			int diceValue = rollDice();
			isDiceSix = (diceValue == 6);
			int tempScore = score[currentPlayer-1]+diceValue;

			if(tempScore == 100) {
				isGameEnd = true;
				System.out.println("Winner is : "+currentPlayer);
			}

			if(snakePositions.containsKey(tempScore)) {
				System.out.println("Player-"+currentPlayer+", sorry! you're biten by SNAKE. \n");
				tempScore = snakePositions.get(tempScore);
				isSnakeBite = true;
			}
			else
			{ 
				if(ladderPositions.containsKey(tempScore)) {
					System.out.println("Player-"+currentPlayer+", congrats! please climb the LADDER.");
					tempScore = ladderPositions.get(tempScore);
					isLadderClimb = true;
				}
			}
			if(tempScore <= 100) {
				score[currentPlayer-1]=tempScore;
			}

			if(!isSnakeBite && (tempScore <= 100 ) && (isDiceSix || isLadderClimb)) {
				System.out.println("current Player-"+currentPlayer+" got retry");
			}
			else {
				//Retry logic
				if(currentPlayer == noOfParticipants) {
					currentPlayer = 1;
				}
				else {
					currentPlayer++;
				}

			}

		}
	}

}