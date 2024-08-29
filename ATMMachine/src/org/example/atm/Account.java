package org.example.atm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
 
	private int AccountNumber;
	private int PinNumber;
	private double checkingBalance=0;
	private double savingBalance=0;
	
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	
	public int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}
	public int getPinNumber() {
		return PinNumber;
	}
	public void setPinNumber(int pinNumber) {
		PinNumber = pinNumber;
	}
	public double getCheckingBalance() {
		return checkingBalance;
	}
	
	public double getSavingBalance() {
		return savingBalance;
	}
	
	public double calcCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance- amount);
		return checkingBalance;
	}
	
	public double calcSavingWithdraw(double amount) {
		savingBalance = (savingBalance- amount);
		return savingBalance;
	}
		
	public double calcCheckingDeposit(double amount) {
		checkingBalance = (checkingBalance+ amount);
		return checkingBalance;
	}
	
	public double calcSavingDeposit(double amount) {
		savingBalance = (savingBalance+ amount);
		return savingBalance;
	}
	
    public void getCheckingWithdrawInput() {
    	
    	System.out.println("enter the amount you want to withdraw");
    	double amount = input.nextDouble();
    	
    	if((checkingBalance-amount)>=0){
    		calcCheckingWithdraw(amount);
    		System.out.println("New Account Blance:" + moneyFormat.format(checkingBalance));
    	}else {
    		System.out.println("Balance cannot be negative" +"\n");
    	}
    }
    
 public void getSavingWithdrawInput() {
    	
    	System.out.println("enter the amount you want to withdraw");
    	double amount = input.nextDouble();
    	
    	if((savingBalance-amount)>=0){
    		calcSavingWithdraw(amount);
    		System.out.println("New Account Blance:" + moneyFormat.format(savingBalance));
    	}else {
    		System.out.println("Balance cannot be negative" +"\n");
    	}
    }
 
 public void getCheckingDepositInput() {
 	
 	System.out.println("enter the amount you want to deposit");
 	double amount = input.nextDouble();
 	
 	if((checkingBalance+amount)>=0){
 		calcCheckingDeposit(amount);
 		System.out.println("New Account Blance:" + moneyFormat.format(checkingBalance));
 	}else {
 		System.out.println("Balance cannot be negative" +"\n");
 	}
 }
 
 public void getSavingDepositInput() {
	 	
	 	System.out.println("enter the amount you want to deposit");
	 	double amount = input.nextDouble();
	 	
	 	if((savingBalance+amount)>=0){
	 		calcSavingDeposit(amount);
	 		System.out.println("New Account Blance:" + moneyFormat.format(savingBalance));
	 	}else {
	 		System.out.println("Balance cannot be negative" +"\n");
	 	}
	 }
}
	