package com.upm.mastermind.view;

import com.upm.mastermind.model.Board;

public abstract class View {

    private Board board;

    public View(Board board) {
        this.board = board;
    }

    public abstract void write();

    protected Board getBoard() {
        return new Board();
    }
}
