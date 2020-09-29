package com.upm.mastermind.controller;

import com.upm.mastermind.model.Board;
import com.upm.mastermind.model.Game;
import com.upm.mastermind.model.State;

public abstract class Controller {

    private final Game game;

    public Controller(Game game) {
        assert game != null;
        this.game = game;
    }

    public Board getBoard() {
        return game.getBoard();
    }

    protected void setBoard(Board board) {
        game.setBoard(board);
    }

    public State getState() {
        return game.getState();
    }

    protected void setState(State state) {
        game.setState(state);
    }

    public abstract void accept(ControllerVisitor controllerVisitor);

}
