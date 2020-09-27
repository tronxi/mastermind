package com.upm.mastermind;

public class FeedBackAction extends Action {

    public FeedBackAction(Session session) {
        super(session);
    }

    @Override
    public void execute() {
        assert this.getState() == State.PENDING_FEEDBACK;
        this.getBoard().calculateFeedBack();
        this.getBoard().write();
        if (getBoard().playerWin())
             this.setState(State.WON);
        else if (getBoard().ifFinished())
            this.setState(State.LOSE);
        else {
            this.setState(State.IN_GAME);
            this.getBoard().advanceAttempts();
        }
    }
}
