package com.upm.mastermind;

public abstract class Action {

    private final Game game;

    public Action(Game game) {
        assert game != null;
        this.game = game;
    }

    protected Board getBoard() {
        return game.getBoard();
    }

    protected void setBoard(Board board) {
        game.setBoard(board);
    }

    protected State getState() {
        return game.getState();
    }

    protected void setState(State state) {
        game.setState(state);
    }

    public abstract void execute();
}
