package com.upm.mastermind.view.graphic;

import com.upm.mastermind.model.Board;
import com.upm.mastermind.view.Message;

public class BoardView {

    private Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(Message.ATTEMPTS.toString(), board.getActualAttempt() + 1));
        stringBuilder.append(Message.SECRET.toString() + Message.NEW_LINE.toString());
        for (int i = 0; i <= board.getActualAttempt(); i++) {
            stringBuilder.append(new RowView(board.getRow(i)).getMessage());
        }
        stringBuilder.append(Message.SEPARATOR);
        return stringBuilder.toString();
    }
}
