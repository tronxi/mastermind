package com.upm.mastermind;

import com.upm.utils.YesNoDialog;

public class ResumeAction extends Action {

    public ResumeAction(Game game) {
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
