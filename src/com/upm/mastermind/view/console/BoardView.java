package com.upm.mastermind.view.console;

import com.upm.mastermind.model.Board;
import com.upm.mastermind.view.Message;
import com.upm.utils.Console;

public class BoardView {

    private Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    public void write() {
        Console console = Console.instance();
        console.writeln(String.format(Message.ATTEMPTS.toString(), board.getActualAttempt() + 1));
        console.writeln(Message.SECRET.toString());
        for (int i = 0; i <= board.getActualAttempt(); i++) {
            new RowView(board.getRow(i)).write();
        }
        console.writeln(Message.SEPARATOR.toString());
    }
}
