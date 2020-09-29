package com.upm.mastermind.controller;

import com.upm.mastermind.model.Game;
import com.upm.mastermind.model.PatternCodePeg;
import com.upm.mastermind.model.State;

public class PutPatternCodePegController extends Controller {

    public PutPatternCodePegController(Game game) {
        super(game);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void put(PatternCodePeg patternCodePeg) {
        assert this.getState() == State.IN_GAME;
        this.getBoard().putPatternCodePeg(patternCodePeg);
        this.setState(State.PENDING_FEEDBACK);
    }
}
