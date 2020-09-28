package com.upm.mastermind;

public class MakePatternCodePegAction extends Action {

    public MakePatternCodePegAction(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        assert this.getState() == State.INITIAL;
        this.getBoard().generateSecret();
        this.setState(State.IN_GAME);
    }
}
