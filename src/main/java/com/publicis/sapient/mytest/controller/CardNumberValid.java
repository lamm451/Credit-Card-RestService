package com.publicis.sapient.mytest.controller;

public class CardNumberValid {
	private boolean isValid;

	public CardNumberValid(boolean isValid) {
		super();
		this.isValid = isValid;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
}
