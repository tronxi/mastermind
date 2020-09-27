package com.upm.mastermind;

public class Logic {

    private final Session session;
    private final Action feedBackAction;
    private final Action makePatternAction;
    private final Action putPatternAction;
    private final Action resumeAction;

    public Logic() {
        this.session = new Session();
        feedBackAction = new FeedBackAction(session);
        makePatternAction = new MakePatternCodePegAction(session);
        putPatternAction = new PutPatternCodePegAction(session);
        resumeAction = new ResumeAction(session);
    }

    public Action getAction() {
        switch (this.session.getState()){
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
