package com.upm.mastermind.view;

public enum Message {
    TITTLE("MASTERMIND"),
    ATTEMPTS("%d attempt(s):"),
    SEPARATOR("-------------"),
    NEW_LINE("\n"),
    SECRET("****"),
    ARROW_SEPARATOR(" --> "),
    ENTER_PATTERN("Propose a combination of 4 (brpygo): "),
    PLAYER_WIN("Player: You win!"),
    PLAYER_LOSE("Player: You lose"),
    RESUME("Do you want to continue"),
    KEY_PEG_OCCURRENCES("%s blacks and %s whites");

    private String message;

    private Message() {

    }

    private Message(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return this.message;
    }

}