package de.dhbw.educationalmonopoly.model;

public class Player {

	private Token token;
	
	{
		this.token = new Token();
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}
}


