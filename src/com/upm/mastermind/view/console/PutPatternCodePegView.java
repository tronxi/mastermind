package com.upm.mastermind.view.console;

import com.upm.mastermind.view.Error;
import com.upm.mastermind.view.Message;
import com.upm.utils.Console;

public class PutPatternCodePegView extends com.upm.mastermind.view.PutPatternCodePegView {

    @Override
    protected void showError(Error error) {
        Console.instance().writeln(error.toString());
    }

    @Override
    protected String readInput(Message title, Message message) {
        return Console.instance().readString(Message.ENTER_PATTERN.toString());
    }
}
