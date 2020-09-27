package com.upm.mastermind;

public class PutPatternCodePegAction extends Action {

    public PutPatternCodePegAction(Session session) {
        super(session);
    }

    @Override
    public void execute() {
        assert this.getState() == State.IN_GAME;
        PatternCodePeg patternCodePeg = new PatternCodePeg();
        patternCodePeg.read();
        this.getBoard().putPatternCodePeg(patternCodePeg);
        this.setState(State.PENDING_FEEDBACK);
    }
}
