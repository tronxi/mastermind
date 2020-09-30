package com.upm.mastermind.view.graphic;

import com.upm.mastermind.view.Error;
import com.upm.mastermind.view.Message;
import com.upm.utils.GraphicDialog;

public class PutPatternCodePegView extends com.upm.mastermind.view.PutPatternCodePegView {

    @Override
    protected void showError(Error error) {
        GraphicDialog.getInstance().error(error.toString());
    }

    @Override
    protected String readInput(Message title, Message message) {
        return GraphicDialog.getInstance().input(title.toString(), message.toString());
    }
}
