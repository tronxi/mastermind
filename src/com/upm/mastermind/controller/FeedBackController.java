package com.upm.mastermind.controller;

import com.upm.mastermind.model.Game;
import com.upm.mastermind.model.State;

public class FeedBackController extends Controller {

    public FeedBackController(Game game) {
        super(game);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void calculateFeedBack() {
        assert this.getState() == State.PENDING_FEEDBACK;
        this.getBoard().calculateFeedBack();
    }

    public void calculateState() {
        if (getBoard().playerWin())
            this.setState(State.WON);
        else if (getBoard().ifFinished())
            this.setState(State.LOST);
        else {
            this.setState(State.IN_GAME);
            this.getBoard().advanceAttempts();
        }
    }
}
