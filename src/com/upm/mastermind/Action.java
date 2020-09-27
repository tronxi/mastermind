package com.upm.mastermind;

public abstract class Action {

    protected Session session;

    public Action(Session session) {
        assert session != null;
        this.session = session;
    }

    protected Board getBoard() {
        return session.getBoard();
    }

    protected void setBoard(Board board) {
        session.setBoard(board);
    }

    protected State getState() {
        return session.getState();
    }

    protected void setState(State state) {
        session.setState(state);
    }

    public abstract void execute();
}
