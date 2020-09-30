package com.upm.mastermind.view.graphic;

import com.upm.mastermind.controller.ResumeController;
import com.upm.mastermind.model.State;
import com.upm.mastermind.view.Message;
import com.upm.utils.GraphicDialog;

public class ResumeView {

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
        String completeMessage = message + Message.NEW_LINE.toString() +
                Message.RESUME.toString();
        return GraphicDialog.getInstance().confirm(Message.TITTLE.toString(), completeMessage);
    }
}
