package com.atmInterface;

import java.util.Scanner;

public class AtmInterface {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		do {
			
			
		System.out.println("Welcome to ATM Services");
		System.out.println("=======================================");
		System.out.println("Click 1 for withdrawing the amount");
		System.out.println("Click 2 for depositing the amount");
		System.out.println("Click 3 for view the account balance");
		System.out.println("=======================================");
		int num=scan.nextInt();
		switch (num) {
		case 1: {
			System.out.println("Enter Withdrawn amount min Rs. 100");
			int amount=scan.nextInt();
			withdraw(amount);
			break;
		}
		case 2: {
			System.out.println("Enter Deposit amount min Rs. 1");
			int amount=scan.nextInt();
			
			deposit(amount);
			break;
		}
		case 3: {
			
			checkBalance();
			break;
		}
		default : {
			System.out.println("Enter correct options !!");
			
		}
		}
		System.out.println("Press # to go to main menu");
		String menu=scan.next();
		if(!menu.equals("#")) {
			break;
		}
		} while (true);
		
		System.out.println("Invalid option entered, Last transaction cancelled !!");
        System.out.println("Thankyou for using ATM services...");
        System.out.println("=======================================");
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        main(args);
        
		
	
	}

	private static void deposit(int amount) {
		if(amount>0) {
			
			double accountBalance=UserBankAccount.initialBalance;
			double finalBalance=accountBalance+amount;
			System.out.println("Your new account balance is Rs. "+finalBalance);
			System.out.println("Thankyou for banking with us.");
		}
		else {
			System.out.println("Enter valid amount");
		}
		
	}

	private static void withdraw(int amount) {
		double accountBalance=UserBankAccount.initialBalance;
		if(amount>accountBalance) {
			System.out.println("Insufficient balance!!");
		}
		else if(amount==0 || amount<100) {
			System.out.println("Last transaction cancelled, Enter minimum Rs. 100");
		}
		else {
			double finalBalance=accountBalance-amount;
			System.out.println("Withdraw amount is Rs. "+finalBalance);
			System.out.println("Thankyou for banking with us.");
		}
		
	}

	private static void checkBalance() {
		double accountBalance=UserBankAccount.initialBalance;
		System.out.println("Account Balance is Rs. "+accountBalance);
		
	}

}
