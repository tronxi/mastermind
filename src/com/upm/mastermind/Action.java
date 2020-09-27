package com.upm.mastermind;

public abstract class Action {

    protected Session session;

    public Action(Session session) {
        assert session != null;
        this.session = session;
    }

    protected Board getBoard() {
        return this.session.getBoard();
    }

    protected void setBoard(Board board) {
        this.session.setBoard(board);
    }

    protected State getState() {
        return this.session.getState();
    }

    protected void setState(State state) {
        this.session.setState(state);
    }

    public abstract void execute();
}
