package com.upm.mastermind;

import com.upm.utils.YesNoDialog;

public class ResumeAction extends Action{

    public ResumeAction(Session session) {
        super(session);
    }

    @Override
    public void execute() {
        assert this.getState() == State.LOSE || this.getState() == State.WINED;
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
            case WINED:
                Message.PLAYER_WIN.writeln();
                break;
            case LOSE:
                Message.PLAYER_LOSE.writeln();
        }
    }

    private boolean isResumedGame(){
        return new YesNoDialog().read(Message.RESUME.toString());
    }

}
