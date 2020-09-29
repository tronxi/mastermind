package com.upm.mastermind.view;

import com.upm.utils.Console;

public enum Error {

	BAD_COMBINATION_CODE_PEG_PATTERN("Wrong colors, they must be: brpygo"),
	BAD_LONG_CODE_PEG_PATTERN("Wrong proposed combination length"),
	REPEATED_CODE_PEG_PATTERN("Repeated colors"),
	NULL_ERROR;

	private String message;

	Error(){
	}

	Error(String message){
		this.message = message;
	}

	public void writeln() {
		if (this != Error.NULL_ERROR){
			Console.instance().writeln(this.message);
		}
	}

}
