package com.upm.mastermind.view.graphic;

import com.upm.mastermind.controller.ResumeController;
import com.upm.mastermind.model.State;
import com.upm.mastermind.view.Message;

import javax.swing.*;

public class ResumeView extends com.upm.mastermind.view.ResumeView {

    @Override
    public void interact(ResumeController resumeController) {
        boolean next = next(resumeController.getState());
        resumeController.resume(next);
    }

    private boolean next(State state) {
        switch (state) {
            case WON:
                return confirmDialog(Message.PLAYER_WIN);
            case LOST:
                return confirmDialog(Message.PLAYER_LOSE);
            default:
                return true;
        }
    }

    private boolean confirmDialog(Message message) {
        return JOptionPane.showConfirmDialog(
                null,
                message + Message.NEW_LINE.toString() +
                        Message.RESUME.toString(),
                "",
                JOptionPane.YES_NO_OPTION) == 0;
    }
}
