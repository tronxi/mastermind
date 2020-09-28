package com.upm.mastermind;

public class Logic {

    private final Game game;
    private final Action feedBackAction;
    private final Action makePatternAction;
    private final Action putPatternAction;
    private final Action resumeAction;

    public Logic() {
        this.game = new Game();
        this.feedBackAction = new FeedBackAction(game);
        this.makePatternAction = new MakePatternCodePegAction(game);
        this.putPatternAction = new PutPatternCodePegAction(game);
        this.resumeAction = new ResumeAction(game);
    }

    public Action getAction() {
        switch (game.getState()){
            case INITIAL:
                return makePatternAction;
            case IN_GAME:
                return putPatternAction;
            case PENDING_FEEDBACK:
                return feedBackAction;
            case WON:
            case LOST:
                return resumeAction;
            case EXIT:
            default:
                return null;
        }
    }
}
