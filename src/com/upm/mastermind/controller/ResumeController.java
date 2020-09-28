package com.upm.mastermind.controller;

import com.upm.mastermind.model.Board;
import com.upm.mastermind.model.Game;
import com.upm.mastermind.model.Message;
import com.upm.mastermind.model.State;
import com.upm.utils.YesNoDialog;

public class ResumeController extends Controller {

    public ResumeController(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        assert this.getState() == State.LOST || this.getState() == State.WON;
        printState(this.getState());

        if (isResumedGame()) {
            this.setBoard(new Board());
            this.setState(State.INITIAL);
        } else {
            this.setState(State.EXIT);
        }
    }

    private void printState(State state) {
        switch (state) {
            case WON:
                Message.PLAYER_WIN.writeln();
                break;
            case LOST:
                Message.PLAYER_LOSE.writeln();
        }
    }

    private boolean isResumedGame() {
        return new YesNoDialog().read(Message.RESUME.toString());
    }

}
