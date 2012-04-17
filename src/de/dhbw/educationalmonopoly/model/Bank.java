/**
	EducationalMonopoly
	Bank.java
	Apr 16, 2012
*/

package de.dhbw.educationalmonopoly.model;

public class Bank {

	private int balance;
	
	private Bank() {
		super();
	}
	
	public Bank(int initialBalance) {
		this();
		this.balance = initialBalance;
	}
	
	public boolean payPlayer(Player player, int amount) {
		boolean didPay = false;
		
		if ((amount >= 0) && (this.balance >= amount) && (null != player)) {
			player.addMoney(amount);
			this.balance -= amount;
			didPay = true;
		}
		
		return didPay;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
