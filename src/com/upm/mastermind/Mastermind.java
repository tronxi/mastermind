package com.upm.mastermind;

import com.upm.mastermind.controller.Controller;
import com.upm.mastermind.controller.Logic;

public class Mastermind {

    private void play() {
        Logic logic = new Logic();
        Controller controller;
        do {
            controller = logic.getAction();

            if (controller != null) {
                controller.execute();
            }

        } while (controller != null);
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }
}
