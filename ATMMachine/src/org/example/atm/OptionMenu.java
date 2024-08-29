package org.example.atm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account{

Scanner menuInput = new Scanner(System.in);
	
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

	private int selection;
	
	/* Validate Login information customer number and pin number*/
	
	public void getLogin() throws IOException {
		
		int x=1;
		do {
			
			try {
				data.put(1234567, 4567);
				data.put(2345678, 5678);
				
				System.out.println("Welcome to the ATM Project!");
				System.out.println("Enter your Account Number");
				setAccountNumber(menuInput.nextInt());
				System.out.println("Enter Pin Number");
				setPinNumber(menuInput.nextInt());
				
			}catch (Exception e) {
				System.out.println("\n"+ "Found Invalid Characters. Only numbers are allowed "+ "\n");
				x=2;
			}
			
			for(Entry<Integer, Integer> entry: data.entrySet()) {
				if(entry.getKey()==getAccountNumber() && entry.getValue()==getPinNumber()) {
					getAccountType();
				}
			}
			System.out.println("\n"+ "Invalid Account Number or Pin Number"+ "\n");
		}while(x==1);
	}
	
	public void getAccountType() {
		System.out.println("Select the Account you want to access: ");
		System.out.println("Type 1 - Checking Account ");
		System.out.println("Type 2 - Saving Account");
		System.out.println("Type 3 - Exit");
		System.out.println("Choice: ");
		
		selection = menuInput.nextInt();
		
		switch (selection) {
		case 1:
			getChecking();
			break;
			
		case 2:
			getSaving();
			break;
			
		case 3:
			System.out.println("Thank you for using this ATM, Bye.");
			break;
			
		case 4:
			System.out.println("\n" + "Invalid choice" + "\n");
			getAccountType();
			
		}
		
	}

	private void getSaving() {
		System.out.println("Saving Account :");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 -Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("choice :");
        
        selection = menuInput.nextInt();
        
        switch (selection) {
        
        case 1:
        	System.out.println(" Saving Account Blance:" + moneyFormat.format(getSavingBalance()));
        	getAccountType();
        	break;
        case 2:
        	getSavingWithdrawInput();
        	getAccountType();
        	break;
        case 3:
        	getSavingDepositInput();
        	getAccountType();
        	break;
        case 4:
        	System.out.println("Thank you for using the ATM, Bye.");
        	break;
        default:
        	System.out.println( "\n" +"Invalid choice" +"\n");
        	getChecking();
        	
        }		
	}

	public void getChecking() {
        System.out.println("Checking Account :");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 -Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("choice :");
        
        selection = menuInput.nextInt();
        
        switch (selection) {
        
        case 1:
        	System.out.println("Checking Account Blance:" + moneyFormat.format(getCheckingBalance()));
        	getAccountType();
        	break;
        case 2:
        	getCheckingWithdrawInput();
        	getAccountType();
        	break;
        case 3:
        	getCheckingDepositInput();
        	getAccountType();
        	break;
        case 4:
        	System.out.println("Thank you for using the ATM, Bye.");
        	break;
        default:
        	System.out.println( "\n" +"Invalid choice" +"\n");
        	getChecking();
        	
        }
        
	}

}
