package com.upm.mastermind;

public class Mastermind {

    private void play() {
        Logic logic = new Logic();
        Action action;
        do {
            action = logic.getController();

            if(action != null) {
                action.execute();
            }

        } while (action != null);
    }



    public static void main(String[] args) {
	    new Mastermind().play();
    }
}
