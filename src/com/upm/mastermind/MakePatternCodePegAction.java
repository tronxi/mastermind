package com.upm.mastermind;

public class MakePatternCodePegAction extends Action {

    public MakePatternCodePegAction(Session session) {
        super(session);
    }

    @Override
    public void execute() {
        assert this.getState() == State.INITIAL;
        this.getBoard().generateSecret();
        this.setState(State.IN_GAME);
    }
}
