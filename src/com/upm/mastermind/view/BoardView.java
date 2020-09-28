package com.upm.mastermind.view;

import com.upm.mastermind.model.Board;
import com.upm.mastermind.model.Message;
import com.upm.utils.Console;

public class BoardView {

    private Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    public void write() {
        Console.instance().writeln(String.format(Message.ATTEMPTS.toString(), board.getActualAttempt() + 1));
        Message.SECRET.writeln();
        for (int i = 0; i < board.getActualAttempt(); i++) {
            new RowView(board.getRow(i)).write();
        }
        Message.SEPARATOR.writeln();
    }
}
