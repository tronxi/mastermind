package com.upm.mastermind.controller;

import com.upm.mastermind.model.Game;
import com.upm.mastermind.model.PatternCodePeg;
import com.upm.mastermind.model.State;

public class PutPatternCodePegController extends Controller {

    public PutPatternCodePegController(Game game) {
        super(game);
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
