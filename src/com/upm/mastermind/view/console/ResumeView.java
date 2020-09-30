package com.upm.mastermind.view.console;

import com.upm.mastermind.controller.ResumeController;
import com.upm.mastermind.model.State;
import com.upm.mastermind.view.Message;
import com.upm.utils.Console;
import com.upm.utils.YesNoDialog;

public class ResumeView {

    public void interact(ResumeController resumeController) {
        printState(resumeController.getState());
        resumeController.resume(isResumedGame());
    }

    private void printState(State state) {
        Console console = Console.instance();
        switch (state) {
            case WON:
                console.writeln(Message.PLAYER_WIN.toString());
                break;
            case LOST:
                console.writeln(Message.PLAYER_LOSE.toString());
        }
    }

    private boolean isResumedGame() {
        return new YesNoDialog().read(Message.RESUME.toString());
    }
}
