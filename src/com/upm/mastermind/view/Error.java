package com.upm.mastermind.view;

public enum Error {

	BAD_COMBINATION_CODE_PEG_PATTERN("Wrong colors, they must be: brpygo"),
	BAD_LONG_CODE_PEG_PATTERN("Wrong proposed combination length"),
	REPEATED_CODE_PEG_PATTERN("Repeated colors");

	private String message;

	Error(String message){
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}

}
