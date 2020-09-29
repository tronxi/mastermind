package com.upm.mastermind;

import com.upm.mastermind.controller.Controller;
import com.upm.mastermind.controller.Logic;
import com.upm.mastermind.view.View;

public class Mastermind {

    private void play() {
        Logic logic = new Logic();
        View view = new View();
        Controller controller;

        do {
            controller = logic.getAction();

            if (controller != null) {
                view.interact(controller);
            }

        } while (controller != null);
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }
}
