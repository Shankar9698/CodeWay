package com.numberGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Random random=new Random();
		int minValue=1;
		int maxValue=100;
		int rounds=0;
		int maxAttempt=5;
		int totalWins=0;
		System.out.println("Welcome to number game !!");
		do {
		int attempt=0;
		int randomNumber=random.nextInt(minValue, maxValue);
		System.out.println("Round No "+(rounds+1));
		while(attempt<maxAttempt) {
			System.out.println("Enter User number between "+minValue+" and "+maxValue+" ?");
			int userNumber=scan.nextInt();
			attempt++;
			if(userNumber==randomNumber) {
				System.out.println("Congraulations !!!");
				totalWins++;
				break;
			} else if(userNumber<randomNumber) {
				System.out.println("Too high !!!");
			} else {
				System.out.println("Too low !!!");
			}	
		
		if(attempt==maxAttempt) {
			System.out.println("Number of attempts has completed, correct number is "+randomNumber);
		}
		}
		System.out.println("=========================");
		System.out.println("Do you want to play again ? (yes/no) :");
		String yesOrNo=scan.next().toLowerCase();
		if(yesOrNo.equals("yes")) {
			rounds++;
		}else {
			System.out.println("Game over; Rounds played "+(rounds+1));
			System.out.println("TotalWins "+totalWins);
		    break;
		}
		}
		while(true);
		scan.close();
	}
}