package com.upm.mastermind.controller;

import com.upm.mastermind.model.Game;
import com.upm.mastermind.model.State;

public class MakePatternCodePegController extends Controller {

    public MakePatternCodePegController(Game game) {
        super(game);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void make() {
        assert this.getState() == State.INITIAL;
        this.getBoard().generateSecret();
        this.setState(State.IN_GAME);
    }
}
