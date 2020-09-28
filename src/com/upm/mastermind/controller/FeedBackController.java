package com.upm.mastermind.controller;

import com.upm.mastermind.model.Game;
import com.upm.mastermind.model.State;
import com.upm.mastermind.view.BoardView;

public class FeedBackController extends Controller {

    public FeedBackController(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        assert this.getState() == State.PENDING_FEEDBACK;
        this.getBoard().calculateFeedBack();
        new BoardView(getBoard()).write();
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
