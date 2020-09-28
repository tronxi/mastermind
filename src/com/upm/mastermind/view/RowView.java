package com.upm.mastermind.view;

import com.upm.mastermind.model.Message;
import com.upm.mastermind.model.Row;

public class RowView {

    private Row row;

    public RowView(Row row) {
        this.row = row;
    }

    public void write() {
        new PatternCodePegView(row.getPatternCodePeg()).write();
        Message.ARROW_SEPARATOR.write();
        new PatternKeyPegView(row.getPatternKeyPeg()).write();
        Message.NEW_LINE.writeln();
    }
}
