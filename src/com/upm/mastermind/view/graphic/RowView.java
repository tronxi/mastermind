package com.upm.mastermind.view.graphic;

import com.upm.mastermind.model.Row;
import com.upm.mastermind.view.Message;

public class RowView {

    private Row row;

    public RowView(Row row) {
        this.row = row;
    }

    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new PatternCodePegView(row.getPatternCodePeg()).getMessage());
        stringBuilder.append(Message.ARROW_SEPARATOR);
        stringBuilder.append(new PatternKeyPegView(row.getPatternKeyPeg()).getMessage());
        stringBuilder.append(Message.NEW_LINE);
        return stringBuilder.toString();
    }
}
