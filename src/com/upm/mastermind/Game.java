package com.upm.mastermind;

public class Game {
    private Board board;
    private State state;

    public Game() {
        this.board = new Board();
        this.state = State.INITIAL;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
