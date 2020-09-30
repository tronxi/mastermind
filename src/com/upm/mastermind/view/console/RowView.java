package com.upm.mastermind.view.console;

import com.upm.mastermind.model.Row;
import com.upm.mastermind.view.Message;
import com.upm.utils.Console;

public class RowView {

    private Row row;

    public RowView(Row row) {
        this.row = row;
    }

    public void write() {
        Console console = Console.instance();
        new PatternCodePegView(row.getPatternCodePeg()).write();
        console.write(Message.ARROW_SEPARATOR.toString());
        new PatternKeyPegView(row.getPatternKeyPeg()).write();
        console.write(Message.NEW_LINE.toString());
    }
}
