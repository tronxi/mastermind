package com.upm.mastermind;

import com.upm.mastermind.controller.Controller;
import com.upm.mastermind.controller.Logic;
import com.upm.mastermind.view.View;

public abstract class Mastermind {

    private View view;

    public Mastermind() {
        this.view = this.createView();
    }

    public abstract View createView();

    protected void play() {
        Logic logic = new Logic();
        Controller controller;

        do {
            controller = logic.getAction();

            if (controller != null) {
                view.interact(controller);
            }

        } while (controller != null);
    }
}
