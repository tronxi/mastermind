package com.upm.mastermind;

public class Logic {

    private final Session session;
    private final Action feedBackAction;
    private final Action makePatternAction;
    private final Action putPatternAction;
    private final Action resumeAction;

    public Logic() {
        this.session = new Session();
        this.feedBackAction = new FeedBackAction(session);
        this.makePatternAction = new MakePatternCodePegAction(session);
        this.putPatternAction = new PutPatternCodePegAction(session);
        this.resumeAction = new ResumeAction(session);
    }

    public Action getAction() {
        switch (session.getState()){
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
