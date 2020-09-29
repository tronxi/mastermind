package com.upm.mastermind.view.console;

import com.upm.mastermind.controller.ResumeController;
import com.upm.mastermind.model.State;
import com.upm.mastermind.view.Message;
import com.upm.utils.YesNoDialog;

public class ResumeView extends com.upm.mastermind.view.ResumeView {

    @Override
    public void interact(ResumeController resumeController) {
        printState(resumeController.getState());
        resumeController.resume(isResumedGame());
    }

    private void printState(State state) {
        switch (state) {
            case WON:
                Message.PLAYER_WIN.writeln();
                break;
            case LOST:
                Message.PLAYER_LOSE.writeln();
        }
    }

    private boolean isResumedGame() {
        return new YesNoDialog().read(Message.RESUME.toString());
    }
}
