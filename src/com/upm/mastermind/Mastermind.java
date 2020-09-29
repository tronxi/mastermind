package com.upm.mastermind;

import com.upm.mastermind.controller.Controller;
import com.upm.mastermind.controller.Logic;
import com.upm.mastermind.view.View;
import com.upm.mastermind.view.console.ConsoleView;
import com.upm.mastermind.view.graphic.GraphicView;

public class Mastermind {

    private View view;

    public Mastermind(View view) {
        this.view = view;
    }

    private void play() {
        Logic logic = new Logic();
        Controller controller;

        do {
            controller = logic.getAction();

            if (controller != null) {
                view.interact(controller);
            }

        } while (controller != null);
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("graphic")) {
            new Mastermind(new GraphicView()).play();
        } else {
            new Mastermind(new ConsoleView()).play();
        }
    }
}
