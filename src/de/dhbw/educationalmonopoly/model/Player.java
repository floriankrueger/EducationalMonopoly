package de.dhbw.educationalmonopoly.model;

import de.dhbw.educationalmonopoly.core.IPlayerActionImplementor;

public class Player {

	private Token token;
	private IPlayerActionImplementor actionImplementor;
	
	private boolean bankrupt;
	private String name;
	private int balance;

	{
		this.token = new Token();
		this.bankrupt = false;
	}

	private Player() {
		super();
	}
	
	public Player(String name, int initialAccountBalance) {
		this();
		this.name = name;
		this.balance = initialAccountBalance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void addMoney(int amount) {
		if (amount >= 0) {
			this.balance += amount;
		}
	}
	
	/**
	 * Asks the player's <code>ActionImplementor</code> to ask the user to
	 * roll the dice.
	 * 
	 * @return 
	 */
	public void rollDice() {
		this.actionImplementor.rollDice();
	}
	
	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public boolean isBankrupt() {
		return bankrupt;
	}

	public void setBankrupt(boolean bankrupt) {
		this.bankrupt = bankrupt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IPlayerActionImplementor getActionImplementor() {
		return actionImplementor;
	}

	public void setActionImplementor(IPlayerActionImplementor actionImplementor) {
		this.actionImplementor = actionImplementor;
	}
}
