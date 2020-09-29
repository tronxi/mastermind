package com.upm.mastermind.controller;

import com.upm.mastermind.model.Board;
import com.upm.mastermind.model.Game;
import com.upm.mastermind.model.State;

public class ResumeController extends Controller {

    public ResumeController(Game game) {
        super(game);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void resume(boolean resume) {
        assert this.getState() == State.LOST || this.getState() == State.WON;
        if (resume) {
            this.setBoard(new Board());
            this.setState(State.INITIAL);
        } else {
            this.setState(State.EXIT);
        }
    }
}
